package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class DealImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String image;

    @ManyToOne
    @JoinColumn(
            name = "Deal_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_dealImage_deal")
    )
    private Deal deal;

    public DealImage() {

    }

    public long getId() {
        return id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public DealImage(String image, Deal deal) {

        this.image = image;
        this.deal = deal;
    }


}
