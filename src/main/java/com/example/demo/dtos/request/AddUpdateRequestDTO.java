package com.example.demo.dtos.request;

public class AddUpdateRequestDTO {

    private String rateReceiver;

    private int rating;


    public String getRateReceiver() {
        return rateReceiver;
    }

    public void setRateReceiver(String rateReceiver) {
        this.rateReceiver = rateReceiver;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public AddUpdateRequestDTO(String rateReceiver, int rating) {
        this.rateReceiver = rateReceiver;
        this.rating = rating;
    }

    public AddUpdateRequestDTO(){}
}
