package com.jacaranda.employeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacaranda.employeeProject.model.Project;
import com.jacaranda.employeeProject.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/listProjects")
	public String findProject(Model model) {
		List<Project>projects = projectService.findAll();
		model.addAttribute("projects",projects);
		return "listProjects";
	}
	
}
