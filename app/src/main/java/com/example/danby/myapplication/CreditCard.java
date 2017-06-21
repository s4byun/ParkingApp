package com.example.danby.myapplication;

/**
 * Created by David on 6/6/2017.
 */

class CreditCard {
    static String Name = "Elon Musk";
    static String Cardnumber = "4624220058461322";
    static String Expiradation = "10/16";
    static String CCV = "168";
    static String Billing_Address = "1600 Amphitheatre Pkwy, Mountain View, CA 94043";

    public CreditCard(String name, String cardtype, String cardnumber, String expiradation, String ccv, String billing_address ){
        Name = name;
        Cardnumber = cardnumber;
        Expiradation = expiradation;
        CCV = ccv;
        Billing_Address = billing_address;
    }
    public void setCardInfo(String name, String cardtype, String cardnumber, String expiradation, String ccv, String billing_address ) {
        Name = name;
        Cardnumber = cardnumber;
        Expiradation = expiradation;
        CCV = ccv;
        Billing_Address = billing_address;
    }
    public static String getLast4Cardnumber(){
        String substr = Cardnumber.substring(Cardnumber.length() - 4);
        return substr;
    }


}
