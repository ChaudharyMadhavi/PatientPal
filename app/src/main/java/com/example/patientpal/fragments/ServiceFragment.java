package com.example.patientpal.fragments;
import com.example.patientpal.fragments.OrthoPedicCareActivity;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.patientpal.R;


public class ServiceFragment extends Fragment {

    private CardView cardOrthopedicCare;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);


        // Find the CardView in the layout
        cardOrthopedicCare = view.findViewById(R.id.card_orthopedic);

        // Set a click listener for the CardView
        cardOrthopedicCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the OrthopedicCareActivity when the card is clicked
                if (getActivity() != null) {
                    Intent intent = new Intent(getActivity(),OrthoPedicCareActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}
