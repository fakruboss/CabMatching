package com.fakru.cabMatchingDemo;

import java.util.ArrayList;
import java.util.List;

class CabRiders {
    private static final CabRiders instance = new CabRiders();
    List<CabRider> cabRiders = new ArrayList<>();

    private CabRiders() {
    }

    public static CabRiders getInstance() {
        return instance;
    }

    public void addCabRider(String cabRiderName) {
        for (CabRider cabRider : cabRiders) {
            if (cabRiderName.equalsIgnoreCase(cabRider.getName())) {
                return;
            }
        }
        cabRiders.add(new CabRider(cabRiderName));
    }

    public CabRider getCabRiderByName(String cabRiderName) {
        for (CabRider cabRider : cabRiders) {
            if (cabRiderName.equalsIgnoreCase(cabRider.getName())) {
                return cabRider;
            }
        }
        return null;
    }

    public void printAllRiders() {
        for (CabRider cabRider : cabRiders) {
            System.out.println("Name : " + cabRider.getName());
            System.out.println("Ratings : " + cabRider.getRatings());
            System.out.println("Avg Rating : " + cabRider.getAvgRating());
            System.out.println();
        }
        System.out.println("----------------------");
    }
}
