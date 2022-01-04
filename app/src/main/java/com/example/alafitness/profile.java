package com.example.alafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {

    /*expressButton = (Button) findViewById(R.id.imageButton2);

        expressButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent2 = new Intent(profile.this,GetReady.class);
            startActivity(intent2);
        }
    }*/

    public void onClick(View view) {
        Intent intent2 = new Intent(profile.this,GetReady.class);
        startActivity(intent2);
    }
    }
