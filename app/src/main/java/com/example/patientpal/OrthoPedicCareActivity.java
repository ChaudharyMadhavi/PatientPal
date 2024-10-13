package com.example.patientpal;

import android.content.Intent;
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

        Household = findViewById(R.id.card_household_task);
        PersonalCare = findViewById(R.id.card_personal_care);
        Companionship = findViewById(R.id.card_companionship);
        Transportation = findViewById(R.id.card_transportation);
        SpecializedCare = findViewById(R.id.card_specialized_care);

        // Set OnClickListeners and pass data with the Intent
        Household.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToBillPayment("Household Task");
            }
        });

        PersonalCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToBillPayment("Personal Care");
            }
        });

        Companionship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToBillPayment("Companionship");
            }
        });

        Transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToBillPayment("Transportation");
            }
        });

        SpecializedCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToBillPayment("Specialized Care");
            }
        });
    }

    private void navigateToBillPayment(String taskName) {
        Intent intent = new Intent(OrthoPedicCareActivity.this,Bill_PaymentActivity.class);
        intent.putExtra("TASK_NAME", taskName);  // Pass the name of the clicked card button
        startActivity(intent);
    }
}
