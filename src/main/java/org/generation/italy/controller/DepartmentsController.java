package org.generation.italy.controller;

import org.generation.italy.model.Department;
import org.generation.italy.repository.DegreesRepository;
import org.generation.italy.repository.DepartmentsRepoistory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DepartmentsController {
	
	@Autowired
	private DepartmentsRepoistory repository;
	
	
	
	@GetMapping
	public String departments(Model model) {
		model.addAttribute("departments", repository.findAll());
		return "departments";
	}
	
	
	@Autowired
	private DegreesRepository degreeRepository;
	@GetMapping("/degrees/{id}")
	public String degrees(Model model, @PathVariable Integer id) {
		model.addAttribute("degree", degreeRepository.findAll());
		model.addAttribute("degreesId", id);
		
		
		return "degrees";
	}
	
	
}
