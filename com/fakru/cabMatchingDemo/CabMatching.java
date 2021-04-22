package com.fakru.cabMatchingDemo;

import java.util.Scanner;

public class CabMatching {
    public static void main(String[] args) {
        CabDrivers cabDrivers = CabDrivers.getInstance();
        CabRiders cabRiders = CabRiders.getInstance();
        new Ride("Ram", 3, "Bheem", 5);
        new Ride("Laxman", 5, "Nakul", 2);
        new Ride("Ram", 3, "Sahadev", 2);
        new Ride("Bharat", 3, "Bheem", 5);
        new Ride("Ram", 3, "Bheem", 1);
        new Ride("Laxman", 5, "Sahadev", 3);
        new Ride("Bharat", 5, "Nakul", 4);
        cabDrivers.printAllDrivers();
        cabRiders.printAllRiders();

        Scanner scan = new Scanner(System.in);
        String cabRider = scan.next();
        CabDriver matchingCabDriver = cabDrivers.findMatchingCabDriver(cabDrivers, cabRiders, cabRider);
        System.out.println(matchingCabDriver.getName());
        System.out.println(matchingCabDriver.getAvgRating());
    }
}
