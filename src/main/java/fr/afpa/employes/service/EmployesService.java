package fr.afpa.employes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.afpa.employes.Repository.EmployesRepository;
import fr.afpa.employes.bean.Employes;

@Service
public class EmployesService {
	@Autowired
	private EmployesRepository employesRepository;
	
	public void AddEmploye(Employes employes) {
		employesRepository.save(employes);
	}

	public List<Employes> showEmployes() {
		
		return employesRepository.findAll();
	}

	
}
