package com.pma.projectmanagement.controllers;

import java.util.List;

import com.pma.projectmanagement.dao.EmployeeRepository;
import com.pma.projectmanagement.dao.ProjectRepository;
import com.pma.projectmanagement.entities.Employee;
import com.pma.projectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = proRepo.findAll();
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        return "main/home";
    }
}
