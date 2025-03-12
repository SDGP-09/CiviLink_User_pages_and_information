package com.example.demo.dtos.response;

public class RatingSummeryResponseDTO {

    private int meanRating;
    private int Ones;
    private int Twos;
    private int Threes;
    private int Fours;
    private int Fives;


    public int getMeanRating() {
        return meanRating;
    }

    public void setMeanRating(int meanRating) {
        this.meanRating = meanRating;
    }

    public int getOnes() {
        return Ones;
    }

    public void setOnes(int ones) {
        Ones = ones;
    }

    public int getTwos() {
        return Twos;
    }

    public void setTwos(int twos) {
        Twos = twos;
    }

    public int getThrees() {
        return Threes;
    }

    public void setThrees(int threes) {
        Threes = threes;
    }

    public int getFours() {
        return Fours;
    }

    public void setFours(int fours) {
        Fours = fours;
    }

    public int getFives() {
        return Fives;
    }

    public void setFives(int fives) {
        Fives = fives;
    }

    public RatingSummeryResponseDTO() {

    }

    public RatingSummeryResponseDTO(
            int meanRating,
            int ones,
            int twos,
            int threes,
            int fours,
            int fives
    ) {
        this.meanRating = meanRating;
        Ones = ones;
        Twos = twos;
        Threes = threes;
        Fours = fours;
        Fives = fives;
    }
}
