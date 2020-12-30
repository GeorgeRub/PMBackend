package com.george.pm.payload.response.project;

import com.george.pm.models.project.ProjectTask;

import java.util.ArrayList;
import java.util.List;

/**
 * This class responds answer to front with information about a Project and his tasks
 */
public class ShowProject {

    private String projectName;

    private String projectId;

    private List<ProjectTask> taskList = new ArrayList<>();

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<ProjectTask> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<ProjectTask> taskList) {
        this.taskList = taskList;
    }
}
