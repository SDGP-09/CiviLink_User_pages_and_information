package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hot_deals")
public class HotDeal {
        @Id
        private String title; // e.g., "Spring Special Offer"
        private String description; // e.g., "20% off on all residential projects"
        private Boolean isActive; // Whether the deal is enabled/disabled

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
