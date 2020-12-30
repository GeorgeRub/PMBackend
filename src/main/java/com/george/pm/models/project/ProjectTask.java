package com.george.pm.models.project;

import com.george.pm.models.BaseEntity;
import com.george.pm.models.auth.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProjectTask extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "task_id")
    private String id;


    @Column(name = "task_name")
    private String projectName;

    @ManyToOne(targetEntity = Project.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
