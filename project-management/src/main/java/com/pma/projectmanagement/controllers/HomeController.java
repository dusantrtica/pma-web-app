package com.pma.projectmanagement.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pma.projectmanagement.dao.EmployeeRepository;
import com.pma.projectmanagement.dao.ProjectRepository;
import com.pma.projectmanagement.dto.ChartData;
import com.pma.projectmanagement.dto.EmployeeProject;
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
    public String displayHome(Model model) throws JsonProcessingException {
        List<Project> projects = proRepo.findAll();
        List<EmployeeProject> employeesListProjectCount = employeeRepo.employeeProjects();
        Map<String, Object> map = new HashMap<>();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = proRepo.getProjectStatus();

        // Lets convert projectData object into a json structure for use javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);

        model.addAttribute("employeesListProjectCount", employeesListProjectCount);
        model.addAttribute("projectStatusCount", jsonString);
        return "main/home";
    }
}
