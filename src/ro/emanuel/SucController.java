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

import ro.emanuel.dao.SucDAO;
import ro.emanuel.pojo.Suc;

@Controller
@RequestMapping(value="suc")
public class SucController {
	
	@RequestMapping(value="lista.htm")
	public ModelAndView afisareSuc() throws SQLException {
		
		ArrayList<Suc> sucuri = SucDAO.getAllSuc();
		
		ModelMap model = new ModelMap();
		model.put("sucuri", sucuri);
		
		return new ModelAndView("/WEB-INF/suc/lista.jsp","model",model);
	}
	
	@RequestMapping(value="detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException
	{
		
		Suc a = SucDAO.getSucById(id);
		
		ModelMap model = new ModelMap();
		model.put("suc", a);
		
		return new ModelAndView("/WEB-INF/suc/detalii.jsp","model",model);
		
	}
	
	@RequestMapping(value="edit.htm")
	public ModelAndView sucEdit(@RequestParam Integer id,Model model) throws SQLException
	{
		Suc a = SucDAO.getSucById(id);
		model.addAttribute("sucForm", a);
		
		return new ModelAndView("/WEB-INF/suc/edit.jsp","model",model);
	}
	
	@RequestMapping(value="save.htm", method=RequestMethod.POST)
	public ModelAndView saveSuc(@ModelAttribute("sucForm") Suc suc, 
			ModelMap model, BindingResult result) {
		//stergem orice mesaj care s-ar putea afla pe model
		model.put("mesaj","");
		//salvare in baza de date a obiectului editat
		//obiectul editat se afla in contForm
		Suc contObj;
		try {
			contObj = SucDAO.getSucById(suc.getId());
			contObj.setNume(suc.getNume());
			contObj.setDescriere(suc.getDescriere());
			contObj.setPret(suc.getPret());
			contObj.setImagine(suc.getImagine());
			SucDAO.updateSuc(contObj);
			
			model.put("sucForm", suc);
			model.put("mesaj","Detaliile Sucului au fost salvate");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dupa salvare deschidere pagina de editare din nou cu noile detalii
		return new ModelAndView("/WEB-INF/suc/edit.jsp","model",model);		
	}
	
	
	@RequestMapping(value = "/delete.htm")
	public ModelAndView deleteSuc(@RequestParam Integer id, Model model)
			throws NumberFormatException, SQLException {

		SucDAO.deleteSuc(id);
		ArrayList<Suc> sucuri=SucDAO.getAllSuc();
		model.addAttribute("sucuri", sucuri);
		return new ModelAndView("/WEB-INF/suc/lista.jsp",
				"model",model);
	}

	@RequestMapping(value = "/add.htm")
	public ModelAndView adaugaSuc(Model model) throws NumberFormatException, SQLException {

		Suc suc = new Suc();
		model.addAttribute("sucForm", suc);

		return new ModelAndView("/WEB-INF/suc/add.jsp", "model", model);
	}

	@RequestMapping(value = "/add-save.htm", method = RequestMethod.POST)
	public ModelAndView addSuc(@ModelAttribute("sucForm") Suc suc, ModelMap model, BindingResult result) {

		try {
			SucDAO.insert(suc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/suc/lista.htm");
	}
	

}
