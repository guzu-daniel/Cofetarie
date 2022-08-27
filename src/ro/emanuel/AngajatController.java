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

import ro.emanuel.dao.AngajatDAO;
import ro.emanuel.pojo.Angajat;

@Controller
@RequestMapping(value="angajat")
public class AngajatController {
	
	@RequestMapping(value="lista.htm")
	public ModelAndView afisareAngajati() throws SQLException {
		
		ArrayList<Angajat> angajati = AngajatDAO.getAllAngajat();
		
		ModelMap model = new ModelMap();
		model.put("angajati", angajati);
		
		return new ModelAndView("/WEB-INF/angajat/lista.jsp","model",model);
	}
	
	@RequestMapping(value="detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException
	{
		
		Angajat a = AngajatDAO.getAngajatById(id);
		
		ModelMap model = new ModelMap();
		model.put("angajat", a);
		
		return new ModelAndView("/WEB-INF/angajat/detalii.jsp","model",model);
		
	}
	
	@RequestMapping(value="edit.htm")
	public ModelAndView angajatEdit(@RequestParam Integer id,Model model) throws SQLException
	{
		Angajat a = AngajatDAO.getAngajatById(id);
		model.addAttribute("angajatForm", a);
		
		return new ModelAndView("/WEB-INF/angajat/edit.jsp","model",model);
	}
	
	@RequestMapping(value="save.htm", method=RequestMethod.POST)
	public ModelAndView saveAngajat(@ModelAttribute("angajatForm") Angajat angajat, 
			ModelMap model, BindingResult result) {
		//stergem orice mesaj care s-ar putea afla pe model
		model.put("mesaj","");
		//salvare in baza de date a obiectului editat
		//obiectul editat se afla in contForm
		Angajat contObj;
		try {
			contObj = AngajatDAO.getAngajatById(angajat.getId());
			contObj.setNume(angajat.getNume());
			contObj.setPrenume(angajat.getPrenume());
			contObj.setAdresa(angajat.getAdresa());
			contObj.setTelefon(angajat.getTelefon());
			AngajatDAO.updateAngajat(contObj);
			
			model.put("angajatForm", angajat);
			model.put("mesaj","Detaliile Angajatului au fost salvate");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dupa salvare deschidere pagina de editare din nou cu noile detalii
		return new ModelAndView("/WEB-INF/angajat/edit.jsp","model",model);		
	}
	
	
	@RequestMapping(value = "/delete.htm")
	public ModelAndView deleteAngajat(@RequestParam Integer id, Model model)
			throws NumberFormatException, SQLException {

		AngajatDAO.deleteAngajat(id);
		ArrayList<Angajat> angajati=AngajatDAO.getAllAngajat();
		model.addAttribute("angajati", angajati);
		return new ModelAndView("/WEB-INF/angajat/lista.jsp",
				"model",model);
	}

	@RequestMapping(value = "/add.htm")
	public ModelAndView adaugaAngajat(Model model) throws NumberFormatException, SQLException {

		Angajat angajat = new Angajat();
		model.addAttribute("angajatForm", angajat);

		return new ModelAndView("/WEB-INF/angajat/add.jsp", "model", model);
	}

	@RequestMapping(value = "/add-save.htm", method = RequestMethod.POST)
	public ModelAndView addAngajat(@ModelAttribute("angajatForm") Angajat angajat, ModelMap model, BindingResult result) {

		try {
			AngajatDAO.insert(angajat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/angajat/lista.htm");
	}
	

}
