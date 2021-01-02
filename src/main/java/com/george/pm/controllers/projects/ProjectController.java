package com.george.pm.controllers.projects;

import com.george.pm.models.auth.User;
import com.george.pm.models.project.Project;
import com.george.pm.payload.request.project.CreateProjectRequest;
import com.george.pm.payload.response.project.CreateProjectResponse;
import com.george.pm.payload.response.project.ShortProject;
import com.george.pm.payload.response.project.ShowProject;
import com.george.pm.repositories.auth.UserRepository;
import com.george.pm.services.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final UserRepository userRepository;

    private final ProjectService projectService;

    @Autowired
    public ProjectController(UserRepository userRepository, ProjectService projectService) {
        this.userRepository = userRepository;
        this.projectService = projectService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ShortProject> getProjects(Principal principal) {
        List<ShortProject> projects = new ArrayList<>();
        User user = userRepository.findByUsernameOne(principal.getName());
        if (user.getProjectsOwner() != null && !user.getProjectsOwner().isEmpty()) {
            System.out.println(user.getProjectsOwner().size());
            for (Project project : user.getProjectsOwner()) {
                ShortProject shortProject = new ShortProject();
                shortProject.setProjectId(project.getId());
                shortProject.setProjectName(project.getProjectName());
                shortProject.setProjectMembers(project.getUsers());
                projects.add(shortProject);
            }
        }
        return projects;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public CreateProjectResponse createProject(@RequestBody CreateProjectRequest createProjectRequest, Principal principal) {
        User user = userRepository.findByUsernameOne(principal.getName());
        CreateProjectResponse response = new CreateProjectResponse();
        response.setProjectName(createProjectRequest.getProjectName());
        Project project = new Project();
        project.setProjectName(createProjectRequest.getProjectName());
        project.setOwner(user);
        project.getUsers().add(user);

        project = projectService.save(project);
        if (project.getId() != null) {
//            user.getProjectsOwner().add(project);
//            user.getProjects().add(project);
            userRepository.save(user);
            response.setProjectId(project.getId());
            response.setSuccess(true);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ShowProject showProject(@PathVariable String id) {
        ShowProject showProject = new ShowProject();
        Project project = projectService.getById(id);
        showProject.setProjectName(project.getProjectName());
        showProject.setProjectId(project.getId());
        return showProject;
    }

}
