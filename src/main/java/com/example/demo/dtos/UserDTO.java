package com.example.demo.dtos;

public class UserDTO {
    private Long id;
    private String name;
    private String location;
    private String profilePicture;
    private String userType;

    private String companyName;
    private double ratings;
    private String ongoingWorks;
    private String hotDeals;
    private String completedWork;

    private String specialization;
    private String qualifications;
    private String services;
    private double minProjectValue;
    private double professionalFee;
    private double platformFee;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String location, String profilePicture, String userType) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.profilePicture = profilePicture;
        this.userType = userType;
    }

    // Full Constructor (Optional, if needed)
    public UserDTO(Long id, String name, String location, String profilePicture, String userType,
                   String companyName, double ratings, String ongoingWorks, String hotDeals, String completedWork,
                   String specialization, String qualifications, String services, double minProjectValue,
                   double professionalFee, double platformFee) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.profilePicture = profilePicture;
        this.userType = userType;
        this.companyName = companyName;
        this.ratings = ratings;
        this.ongoingWorks = ongoingWorks;
        this.hotDeals = hotDeals;
        this.completedWork = completedWork;
        this.specialization = specialization;
        this.qualifications = qualifications;
        this.services = services;
        this.minProjectValue = minProjectValue;
        this.professionalFee = professionalFee;
        this.platformFee = platformFee;
    }

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

    public String getUserType() {
        return userType;
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

    public String getSpecialization() {
        return specialization;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getServices() {
        return services;
    }

    public double getMinProjectValue() {
        return minProjectValue;
    }

    public double getProfessionalFee() {
        return professionalFee;
    }

    public double getPlatformFee() {
        return platformFee;
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

    public void setUserType(String userType) {
        this.userType = userType;
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

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setMinProjectValue(double minProjectValue) {
        this.minProjectValue = minProjectValue;
    }

    public void setProfessionalFee(double professionalFee) {
        this.professionalFee = professionalFee;
    }

    public void setPlatformFee(double platformFee) {
        this.platformFee = platformFee;
    }
}

