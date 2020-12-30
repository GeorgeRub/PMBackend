package com.george.pm.payload.response.project;

import com.george.pm.models.auth.User;

import java.util.List;

public class ShortProject {

    private String projectName;
    private String projectId;
    private List<User> projectMembers;

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

    public List<User> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(List<User> projectMembers) {
        this.projectMembers = projectMembers;
    }
}
