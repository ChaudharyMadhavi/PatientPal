package com.example.patientpal;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class OrthoPedicCareActivity extends AppCompatActivity {
  private CardView Household;
  private CardView PersonalCare;
    private CardView Companionship;
    private CardView Transportation;
    private CardView SpecializedCare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);

        Household=findViewById(R.id.card_household_task);
        PersonalCare=findViewById(R.id.card_personal_care);
        Companionship=findViewById(R.id.card_companionship);
        Transportation=findViewById(R.id.card_transportation);
        SpecializedCare=findViewById(R.id.card_specialized_care);

        Household.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent = new Intent(OrthoPedicCareActivity.this, Bill_PaymentActivitiy.class);
                    startActivity(intent);
            }
        });
        PersonalCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrthoPedicCareActivity.this, Bill_PaymentActivitiy.class);
                startActivity(intent);
            }
        });
        Companionship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrthoPedicCareActivity.this, Bill_PaymentActivitiy.class);
                startActivity(intent);
            }
        });
        Transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrthoPedicCareActivity.this, Bill_PaymentActivitiy.class);
                startActivity(intent);
            }
        });
        SpecializedCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrthoPedicCareActivity.this, Bill_PaymentActivitiy.class);
                startActivity(intent);
            }
        });




    }




}