package com.example.demo.dtos.request;

public class AddUpdateRequestDTO {

    private Long rateReceiver;

    private int rating;


    public Long getRateReceiver() {
        return rateReceiver;
    }

    public void setRateReceiver(Long rateReceiver) {
        this.rateReceiver = rateReceiver;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public AddUpdateRequestDTO(Long rateReceiver, int rating) {
        this.rateReceiver = rateReceiver;
        this.rating = rating;
    }

    public AddUpdateRequestDTO(){}
}
