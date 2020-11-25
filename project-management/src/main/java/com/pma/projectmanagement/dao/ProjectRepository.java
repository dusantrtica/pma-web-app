package com.pma.projectmanagement.dao;

import java.util.List;

import com.pma.projectmanagement.entities.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();
}
