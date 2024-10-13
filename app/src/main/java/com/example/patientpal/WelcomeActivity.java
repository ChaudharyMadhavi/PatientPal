package com.example.patientpal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class WelcomeActivity extends AppCompatActivity {
    Button signin, signup;
    private ViewPager2 mviewpager2;
    private CircleIndicator3 mCircleIndicator3;
    private List<photo> mListPhoto;
    private Handler mHandler = new Handler();
    private Runnable mRunnable;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        signin = findViewById(R.id.btnSignIn);
        signup = findViewById(R.id.btnSignUp);

        // Set up click listeners for buttons
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        // Initialize ViewPager and CircleIndicator for image slideshow
        mviewpager2 = findViewById(R.id.view_pager);
        mCircleIndicator3 = findViewById(R.id.circle_indicator_3);

        // Set up image list and adapter
        mListPhoto = getListPhoto();
        PhotoViewPager2Adapter adapter = new PhotoViewPager2Adapter(mListPhoto);
        mviewpager2.setAdapter(adapter);
        mCircleIndicator3.setViewPager(mviewpager2);

        // Start auto-sliding the images
        autoSlideImages();
    }

    // Method to get the list of photos
    private List<photo> getListPhoto() {
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.welcome));  // Ensure these images exist in your drawable folder
        list.add(new photo(R.drawable.welcome_page2));
        list.add(new photo(R.drawable.welcome_page3));
        return list;
    }

    // Method to auto-slide images
    private void autoSlideImages() {
        mRunnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = mviewpager2.getCurrentItem();
                int totalItems = mListPhoto.size();

                if (currentItem < totalItems - 1) {
                    mviewpager2.setCurrentItem(currentItem + 1);
                } else {
                    mviewpager2.setCurrentItem(0); // Loop back to the first item
                }

                // Keep running this every 2 seconds
                mHandler.postDelayed(this, 2000);
            }
        };

        // Start the auto-slide after 2 seconds
        mHandler.postDelayed(mRunnable, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the runnable to prevent memory leaks
        mHandler.removeCallbacks(mRunnable);
    }
}
