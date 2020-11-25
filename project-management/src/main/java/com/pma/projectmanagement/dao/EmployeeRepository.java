package com.pma.projectmanagement.dao;

import java.util.List;

import com.pma.projectmanagement.entities.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
}
