package com.example.danby.myapplication;


import android.location.Location;

import java.util.ArrayList;

/**
 * Created by David on 6/6/2017.
 */

public class MockParkingLocationDB {
    ArrayList<Location> l = new ArrayList<>();
    
    public MockParkingLocationDB(){
        Location location = new Location("");

        location.setLatitude(-10.110222);
        location.setLongitude(-8.2213333241);

        Location location_1 = new Location("");
        location.setLatitude(-12.9468);
        location.setLongitude(-1.12834892);

        l.add(location);
        l.add(location_1);

    }
    public void addLocation(Location loc){
        l.add(loc);
    }
    public void deleteLocation(Location loc){
        l.remove(loc);
    }
    public ArrayList<Location> getParkingLocations(){
        return l;
    }
}
