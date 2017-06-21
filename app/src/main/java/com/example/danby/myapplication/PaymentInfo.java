package com.example.danby.myapplication;

import java.util.ArrayList;

/**
 * Created by David on 6/6/2017.
 */

class PaymentInfo {
    ArrayList<CreditCard> l = new ArrayList<>();
    public PaymentInfo(){

    }
    public void addPaymentMethod (CreditCard c){
        l.add(c);
    }
}
