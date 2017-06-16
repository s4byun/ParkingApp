package com.example.danby.myapplication;

class Car {
    static String Year = "2016";
    static String Model = "Lamborghini";
    static String Make = "Aventador";
    static String License_num = "F139N13";

    public  Car(String year ,String model, String make, String licensenum) {
        Year = year;
        Model = model;
        Make = make;
        License_num = licensenum;

    }


    public static void setCarInfo(String year ,String model, String make, String licensenum) {
        Year = year;
        Model = model;
        Make = make;
        License_num = licensenum;

    }
    public static String toStrings(){
        return Year + " " + Model + " " + Make;


    }
    public static String getYear(){
        return Year;
    }
    public static String getModel(){
        return Model;
    }
    public static String getMake(){
        return Make;
    }
    public static String getLicense_num(){
        return License_num;
    }


}
