package com.example.alafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.alafitness.model.Constants;

/**
 * Class that contains all methods to run the Profile page, child of AppCompatActivity,
 * Contains inherited methods.
 */
public class ProfileActivity extends AppCompatActivity {

    ImageButton expressButton;
    ImageButton pyramidButton;
    Button demoButton;
    TextView username;
    TextView workoutDuration;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        user = intent.getStringExtra("username");
        username = findViewById(R.id.tvUsernameProfile);
        username.setText("Hello, " + user + "!");
        workoutDuration = findViewById(R.id.tvWorkoutsThisWeek);
        workoutDuration.setText("this week: " + Constants.totalWorkoutTime(Constants.getDemoExercises()));

        expressButton = findViewById(R.id.ibExpress);
        expressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ProfileActivity.this, ExpressExerciseActivity.class);
                intent2.putExtra("username", user);
                startActivity(intent2);
            }
        });

        demoButton = findViewById(R.id.bDemo);
        demoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ProfileActivity.this, DemoExerciseActivity.class);
                intent1.putExtra("username", user);
                startActivity(intent1);
            }
        });

        pyramidButton = findViewById(R.id.ibPyramid);
        pyramidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(ProfileActivity.this, PyramidExerciseActivity.class);
                intent3.putExtra("username", user);
                startActivity(intent3);
            }
        });
    }
}