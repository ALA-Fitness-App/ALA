package com.example.alafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    ImageButton expressButton;
    TextView username;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        user = intent.getStringExtra("username");
        username = findViewById(R.id.tvUsernameProfile);
        username.setText(user + "!");

        expressButton = findViewById(R.id.imageButton2);
        expressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(profile.this,ExerciseActivity.class);
                intent2.putExtra("username", user);
                startActivity(intent2);
            }
        });



    }
}