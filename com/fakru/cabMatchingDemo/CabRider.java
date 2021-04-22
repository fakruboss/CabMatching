package com.fakru.cabMatchingDemo;

import java.util.ArrayList;
import java.util.List;

class CabRider {
    private final String name;
    private final List<Integer> ratings = new ArrayList<>();
    private final List<CabDriver> dislikedCabDrivers = new ArrayList<>();
    private double avgRating;
    private int totalRating = 0;

    CabRider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRatings() {
        return this.ratings;
    }

    public void addRating(int rating) {
        this.ratings.add(rating);
        calculateAvgRating();
    }

    private void calculateAvgRating() {
        this.totalRating += ratings.get(ratings.size() - 1);
        this.avgRating = (double) totalRating / ratings.size();
    }

    public double getAvgRating() {
        return this.avgRating;
    }

    public void addToDisLikedCabDrivers(CabDriver cabDriver) {
        this.dislikedCabDrivers.add(cabDriver);
    }

    public boolean isDislikedCabDriver(CabDriver cabDriver) {
        return this.dislikedCabDrivers.contains(cabDriver);
    }
}
