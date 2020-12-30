package com.george.pm.services.project;

import com.george.pm.models.project.ProjectTask;
import com.george.pm.repositories.project.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask save(ProjectTask project) {
        project.setId(UUID.randomUUID().toString());
        return projectTaskRepository.save(project);
    }

    public ProjectTask getById(String id) {
        return projectTaskRepository.getOne(id);
    }

}
