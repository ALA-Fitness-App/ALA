package com.example.alafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Class for the post workout activity, child of AppCompactActivity,
 * contains inherited methods.
 */
public class EndActivity extends AppCompatActivity {
    private Button exitBtn;
    TextView username;
    String user;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Intent intent = getIntent();
        user = intent.getStringExtra("username");
        username = findViewById(R.id.username);
        username.setText("You did it, " + user + "!");

        try {
            Uri sound = Uri.parse("android.resource://com.example.alafitness/" + R.raw.cheering);
            player = MediaPlayer.create(getApplicationContext(), sound);
            player.setLooping(false);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        exitBtn = (Button) findViewById(R.id.exit_Button);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndActivity.this, ProfileActivity.class);
                intent.putExtra("username", user);
                startActivity(intent);
            }
        });
    }
}