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

import ro.emanuel.dao.PrajituraDAO;
import ro.emanuel.pojo.Prajitura;

@Controller
@RequestMapping(value="prajitura")
public class PrajituraController {
	
	@RequestMapping(value="lista.htm")
	public ModelAndView afisarePrajitura() throws SQLException {
		
		ArrayList<Prajitura> prajituri = PrajituraDAO.getAllPrajitura();
		
		ModelMap model = new ModelMap();
		model.put("prajituri", prajituri);
		
		return new ModelAndView("/WEB-INF/prajitura/lista.jsp","model",model);
	}
	
	@RequestMapping(value="detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException
	{
		
		Prajitura a = PrajituraDAO.getPrajituraById(id);
		
		ModelMap model = new ModelMap();
		model.put("prajitura", a);
		
		return new ModelAndView("/WEB-INF/prajitura/detalii.jsp","model",model);
		
	}
	
	@RequestMapping(value="edit.htm")
	public ModelAndView prajituraEdit(@RequestParam Integer id,Model model) throws SQLException
	{
		Prajitura a = PrajituraDAO.getPrajituraById(id);
		model.addAttribute("prajituraForm", a);
		
		return new ModelAndView("/WEB-INF/prajitura/edit.jsp","model",model);
	}
	
	@RequestMapping(value="save.htm", method=RequestMethod.POST)
	public ModelAndView savePrajitura(@ModelAttribute("prajituraForm") Prajitura prajitura, 
			ModelMap model, BindingResult result) {
		//stergem orice mesaj care s-ar putea afla pe model
		model.put("mesaj","");
		//salvare in baza de date a obiectului editat
		//obiectul editat se afla in contForm
		Prajitura contObj;
		try {
			contObj = PrajituraDAO.getPrajituraById(prajitura.getId());
			contObj.setNume(prajitura.getNume());
			contObj.setDescriere(prajitura.getDescriere());
			contObj.setPret(prajitura.getPret());
			contObj.setImagine(prajitura.getImagine());
			PrajituraDAO.updatePrajitura(contObj);
			
			model.put("prajituraForm", prajitura);
			model.put("mesaj","Detaliile Prajiturii au fost salvate");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dupa salvare deschidere pagina de editare din nou cu noile detalii
		return new ModelAndView("/WEB-INF/prajitura/edit.jsp","model",model);		
	}
	
	
	@RequestMapping(value = "/delete.htm")
	public ModelAndView deletePrajitura(@RequestParam Integer id, Model model)
			throws NumberFormatException, SQLException {

		PrajituraDAO.deletePrajitura(id);
		ArrayList<Prajitura> prajituri = PrajituraDAO.getAllPrajitura();
		model.addAttribute("prajituri", prajituri);
		return new ModelAndView("/WEB-INF/prajitura/lista.jsp",
				"model",model);
	}

	@RequestMapping(value = "/add.htm")
	public ModelAndView adaugaPrajitura(Model model) throws NumberFormatException, SQLException {

		Prajitura prajitura = new Prajitura();
		model.addAttribute("prajituraForm", prajitura);

		return new ModelAndView("/WEB-INF/prajitura/add.jsp", "model", model);
	}

	@RequestMapping(value = "/add-save.htm", method = RequestMethod.POST)
	public ModelAndView addPrajitura(@ModelAttribute("prajituraForm") Prajitura prajitura, ModelMap model, BindingResult result) {

		try {
			PrajituraDAO.insert(prajitura);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/prajitura/lista.htm");
	}
	

}
