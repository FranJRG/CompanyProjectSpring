package com.jacaranda.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/addEmployee")
	public String getAddEmployees(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "addEmployee";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployees(Model model, @ModelAttribute Employee employee, BindingResult bindingResult) {
		
		String result = "";
		
		if(!bindingResult.hasErrors()) {
			employeeService.addEmployee(employee);
			result = "Employee added correctly";
			model.addAttribute("result",result);
			return "results";
		}
		
		return "addEmployee";
	}
	

}
