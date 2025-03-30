package com.example.demo.entities;

import com.example.demo.enums.ContractorField;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contractor {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;


    private String companyName;

    @OneToMany(mappedBy = "contractor")
    private List<Rating> rating;

    @OneToMany(mappedBy = "contractor")
    private List<Deal> deals;

    private String profilePicture; // URL of the contractor's profile picture

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractorField field;

    @OneToMany(mappedBy = "contractor")
    private List<Project> projects;

    // Constructors
    public Contractor() {}

    public Contractor(String id, String name, String location, String companyName, ContractorField field) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.companyName = companyName;
        this.field = field;
    }

    public Contractor(
            String id,
            String name,
            String location,
            String companyName,
            List<Rating> rating,
            List<Deal> deals,
            String profilePicture,
            ContractorField field,
            List<Project> projects
    ) {

        this.id = id;
        this.name = name;
        this.location = location;
        this.companyName = companyName;
        this.rating = rating;
        this.deals = deals;
        this.profilePicture = profilePicture;
        this.field = field;
        this.projects = projects;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }

    public ContractorField getField() { return field; }
    public void setField(ContractorField availableServices) { this.field = availableServices; }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
