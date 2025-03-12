package com.example.demo.dtos.request;

public class AddUpdateRatingDTO {
    private Long rateReceiver;
    private Long rateSender;
    private int rating;


    public Long getRateReceiver() {
        return rateReceiver;
    }

    public void setRateReceiver(Long rateReceiver) {
        this.rateReceiver = rateReceiver;
    }

    public Long getRateSender() {
        return rateSender;
    }

    public void setRateSender(Long rateSender) {
        this.rateSender = rateSender;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public AddUpdateRatingDTO(Long rateReceiver, Long rateSender, int rating) {
        this.rateReceiver = rateReceiver;
        this.rateSender = rateSender;
        this.rating = rating;
    }

    public AddUpdateRatingDTO() {
    }
}
