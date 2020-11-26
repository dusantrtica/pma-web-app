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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        return "/projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        List<Employee> employees = empRepo.findAll();

        model.addAttribute("project", new Project());
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        // This should handle single saving to the database
        proRepo.save(project);

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
