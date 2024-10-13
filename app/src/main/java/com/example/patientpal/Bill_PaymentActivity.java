package com.example.patientpal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Bill_PaymentActivity extends AppCompatActivity {
    TimeDB tdb;
    TextView taskListTextView, totalAmountTextView, usernameTextView;
    int totalAmount = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment);



        // Get username from Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        // Initialize UI elements
        taskListTextView = findViewById(R.id.textViewTasks); // TextView to display tasks
        totalAmountTextView = findViewById(R.id.textViewTotalAmount); // TextView to display total amount
        usernameTextView = findViewById(R.id.textViewUsername); // TextView to display username

        // Set username in the TextView
        usernameTextView.setText("Username: " + username);

        // Initialize the database
        tdb = new TimeDB(this);

        // Load and display task data
        loadTaskData();
    }

    private void loadTaskData() {
        Cursor cursor = tdb.getAllData();

        if (cursor.getCount() == 0) {
            taskListTextView.setText("No task data found");
            return;
        }

        StringBuilder builder = new StringBuilder();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String taskName = cursor.getString(1);
            int amount = cursor.getInt(2);

            // Append task details to the string builder
            builder.append("ID: ").append(id).append("\n")
                    .append("Task: ").append(taskName).append("\n")
                    .append("Amount: ").append(amount).append("\n\n");

            // Calculate the total amount
            totalAmount += amount;
        }

        // Display task data and total amount
        taskListTextView.setText(builder.toString());
        totalAmountTextView.setText("Total Amount: " + totalAmount);
    }
}
