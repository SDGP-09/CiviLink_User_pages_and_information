package com.example.demo.entities;

import jakarta.persistence.*;

@Entity

public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int rating;


    @ManyToOne
    @JoinColumn(
            name = "Contractor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_rating_contractor")
    )
    private Contractor contractor;

    public Rating() {

    }

    public long getId() {
        return id;
    }



    public int getOne() {
        return rating;
    }

    public void setOne(int rating) {
        this.rating = rating;
    }



    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }


    public Rating(int rating, Contractor contractor) {

        this.rating = rating;

        this.contractor = contractor;
    }
}
