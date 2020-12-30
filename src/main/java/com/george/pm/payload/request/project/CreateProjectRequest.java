package com.george.pm.payload.request.project;

public class CreateProjectRequest {

    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "CreateProjectRequest{" +
                "projectName='" + projectName + '\'' +
                '}';
    }
}
