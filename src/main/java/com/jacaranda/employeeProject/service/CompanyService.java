package com.jacaranda.employeeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company>getCompanies(){
		return companyRepository.findAll();
	}
	
	public void addCompany(Company c) {
		companyRepository.save(c);
	}
	
	public Company findCompany(Integer id) {
		return companyRepository.findById(id).orElse(null);
	}
	
}
