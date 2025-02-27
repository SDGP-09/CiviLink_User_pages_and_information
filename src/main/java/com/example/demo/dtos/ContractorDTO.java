package com.example.demo.dtos;

public class ContractorDTO {
    private String name;
    private String location;
    private String companyName;
    private Double rating;
    private String profilePicture;

    // Constructors
    public ContractorDTO() {}

    public ContractorDTO(String name, String location, String companyName, Double rating, String profilePicture) {
        this.name = name;
        this.location = location;
        this.companyName = companyName;
        this.rating = rating;
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
