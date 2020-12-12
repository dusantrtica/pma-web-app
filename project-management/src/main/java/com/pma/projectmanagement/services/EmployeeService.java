package com.pma.projectmanagement.services;

import java.util.List;

import com.pma.projectmanagement.dao.EmployeeRepository;
import com.pma.projectmanagement.dto.EmployeeProject;
import com.pma.projectmanagement.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public Employee save(Employee employee) {
        return empRepo.save(employee);
    }

    public List<Employee> getAll() {
        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects() {
        return empRepo.employeeProjects();
    }
}
