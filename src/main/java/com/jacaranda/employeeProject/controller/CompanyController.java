package com.jacaranda.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.service.CompanyService;



@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@GetMapping("/")
	public String index() {
		return "testLayout";
	}
	
	@GetMapping("/listCompanies")
	public String getCompanies(Model model) {
		List<Company>listCompanies = companyService.getCompanies();
		model.addAttribute("listCompanies",listCompanies);
		
		return "listCompanies";
	}
	
	@GetMapping("/addCompany")
	public String addCompany(Model model) {
		Company company = new Company();
		model.addAttribute("company",company);
		return "addCompany";
	}
	
	@PostMapping("/addCompany")
	public String addCompany(@ModelAttribute Company company, Model model, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "addCompany";
		}else {
			companyService.addCompany(company);
			String result = "Company create correctly";
			model.addAttribute("result",result);
			return "results";
		}
		
	}
	
	
}
