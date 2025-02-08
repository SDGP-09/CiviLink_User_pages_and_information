package com.example.demo.entities;
import jakarta.persistence.*;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("contractor")
public class Contractor extends User {
    private String companyName;
    private double ratings;
    private String ongoingWorks;
    private String hotDeals;
    private String completedWork;

    public Contractor() {
    }

    public Contractor(String companyName, double ratings, String ongoingWorks, String hotDeals, String completedWork) {
        this.companyName = companyName;
        this.ratings = ratings;
        this.ongoingWorks = ongoingWorks;
        this.hotDeals = hotDeals;
        this.completedWork = completedWork;
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
}

