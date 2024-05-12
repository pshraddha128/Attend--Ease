package com.example.projectdraft1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find views by their IDs
        ImageButton attendanceButton = findViewById(R.id.imageButton2);
        Button backButton = findViewById(R.id.button4);
        //ImageView profileImage = findViewById(R.id.imageView6);

        // Set click listeners for the buttons
        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the bar chart activity for attendance
                Intent intent = new Intent(DashboardActivity.this,MainActivity1.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the home page (first page)
                finish();
            }
        });
    }
}
