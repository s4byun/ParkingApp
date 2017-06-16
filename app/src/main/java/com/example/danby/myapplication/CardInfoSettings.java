package com.example.danby.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CardInfoSettings extends FragmentActivity {
    static String cardnum, exp, ccv, name, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_info_settings);

        final EditText editcardnum = (EditText) findViewById(R.id.cardinfo_card_num);
        final EditText editexp = (EditText) findViewById(R.id.cardinfo_exp);
        final EditText editccv = (EditText) findViewById(R.id.cardinfo_ccv);
        final EditText editname = (EditText) findViewById(R.id.cardinfo_name);
        final EditText editaddress = (EditText) findViewById(R.id.cardinfo_address);

        //    static String Firstname, Lastname, Cardtype, Cardnumber, Expiradation, CCV, Billing_Address;

        editcardnum.setText(CreditCard.Cardnumber);
        editexp.setText(CreditCard.Expiradation);
        editccv.setText(CreditCard.CCV);
        editname.setText(CreditCard.Name);
        editaddress.setText(CreditCard.Billing_Address);

        Button okayButton = (Button) findViewById(R.id.cardinfo_okay);
        Button cancelButton = (Button) findViewById(R.id.cardinfo_cancel);

        okayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Car.setCarInfo(edityear.getText().toString(),editmodel.getText().toString(),editmake.getText().toString(),editlicense_num.getText().toString());
                CreditCard.Cardnumber = editcardnum.getText().toString();
                CreditCard.Expiradation = editexp.getText().toString();
                CreditCard.CCV = editccv.getText().toString();
                CreditCard.Name = editname.getText().toString();
                CreditCard.Billing_Address = editaddress.getText().toString();


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
        super.onBackPressed();
    }
}
