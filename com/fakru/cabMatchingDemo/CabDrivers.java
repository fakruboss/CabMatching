package com.fakru.cabMatchingDemo;

import java.util.ArrayList;
import java.util.List;

class CabDrivers {
    private static final CabDrivers instance = new CabDrivers();
    List<CabDriver> cabDrivers = new ArrayList<>();

    private CabDrivers() {
    }

    public static CabDrivers getInstance() {
        return instance;
    }

    public void addCabDriver(String cabDriverName) {
        for (CabDriver cabDriver : cabDrivers) {
            if (cabDriverName.equalsIgnoreCase(cabDriver.getName())) {
                return;
            }
        }
        cabDrivers.add(new CabDriver(cabDriverName));
    }

    public CabDriver getCabDriverByName(String cabDriverName) {
        for (CabDriver cabDriver : cabDrivers) {
            if (cabDriverName.equalsIgnoreCase(cabDriver.getName())) {
                return cabDriver;
            }
        }
        return null;
    }

    public List<CabDriver> getAllCabDrivers() {
        return this.cabDrivers;
    }

    public void printAllDrivers() {
        for (CabDriver cabDriver : cabDrivers) {
            System.out.println("Name : " + cabDriver.getName());
            System.out.println("Ratings : " + cabDriver.getRatings());
            System.out.println("Avg Rating : " + cabDriver.getAvgRating());
            System.out.println();
        }
        System.out.println("----------------------");
    }

    public CabDriver findMatchingCabDriver(CabDrivers cabDrivers, CabRiders cabRiders, String cabRiderName) {
        CabDriver matchingCabDriver = null;
        CabRider cabRider = cabRiders.getCabRiderByName(cabRiderName);
        if (cabRider == null) return null;
        double avgRatingOfCabRider = cabRider.getAvgRating();
        CabDriver maxAvgRatingCabDriver = null;
        for (CabDriver cabDriver : cabDrivers.getAllCabDrivers()) {
            if (!cabRider.isDislikedCabDriver(cabDriver)) {
                if (cabDriver.getAvgRating() >= avgRatingOfCabRider
                        && (matchingCabDriver == null || cabDriver.getAvgRating() > matchingCabDriver.getAvgRating())) {
                    matchingCabDriver = cabDriver;
                }
                if (maxAvgRatingCabDriver == null) {
                    maxAvgRatingCabDriver = cabDriver;
                } else if (cabDriver.getAvgRating() > maxAvgRatingCabDriver.getAvgRating()) {
                    maxAvgRatingCabDriver = cabDriver;
                }
            }
        }
        return matchingCabDriver != null ? matchingCabDriver : maxAvgRatingCabDriver;
    }
}
