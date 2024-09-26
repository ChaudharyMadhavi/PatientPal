package com.example.patientpal;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Bill_PaymentActivitiy extends AppCompatActivity {
    TimeDB tdb;
    DBHelper db;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment);

        String task= e.getText().toString();

    }
}
