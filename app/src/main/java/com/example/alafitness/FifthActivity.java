package com.example.alafitness;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {

    private TextView startTimerView;
    private Button startPauseButton;

    private CountDownTimer countDownTimer;

    private long timeLeftinMills = 10000; // 10 seconds
    private boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTimerView = findViewById(R.id.timer_View);
        startPauseButton = findViewById(R.id.pause_Button);

        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startstop();
            }
        });

        updateTimer();
    }

    public void startstop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftinMills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftinMills = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {

            }
        }.start();

        startPauseButton.setText("PAUSE");
        timerRunning = true;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        startPauseButton.setText("START");
        timerRunning = false;
    }

    public void updateTimer() {
        int minutes = (int) timeLeftinMills / 60000;
        int seconds = (int) timeLeftinMills % 60000 / 1000;

        String timeLeftText;
        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        startTimerView.setText(timeLeftText);
    }

}