package com.example.patientpal.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.patientpal.CencerCareAvtivity;
import com.example.patientpal.OrthoPedicCareActivity;
import com.example.patientpal.R;
import com.example.patientpal.TimeDB;
import com.example.patientpal.TumerCareActivity;


public class ServiceFragment extends Fragment {

    private CardView cardOrthopedicCare;
    private CardView cardTumerCare;
    private CardView cardCencerCare;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);


        // Find the CardView in the layout
        cardOrthopedicCare = view.findViewById(R.id.card_orthopedic);
        cardTumerCare= view.findViewById(R.id.card_tumer);
        cardCencerCare= view.findViewById(R.id.card_cencer);


        // Set a click listener for the CardView
        cardOrthopedicCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the OrthopedicCareActivity when the card is clicked
                if (getActivity() != null) {
                    Intent intent = new Intent(getActivity(), OrthoPedicCareActivity.class);
                    startActivity(intent);
                }
            }


        });

        cardTumerCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the OrthopedicCareActivity when the card is clicked
                if (getActivity() != null) {
                    Intent intent = new Intent(getActivity(), TumerCareActivity.class);
                    startActivity(intent);
                }
            }
        });

        cardCencerCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the OrthopedicCareActivity when the card is clicked
                if (getActivity() != null) {
                    Intent intent = new Intent(getActivity(), CencerCareAvtivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}
