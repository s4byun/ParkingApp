package com.example.danby.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CarInfoSettings extends FragmentActivity {
    static String year, model, make, license_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info_settings);

        //final MockProfileDB mockdb = new MockProfileDB();

        final EditText edityear = (EditText) findViewById(R.id.editText);
        final EditText editmodel = (EditText) findViewById(R.id.editText4);
        final EditText editmake = (EditText) findViewById(R.id.editText3);
        final EditText editlicense_num = (EditText) findViewById(R.id.editText2);


        edityear.setText(Car.Year);
        editmodel.setText(Car.Model);
        editmake.setText(Car.Make);
        editlicense_num.setText(Car.License_num);

        Button okayButton = (Button) findViewById(R.id.okaybutton);
        Button cancelButton = (Button) findViewById(R.id.cancelbutton);

        okayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Car.setCarInfo(edityear.getText().toString(),editmodel.getText().toString(),editmake.getText().toString(),editlicense_num.getText().toString());
                Car.Year = edityear.getText().toString();
                Car.Model = editmodel.getText().toString();
                Car.Make = editmake.getText().toString();
                Car.License_num = editlicense_num.getText().toString();
                onFinish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onFinish();
            }
        });
    }
    public void onFinish(){
        //Car.setCarInfo(year,model,make,license_num);
        super.onBackPressed();
    }
}
