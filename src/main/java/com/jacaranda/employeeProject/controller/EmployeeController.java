package com.jacaranda.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/listEmployees")
	public String getEmployees(Model model) {
		List<Employee>employees = employeeService.findAllEmployees();
		model.addAttribute("employees", employees);
		return "listEmployees";
	}
	

}
