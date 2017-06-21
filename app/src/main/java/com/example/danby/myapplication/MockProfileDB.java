package com.example.danby.myapplication;

import android.location.Location;

import java.util.ArrayList;
import java.util.List;

public class MockProfileDB {
    //static Car car = new Car("2016", "Lamborghini", "Aventador", "F139N13");


    static CreditCard c = new CreditCard("Daniel Byun",
            "Visa",
            "4624220058461322",
            "10/16",
            "168",
            "1600 Amphitheatre Pkwy, Mountain View, CA 94043");


    public MockProfileDB() {
        Car.setCarInfo("2016", "Lamborghini", "Aventador", "F139N13");
    }
    /*
    public FBInfo getFBProfile() {
        // This is all pseudocode
        fbProfile = getFBProfileUsingFBGraphRestAPI(getCurrentAccessToken());
        return fbProfile;
    }
    */

    /*
    public static void setcarInfo(String year ,String model, String make, String licensenum){
        car.setCarInfo(year, model,make,licensenum);

    }*/
    public static PaymentInfo getPaymentInfo() {
        PaymentInfo payInfo = new PaymentInfo();
        payInfo.addPaymentMethod(c);
        return payInfo;
    }

    public static List<Location> getHistory() {
        List<Location> l = new ArrayList<>();
        Location location = new Location("");


        location.setLatitude(-10.110222);
        location.setLongitude(-8.2213333241);

        Location location_1 = new Location("");
        location.setLatitude(-12.9468);
        location.setLongitude(-1.12834892);

        l.add(location);
        l.add(location_1);

        return l;


    }

    public static List<Location> getFavorites() {
        List<Location> l = new ArrayList<>();
        Location location = new Location("");
        location.setLatitude(0.110222);
        location.setLongitude(12.9458453);

        Location location_1 = new Location("");
        location.setLatitude(8.2213333241);
        location.setLongitude(1.12834892);

        l.add(location);
        l.add(location_1);

        return l;


    }
}
