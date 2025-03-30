package com.example.demo.dtos.internal;

public class AddUpdateRatingInternalDTO {
    private String rateReceiver;
    private String rateSender;
    private int rating;


    public String getRateReceiver() {
        return rateReceiver;
    }

    public void setRateReceiver(String rateReceiver) {
        this.rateReceiver = rateReceiver;
    }

    public String getRateSender() {
        return rateSender;
    }

    public void setRateSender(String rateSender) {
        this.rateSender = rateSender;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public AddUpdateRatingInternalDTO(String rateReceiver, String rateSender, int rating) {
        this.rateReceiver = rateReceiver;
        this.rateSender = rateSender;
        this.rating = rating;
    }

    public AddUpdateRatingInternalDTO() {
    }
}
