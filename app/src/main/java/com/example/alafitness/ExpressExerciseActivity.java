package com.example.alafitness;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.alafitness.model.Constants;
import com.example.alafitness.model.Exercise;
import com.example.alafitness.model.ExerciseType;
import com.example.alafitness.model.TimedExercise;


import java.util.List;
import java.util.Locale;

public class ExpressExerciseActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private Button nextBtn;
    private TextView exerciseType;
    private TextView timer;
    private TextView exerciseName;
    private ImageView exerciseImage;
    private Long progress;
    private ProgressBar timerBar;
    private TextView startTimerView;
    private Button startPauseButton;
    private List<TimedExercise> exercises;
    int currentExercise = 0;
    private CountDownTimer countDownTimer;
    private long timeLeftinMills = 10000; // 10 seconds
    private boolean timerRunning;
    TextView username;
    String user;
    private MediaPlayer player;
    TimedExercise timedExercise;
    private TextToSpeech textToSpeech;
    private TextView workoutType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        textToSpeech = new TextToSpeech(this, this);

        Intent intent = getIntent();
        user = intent.getStringExtra("username");
        username = findViewById(R.id.username);
        username.setText(user + "!");

        exercises = Constants.getExpressExercises();
        exerciseType = findViewById(R.id.tvType);
        timer = findViewById(R.id.tvTimer);
        exerciseName = findViewById(R.id.ExerciseText);
        exerciseImage = findViewById(R.id.ivExerciseImage);
        timerBar = findViewById(R.id.progressBar);
        workoutType = findViewById(R.id.tvWorkoutType);

        nextBtn = (Button) findViewById(R.id.next_Button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ExpressExerciseActivity.this,TimedBreak.class);
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

        timedExercise = exercises.get(currentExercise);
        exerciseType.setText(timedExercise.getType().toString());
        exerciseName.setText(timedExercise.getName());
        exerciseImage.setImageResource(timedExercise.getImageLink());
        timer.setText(timedExercise.getDuration().toString());

        startstop();
    }

    public void startstop() {
        if (timerRunning) {
            stopTimer();
        } else {
            // need a method to continue the timer rather than start
            startTimer();
        }
    }


    public void startTimer() {

        TimedExercise timedExercise = exercises.get(currentExercise);

        if (timedExercise.getType().equals(ExerciseType.BREAK)) {
            exerciseType.setText(timedExercise.getName());
            exerciseName.setText("Next up: " + exercises.get(currentExercise+1).getName());
            try {
                readItOut("Next up: " + exercises.get(currentExercise + 1).getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            exerciseType.setText(timedExercise.getType().toString());
            exerciseName.setText(timedExercise.getName());
            try {
                readItOut("Go!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        exerciseImage.setImageResource(timedExercise.getImageLink());
        timer.setText(timedExercise.getDuration().toString());
        timeLeftinMills = timedExercise.getDuration()*1000;
        progress = timedExercise.getDuration();
        timerBar.setProgress(progress.intValue() * 10);
        workoutType.setText("EXPRESS:");

        countDownTimer = new CountDownTimer(timeLeftinMills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               progress--;
               timer.setText(progress.toString());

                timerBar.setProgress((progress.intValue() * 100) / (timedExercise.getDuration().intValue()));

               if (progress<=3 && progress>0 && timedExercise.getType().equals(ExerciseType.BREAK)) {

                   try {

                       Uri sound = Uri.parse("android.resource://com.example.alafitness/" + R.raw.countdown);
                       player = MediaPlayer.create(getApplicationContext(), sound);
                       player.setLooping(false);
                       player.start();

                   }catch (Exception e) {
                       e.printStackTrace();
                   }}
               }


            @Override
            public void onFinish() {
                timerBar.setProgress(0);

                currentExercise++;
                if (currentExercise < exercises.size()) {
                    startTimer();
                } else {
                    Intent intent2 = new Intent(ExpressExerciseActivity.this,EndActivity.class);
                    intent2.putExtra("username", user);
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

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.ENGLISH);

            if (result== TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("tts", "Specified language not supported");
            }
        }else {
            Log.e("tts", "Initialization failed");
        }
    }
    private void readItOut(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, null, "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        player.stop();
        // tts.stop();
    }
}