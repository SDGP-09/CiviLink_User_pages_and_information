package com.example.demo.dtos;

public class UserDTO {
    private Long id;
    private String name;
    private String location;
    private String profilePicture;
    private String companyName;
    private double ratings;
    private String ongoingWorks;
    private String hotDeals;
    private String completedWork;
    private boolean available;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getProfilePicture() {
        return profilePicture;
    }


    public String getCompanyName() {
        return companyName;
    }

    public double getRatings() {
        return ratings;
    }

    public String getOngoingWorks() {
        return ongoingWorks;
    }

    public String getHotDeals() {
        return hotDeals;
    }

    public String getCompletedWork() {
        return completedWork;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public void setOngoingWorks(String ongoingWorks) {
        this.ongoingWorks = ongoingWorks;
    }

    public void setHotDeals(String hotDeals) {
        this.hotDeals = hotDeals;
    }

    public void setCompletedWork(String completedWork) {
        this.completedWork = completedWork;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

