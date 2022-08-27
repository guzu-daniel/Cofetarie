package ro.emanuel;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.dao.TortDAO;
import ro.emanuel.pojo.Tort;

@Controller
@RequestMapping(value="tort")
public class TortController {
	
	@RequestMapping(value="lista.htm")
	public ModelAndView afisareTort() throws SQLException {
		
		ArrayList<Tort> torturi = TortDAO.getAllTort();
		
		ModelMap model = new ModelMap();
		model.put("torturi", torturi);
		
		return new ModelAndView("/WEB-INF/tort/lista.jsp","model",model);
	}
	
	@RequestMapping(value="detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException
	{
		
		Tort a = TortDAO.getTortById(id);
		
		ModelMap model = new ModelMap();
		model.put("tort", a);
		
		return new ModelAndView("/WEB-INF/tort/detalii.jsp","model",model);
		
	}
	
	@RequestMapping(value="edit.htm")
	public ModelAndView tortEdit(@RequestParam Integer id,Model model) throws SQLException
	{
		Tort a = TortDAO.getTortById(id);
		model.addAttribute("tortForm", a);
		
		return new ModelAndView("/WEB-INF/tort/edit.jsp","model",model);
	}
	
	@RequestMapping(value="save.htm", method=RequestMethod.POST)
	public ModelAndView saveTort(@ModelAttribute("tortForm") Tort tort, 
			ModelMap model, BindingResult result) {
		//stergem orice mesaj care s-ar putea afla pe model
		model.put("mesaj","");
		//salvare in baza de date a obiectului editat
		//obiectul editat se afla in contForm
		Tort contObj;
		try {
			contObj = TortDAO.getTortById(tort.getId());
			contObj.setNume(tort.getNume());
			contObj.setDescriere(tort.getDescriere());
			contObj.setPret(tort.getPret());
			contObj.setImagine(tort.getImagine());
			TortDAO.updateTort(contObj);
			
			model.put("tortForm", tort);
			model.put("mesaj","Detaliile Tortului au fost salvate");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dupa salvare deschidere pagina de editare din nou cu noile detalii
		return new ModelAndView("/WEB-INF/tort/edit.jsp","model",model);		
	}
	
	
	@RequestMapping(value = "/delete.htm")
	public ModelAndView deleteTort(@RequestParam Integer id, Model model)
			throws NumberFormatException, SQLException {

		TortDAO.deleteTort(id);
		ArrayList<Tort> torturi=TortDAO.getAllTort();
		model.addAttribute("torturi", torturi);
		return new ModelAndView("/WEB-INF/tort/lista.jsp",
				"model",model);
	}

	@RequestMapping(value = "/add.htm")
	public ModelAndView adaugaTort(Model model) throws NumberFormatException, SQLException {

		Tort tort = new Tort();
		model.addAttribute("tortForm", tort);

		return new ModelAndView("/WEB-INF/tort/add.jsp", "model", model);
	}

	@RequestMapping(value = "/add-save.htm", method = RequestMethod.POST)
	public ModelAndView addTort(@ModelAttribute("tortForm") Tort tort, ModelMap model, BindingResult result) {

		try {
			TortDAO.insert(tort);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/tort/lista.htm");
	}
	

}
