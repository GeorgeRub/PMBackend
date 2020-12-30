package com.george.pm.services.project;

import com.george.pm.models.project.Project;
import com.george.pm.repositories.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project) {
        project.setId(UUID.randomUUID().toString());
        return projectRepository.save(project);
    }

    public Project getById(String id) {
        return projectRepository.getOne(id);
    }
}
