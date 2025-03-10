package com.example.demo.entities;

import jakarta.persistence.*;

@Entity

public class Rating {
    @Id
    private long id;

    private int one;
    private int two;
    private int three;
    private int four;
    private int five;

    @ManyToOne
    @JoinColumn(
            name = "contractor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_rating_contractor")
    )
    private Contractor contractor;

    public Rating() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getThree() {
        return three;
    }

    public void setThree(int three) {
        this.three = three;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }


    public Rating(long id, int one, int two, int three, int four, int five, Contractor contractor) {
        this.id = id;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.contractor = contractor;
    }
}
