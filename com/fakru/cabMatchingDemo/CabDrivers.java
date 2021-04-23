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

    public CabDriver findMatchingCabDriver(CabRider cabRider) {
        CabDrivers cabDrivers = CabDrivers.getInstance();
        boolean isNewCabRider = cabRider == null;
        double avgRatingOfCabRider = isNewCabRider ? 0d : cabRider.getAvgRating();
        CabDriver maxAvgRatingCabDriver = null;
        CabDriver matchingCabDriver = null;
        for (CabDriver cabDriver : cabDrivers.getAllCabDrivers()) {
            if (!isNewCabRider) {
                matchingCabDriver = getMatchingCabDriver(cabRider, cabDriver, matchingCabDriver, avgRatingOfCabRider);
            }
            maxAvgRatingCabDriver = getMaxAvgRatingCabDriver(cabDriver, maxAvgRatingCabDriver);
        }
        return isNewCabRider || matchingCabDriver == null ? maxAvgRatingCabDriver : matchingCabDriver;

    }

    private CabDriver getMatchingCabDriver(CabRider cabRider, CabDriver currCabDriver, CabDriver matchingCabDriver, double avgRatingOfCabRider) {
        if (!cabRider.isDislikedCabDriver(currCabDriver) && currCabDriver.getAvgRating() >= avgRatingOfCabRider
                && (matchingCabDriver == null || currCabDriver.getAvgRating() > matchingCabDriver.getAvgRating())) {
            matchingCabDriver = currCabDriver;
        }
        return matchingCabDriver;
    }

    private CabDriver getMaxAvgRatingCabDriver(CabDriver currCabDriver, CabDriver maxAvgRatingCabDriver) {
        if (maxAvgRatingCabDriver == null) {
            maxAvgRatingCabDriver = currCabDriver;
        } else if (currCabDriver.getAvgRating() > maxAvgRatingCabDriver.getAvgRating()) {
            maxAvgRatingCabDriver = currCabDriver;
        }
        return maxAvgRatingCabDriver;
    }
}
