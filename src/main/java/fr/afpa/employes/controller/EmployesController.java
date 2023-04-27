package fr.afpa.employes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.afpa.employes.bean.Employes;
import fr.afpa.employes.service.EmployesService;
import jakarta.validation.Valid;

@Controller
public class EmployesController {
	
	
	@Autowired
	private EmployesService employesService;
	
	@GetMapping("/")
	public String employes(Model model, Employes employes) {

		model.addAttribute("employesList", employesService.showEmployes());
		return "employes";
	}
	

    //
	
	@PostMapping("/")
	public String employes(@Valid Employes employes, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.err.println("Error....");
			getEmployeesList(model);
			return "employes";
			
		}else {
			employesService.AddEmploye(employes);
			return "employes";
		}
	
	}
	
	public void getEmployeesList(Model model) {
        if (employesService.showEmployes().size() > 0) {
            model.addAttribute("employeesList", employesService.showEmployes());
        }
    }
	
}
