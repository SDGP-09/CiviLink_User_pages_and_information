package com.example.demo.entities;



import jakarta.persistence.*;

@Entity
@Table(name = "contractors")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String companyName;

    private Double rating;
    private String profilePicture; // URL of the contractor's profile picture
    private String availableServices;

    // Constructors
    public Contractor() {}

    public Contractor(String name, String location, String companyName, Double rating, String profilePicture, String availableServices) {
        this.name = name;
        this.location = location;
        this.companyName = companyName;
        this.rating = rating;
        this.profilePicture = profilePicture;
        this.availableServices = availableServices;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }

    public String getAvailableServices() { return availableServices; }
    public void setAvailableServices(String availableServices) { this.availableServices = availableServices; }
}
