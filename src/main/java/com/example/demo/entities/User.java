package com.example.demo.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String location;
//    private String profilePicture; // Cloudinary URL
//
//    private String companyName;
//    private double ratings;
//    private String ongoingWorks;
//    private String hotDeals;
//    private String completedWork;
//    private boolean available;
//
//    public User() {}
//
//    public User(String name, String location, String profilePicture, String companyName,
//                double ratings, String ongoingWorks, String hotDeals, String completedWork,
//                boolean available) {
//        this.name = name;
//        this.location = location;
//        this.profilePicture = profilePicture;
//        this.companyName = companyName;
//        this.ratings = ratings;
//        this.ongoingWorks = ongoingWorks;
//        this.hotDeals = hotDeals;
//        this.completedWork = completedWork;
//        this.available = available;
//    }
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getLocation() { return location; }
//    public void setLocation(String location) { this.location = location; }
//
//    public String getProfilePicture() { return profilePicture; }
//    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }
//
//    public String getCompanyName() { return companyName; }
//    public void setCompanyName(String companyName) { this.companyName = companyName; }
//
//    public double getRatings() { return ratings; }
//    public void setRatings(double ratings) { this.ratings = ratings; }
//
//    public String getOngoingWorks() { return ongoingWorks; }
//    public void setOngoingWorks(String ongoingWorks) { this.ongoingWorks = ongoingWorks; }
//
//    public String getHotDeals() { return hotDeals; }
//    public void setHotDeals(String hotDeals) { this.hotDeals = hotDeals; }
//
//    public String getCompletedWork() { return completedWork; }
//    public void setCompletedWork(String completedWork) { this.completedWork = completedWork; }
//
//    public boolean isAvailable() { return available; }
//    public void setAvailable(boolean available) { this.available = available; }
//}

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String location;
    private Double rating;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Availability availability;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
