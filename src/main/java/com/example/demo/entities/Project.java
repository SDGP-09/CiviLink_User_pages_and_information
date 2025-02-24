package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    private String id;
    private String name;
    private String status; // Ongoing, Completed
    private int progress;
    private String description;

    public Project() {}

    public Project(String name, String status, int progress, String description) {
        this.name = name;
        this.status = status;
        this.progress = progress;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
