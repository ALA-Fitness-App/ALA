package com.example.alafitness;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alafitness.model.Constants;
import com.example.alafitness.model.Exercise;

import java.util.List;

public class ExerciseActivity extends AppCompatActivity {

    private Button nextBtn;
    private TextView exerciseType;
    private TextView timer;
    private TextView exerciseName;
    private ImageView exerciseImage;
    private Long progress;


    private TextView startTimerView;
    private Button startPauseButton;

    private List<Exercise> exercises;
    int currentExercise = 0;

    private CountDownTimer countDownTimer;

    private long timeLeftinMills = 10000; // 10 seconds
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //startTimer();
        setContentView(R.layout.activity_exercise);



        exercises = Constants.getExercises();
        exerciseType = findViewById(R.id.tvType);
        timer = findViewById(R.id.tvTimer);
        exerciseName = findViewById(R.id.ExerciseText);
        exerciseImage = findViewById(R.id.ivExerciseImage);

        nextBtn = (Button) findViewById(R.id.next_Button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ExerciseActivity.this,TimedBreak.class);
                startActivity(intent2);
            }
        });


        startTimerView = findViewById(R.id.timer_View);
        startPauseButton = findViewById(R.id.pause_Button);

        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startstop();
            }
        });

        Exercise exercise = exercises.get(currentExercise);
        exerciseType.setText(exercise.getExerciseType());
        exerciseName.setText(exercise.getExerciseName());
        exerciseImage.setImageResource(exercise.getImageLink());
        timer.setText(exercise.getExerciseDuration().toString());

        //updateTimer();

        startstop();



    }

    public void startstop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }


    public void startTimer() {

        Exercise exercise = exercises.get(currentExercise);
        exerciseType.setText(exercise.getExerciseType());
        exerciseName.setText(exercise.getExerciseName());
        exerciseImage.setImageResource(exercise.getImageLink());
        timer.setText(exercise.getExerciseDuration().toString());
        timeLeftinMills = exercise.getExerciseDuration()*1000;

        progress = exercise.getExerciseDuration();

        countDownTimer = new CountDownTimer(timeLeftinMills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               //long secsLeft = (timeLeftinMills - progress*1000)/1000;
               progress--;
               timer.setText(progress.toString());

            }

            @Override
            public void onFinish() {
                currentExercise++;
                if (currentExercise < exercises.size()) {
                    startTimer();
                } else {
                    Intent intent2 = new Intent(ExerciseActivity.this,EndActivity.class);
                    startActivity(intent2);
                }

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