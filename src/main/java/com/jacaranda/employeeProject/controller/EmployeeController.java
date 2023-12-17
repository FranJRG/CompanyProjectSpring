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
import com.jacaranda.employeeProject.model.Employee;
import com.jacaranda.employeeProject.service.CompanyService;
import com.jacaranda.employeeProject.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompanyService companyService;
	
	
	@GetMapping("/listEmployees")
	public String getEmployees(Model model) {
		List<Employee>employees = employeeService.findAllEmployees();
		model.addAttribute("employees", employees);
		return "listEmployees";
	}
	
	@GetMapping("/addEmployee")
	public String getAddEmployees(Model model) {
		Employee employee = new Employee();
		List<Company>companies = companyService.getCompanies();
		model.addAttribute("employee",employee);
		model.addAttribute("companies",companies);
		return "addEmployee";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee, Model model, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "addEmployee";
		}else {
			employeeService.addEmployee(employee);
			String result = "Employee added correctly";
			model.addAttribute("result",result);
			return "results";
		}
		
	}
	
	@GetMapping("/editEmployee")
	public String getEditEmployee(Model model,@RequestParam("id")int id) {
		Employee employee = employeeService.getEmployee(id);
		List<Company>companies = companyService.getCompanies();
		model.addAttribute("employee",employee);
		model.addAttribute("companies",companies);
		return "editEmployee";
	}
	
	@PostMapping("/editEmployee")
	public String editEmployee(Model model,@ModelAttribute Employee employee,BindingResult bindingResult) {
		
		String result = "";
		
		if(bindingResult.hasErrors()) {
			return "editEmployee";
		}else {
			Employee employeeEdit = new Employee();
			
			employeeEdit.setId(employee.getId());
			employeeEdit.setFirstName(employee.getFirstName());
			employeeEdit.setLastName(employee.getLastName());
			employeeEdit.setEmail(employee.getEmail());
			employeeEdit.setGender(employee.getGender());
			employeeEdit.setDateOfBirth(employee.getDateOfBirth());
			employeeEdit.setIdCompany(employee.getIdCompany());
			employeeEdit.setRol(employee.getRol());
			
			employeeService.addEmployee(employeeEdit);
			result="Employee edited succesfully";
			model.addAttribute("result",result);
			return "results";
		}
		
	}
	

}
