package com.george.pm.payload.response.project;

import com.george.pm.models.project.ProjectTask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateProjectResponse {

    private boolean success;

    private String projectName;

    private String projectId;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
