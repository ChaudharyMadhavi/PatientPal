package com.example.patientpal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Find the root layout of your activity to apply the fade-out animation
        final RelativeLayout rootLayout = findViewById(R.id.rootLayout);

        // Delay before transitioning to the next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Load and apply fade-out animation
                Animation fadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
                rootLayout.startAnimation(fadeOut);

                // Transition to the next activity after the animation ends
                fadeOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // You can add any action when the animation starts here
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // No need to implement this for a single animation
                    }
                });
            }
        }, 5000);  // Delay of 5 seconds
    }
}
