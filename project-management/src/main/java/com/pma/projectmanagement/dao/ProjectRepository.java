package com.pma.projectmanagement.dao;

import com.pma.projectmanagement.entities.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
