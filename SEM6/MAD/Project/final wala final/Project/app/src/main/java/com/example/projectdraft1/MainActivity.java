package com.example.projectdraft1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView laview;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        // Set up button click listener
        Button arrowButton = findViewById(R.id.button3);
        //laview.setAnimation(R.raw.lottie);
        //laview.playAnimation();

        arrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the dashboard activity when the button is clicked
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
