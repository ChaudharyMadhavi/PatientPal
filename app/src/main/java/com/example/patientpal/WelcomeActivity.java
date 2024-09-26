package com.example.patientpal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    Button signin,signup;
    DBHelper DB;
    Intent i;
    @Override
    protected void onCreate(Bundle SavedInstantState){

        super.onCreate(SavedInstantState);
        setContentView(R.layout.activity_welcome);

        signin=(Button) findViewById(R.id.btnSignIn);
        signup=(Button)findViewById(R.id.btnSignUp);



        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                i=new Intent(WelcomeActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });
        signin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                i=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

    }


}
