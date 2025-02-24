package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "availability")
public class Availability {
    @Id
    private String id;
    private String status; // Available / Unavailable

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
