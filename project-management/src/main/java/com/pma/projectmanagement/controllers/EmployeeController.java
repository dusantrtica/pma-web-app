package com.pma.projectmanagement.controllers;

import java.util.List;

import com.pma.projectmanagement.dao.EmployeeRepository;
import com.pma.projectmanagement.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());

        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        employeeRepo.save(employee);
        return "redirect:/employees/new";
    }
}