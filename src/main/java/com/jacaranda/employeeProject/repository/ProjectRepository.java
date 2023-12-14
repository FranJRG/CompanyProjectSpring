package com.jacaranda.employeeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.employeeProject.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
