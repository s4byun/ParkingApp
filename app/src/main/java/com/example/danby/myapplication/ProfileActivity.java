package com.example.danby.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //MockProfileDB mockProfileDB = new MockProfileDB();

        String carInfo = ""+  Car.Year + " " + Car.Make + " " + Car.Model + " " + Car.License_num;
        Button carButton = (Button) findViewById(R.id.car_info_button);
        carButton.setText(carInfo);


        String lastFour = CreditCard.getLast4Cardnumber();
        Button cardButton = (Button) findViewById(R.id.card_info_button);
        cardButton.setText("XXXX - XXXX - XXXX - " +lastFour);




        carButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, CarInfoSettings.class);
                startActivityForResult(intent,1);
            }
        });
        cardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, CardInfoSettings.class);
                startActivityForResult(intent,1);
            }
        });

        Button historyButton = (Button) findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ShowHistoryActivity.class);
                startActivityForResult(intent,1);
            }
        });







    }
    public void onRestart(){
        super.onRestart();
        String carInfo = ""+  Car.Year + " " + Car.Model + " " + Car.Make + " " + Car.License_num;
        Button carButton = (Button) findViewById(R.id.car_info_button);
        carButton.setText(carInfo);

        String lastFour = CreditCard.getLast4Cardnumber();
        Button cardButton = (Button) findViewById(R.id.card_info_button);
        cardButton.setText("XXXX - XXXX - XXXX - " +lastFour);


    }

}