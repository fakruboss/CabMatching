package com.fakru.cabMatchingDemo;

import java.util.ArrayList;
import java.util.List;

class CabDriver {
    private final String name;
    private final List<Integer> ratings;
    private Double avgRating;
    private int totalRating = 0;

    CabDriver(String name) {
        this.name = name;
        this.ratings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRating(int rating) {
        ratings.add(rating);
        calculateAvgRating();
    }

    private void calculateAvgRating() {
        this.totalRating += ratings.get(ratings.size() - 1);
        this.avgRating = (double) totalRating / ratings.size();
    }

    public double getAvgRating() {
        return this.avgRating;
    }

    public List<Integer> getRatings() {
        return this.ratings;
    }
}
