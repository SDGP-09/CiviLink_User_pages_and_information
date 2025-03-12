package com.example.demo.entities;

import jakarta.persistence.*;

@Entity

public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int rating;

    private Long senderId;


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

    public Long getSenderId() {
        return senderId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Rating(int rating, Contractor contractor, Long sendingId) {

        this.rating = rating;

        this.contractor = contractor;

        this.senderId = sendingId;
    }
}
