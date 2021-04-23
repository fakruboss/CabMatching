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
        boolean isContinue;
        do {
            System.out.print("Enter cab rider name : ");
            String cabRiderName = scan.next();
            CabRider cabRider = cabRiders.getCabRiderByName(cabRiderName);
            if (cabRider == null) {
                new CabRider(cabRiderName);
                cabRider = cabRiders.getCabRiderByName(cabRiderName);
            }
            CabDriver matchingCabDriver = cabDrivers.findMatchingCabDriver(cabRider);
            if (matchingCabDriver == null) System.out.println("No matching cab drivers found");
            else {
                System.out.print(matchingCabDriver.getName() + " ");
                System.out.println(matchingCabDriver.getAvgRating());
            }
            System.out.println("Enter 1 to continue others to abort");
            isContinue = scan.nextInt() == 1;
        } while (isContinue);
    }
}
