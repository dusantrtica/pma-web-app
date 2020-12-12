package com.pma.projectmanagement.services;

import java.util.List;

import com.pma.projectmanagement.dao.ProjectRepository;
import com.pma.projectmanagement.dto.ChartData;
import com.pma.projectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository proRepo;

    public Project save(Project project) {
        return proRepo.save(project);
    }

    public List<Project> getAll() {
        return proRepo.findAll();
    }

    public List<ChartData> getProjectStatus() {
        return proRepo.getProjectStatus();
    }
}
