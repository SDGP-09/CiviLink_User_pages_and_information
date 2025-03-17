package com.example.demo.dtos.response;

import com.example.demo.types.MiniDealPortable;

import java.util.Map;

public class CompanyDetailsResponseDTO {

    private String name;
    private String location;
    private String profileImage;
    private Map<Integer, Integer> ratings;
    private MiniDealPortable[] hotDeals;


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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Map<Integer, Integer> getRatings() {
        return ratings;
    }

    public void setRatings(Map<Integer, Integer> ratings) {
        this.ratings = ratings;
    }

    public MiniDealPortable[] getHotDeals() {
        return hotDeals;
    }

    public void setHotDeals(MiniDealPortable[] hotDeals) {
        this.hotDeals = hotDeals;
    }

    public CompanyDetailsResponseDTO(
            String name,
            String location,
            String profileImage,
            Map<Integer, Integer> ratings,
            MiniDealPortable[] hotDeals
    ) {
        this.name = name;
        this.location = location;
        this.profileImage = profileImage;
        this.ratings = ratings;
        this.hotDeals = hotDeals;
    }

    public CompanyDetailsResponseDTO(){}
}
