package com.example.projetmob.model;

public class Emissions {
    public double score;
    public TheShows show;
    public Emissions emissions;


    public Emissions(double score, TheShows show) {
        this.score = score;
        this.show = show;
    }
    public double getScore() {

        return score;
    }
    public TheShows getShow() {
        return show;
    }

    // Getters and setters
    // ...
}