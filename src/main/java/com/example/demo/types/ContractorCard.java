package com.example.demo.types;

public class ContractorCard {
    private Long id;
    private String name;
    private Integer rating;
    private String profilePicture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public ContractorCard(Long id, String name, Integer rating, String profilePicture) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.profilePicture = profilePicture;
    }

    public ContractorCard(){}

}
