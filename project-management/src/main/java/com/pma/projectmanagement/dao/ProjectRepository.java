package com.pma.projectmanagement.dao;

import java.util.List;

import com.pma.projectmanagement.dto.ChartData;
import com.pma.projectmanagement.entities.Project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value FROM project GROUP BY stage")
    public List<ChartData> getProjectStatus();
}
