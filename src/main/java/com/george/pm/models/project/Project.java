package com.george.pm.models.project;

import javax.persistence.*;

import com.george.pm.models.BaseEntity;
import com.george.pm.models.auth.User;
import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;

import java.util.*;

@Entity
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "project_id")
    private String id;

    @Column(name = "project_name")
    private String projectName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "project_id", updatable = false, insertable = false)
//    private User owner;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User owner;

    @ManyToMany(mappedBy = "projects")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectTask> tasks;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<ProjectTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<ProjectTask> tasks) {
        this.tasks = tasks;
    }
}
