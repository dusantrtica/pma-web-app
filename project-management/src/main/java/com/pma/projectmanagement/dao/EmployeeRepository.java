package com.pma.projectmanagement.dao;

import com.pma.projectmanagement.entities.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
