package com.fakru.cabMatchingDemo;

class Ride {
    Ride(String cabRiderName, int cabRiderRating, String cabDriverName, int cabDriverRating) {
        CabRider cabRider = handleCabRider(cabRiderName, cabRiderRating);
        CabDriver cabDriver = handleCabDriver(cabDriverName, cabDriverRating);
        if (cabDriverRating == 1) {
            cabRider.addToDisLikedCabDrivers(cabDriver);
        }
    }

    private CabRider handleCabRider(String cabRiderName, int cabRiderRating) {
        CabRiders cabRiders = CabRiders.getInstance();
        CabRider cabRider = cabRiders.getCabRiderByName(cabRiderName);
        if (cabRider == null) {
            cabRiders.addCabRider(cabRiderName);
            cabRider = cabRiders.getCabRiderByName(cabRiderName);
        }
        cabRider.addRating(cabRiderRating);
        return cabRider;
    }

    private CabDriver handleCabDriver(String cabDriverName, int cabDriverRating) {
        CabDrivers cabDrivers = CabDrivers.getInstance();
        CabDriver cabDriver = cabDrivers.getCabDriverByName(cabDriverName);
        if (cabDriver == null) {
            cabDrivers.addCabDriver(cabDriverName);
            cabDriver = cabDrivers.getCabDriverByName(cabDriverName);
        }
        cabDriver.addRating(cabDriverRating);
        return cabDriver;
    }
}
