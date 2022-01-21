package com.example.alafitness;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.alafitness.model.Constants;
import com.example.alafitness.model.ExerciseType;
import com.example.alafitness.model.TimedExercise;

import java.util.List;
import java.util.Locale;

/**
 * Class that contains all methods to run the Demo workout, child of AppCompatActivity,
 * uses TextToSpeech interface.
 * Contains inherited and bespoke methods.
 */
public class ExerciseActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private Button nextBtn;
    private TextView exerciseType;
    private TextView timer;
    private TextView exerciseName;
    private TextView exercisesRemaining;
    private ImageView exerciseImage;
    private Long progress;
    private ProgressBar timerBar;
    private Button startPauseButton;
    private List<TimedExercise> exercises;
    private int currentExercise = 0;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private TextView username;
    public String user;
    private MediaPlayer player;
    private TimedExercise timedExercise;
    private TextToSpeech textToSpeech;
    private TextView workoutType;
    private String passedWorkoutType;
    private Long fullDuration;
    private Long remainingProgress;
    private Long timeLeftinSecs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        textToSpeech = new TextToSpeech(this, this);
        Intent intent = getIntent();
        user = intent.getStringExtra("username");
        passedWorkoutType = intent.getStringExtra("workout type");
        username = findViewById(R.id.username);
        username.setText(user + "!");
        exercises = Constants.getExercisesForActivity(passedWorkoutType);
        exerciseType = findViewById(R.id.tvType);
        timer = findViewById(R.id.tvTimer);
        exerciseName = findViewById(R.id.ExerciseText);
        exercisesRemaining = findViewById(R.id.Exercises_remaining);
        exerciseImage = findViewById(R.id.ivExerciseImage);
        timerBar = findViewById(R.id.progressBar);
        workoutType = findViewById(R.id.tvWorkoutType);
        timedExercise = exercises.get(currentExercise);
        exerciseType.setText(timedExercise.getType().toString());
        exerciseName.setText(timedExercise.getName());
        exerciseImage.setImageResource(timedExercise.getImageLink());
        //exercisesRemaining.setText("Remaining: " + currentExercise + "/" + Constants.totalAmountOfExercises(passedWorkoutType));
        timer.setText(timedExercise.getDuration().toString());
        nextBtn = (Button) findViewById(R.id.next_Button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                countDownTimer.onFinish();
            }
        });

        startPauseButton = findViewById(R.id.pause_Button);
        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startstop();
            }
        });
        startTimer();
    }

    public void startTimer(Long timeLeftinMills) {

        TimedExercise timedExercise = exercises.get(currentExercise);
        if (timedExercise.getType().equals(ExerciseType.BREAK)) {
            exercisesRemaining.setVisibility(View.INVISIBLE);
            exerciseType.setText(timedExercise.getName());
            exerciseName.setText("Next up: " + exercises.get(currentExercise + 1).getName());
            try {
                readItOut("Next up: " + exercises.get(currentExercise + 1).getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            exercisesRemaining.setVisibility(View.VISIBLE);
            exercisesRemaining.setText("Progress: " + (currentExercise + 1)/2 + "/" + Constants.totalAmountOfExercises(passedWorkoutType));
            exerciseType.setText(timedExercise.getType().toString());
            exerciseName.setText(timedExercise.getName());
            try {
                readItOut("Go!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        exerciseImage.setImageResource(timedExercise.getImageLink());
        if (timeLeftinMills > 0) {
            timeLeftinSecs = timeLeftinMills / 1000;
            timer.setText(timeLeftinSecs.toString());
            progress = timeLeftinSecs;
        } else {
            progress = timedExercise.getDuration();
            timeLeftinMills = progress * 1000;
            timeLeftinSecs = progress;
            timer.setText(progress.toString());
        }
        timerBar.setProgress(progress.intValue() * 10);
        workoutType.setText(passedWorkoutType.toUpperCase() + ": ");
        fullDuration = timedExercise.getDuration();

        countDownTimer = new CountDownTimer(timeLeftinMills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress--;
                timer.setText(progress.toString());
                timerBar.setProgress((progress.intValue() * 100) / (fullDuration.intValue()));

                // beep sound for Get ready and Break pages that plays at 3, 2 and 1 seconds.
                if (progress <= 3 && progress > 0 && timedExercise.getType().equals(ExerciseType.BREAK)) {
                    try {
                        Uri sound = Uri.parse("android.resource://com.example.alafitness/" + R.raw.countdown);
                        player = MediaPlayer.create(getApplicationContext(), sound);
                        player.setLooping(false);
                        player.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFinish() {
                timerBar.setProgress(0);
                currentExercise++;
                if (currentExercise < exercises.size()) {
                    startTimer();
                } else {
                    Intent intent2 = new Intent(ExerciseActivity.this, EndActivity.class);
                    intent2.putExtra("username", user);
                    intent2.putExtra("workout type", passedWorkoutType);
                    startActivity(intent2);
                }
                //player.pause();
            }
        }.start();

        startPauseButton.setText("PAUSE");
        timerRunning = true;
    }

    /**
     * Method that defines timer stop and restart conditions.
     */
    public void startstop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer(remainingProgress);
        }
    }

    /**
     * Method to stop the timer running.
     */
    public void stopTimer() {
        remainingProgress = progress * 1000;
        countDownTimer.cancel();
        startPauseButton.setText("START");
        timerRunning = false;
    }

    /**
     * Method that provides argument for "sanity check" on startTimer() method.
     */
    public void startTimer() {
        startTimer(-1l);
    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.ENGLISH);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("tts", "Specified language not supported");
            }
        } else {
            Log.e("tts", "Initialization failed");
        }
    }

    /**
     * Method to activate TextToSpeech functionality.
     *
     * @param text - String to be "read out".
     */
    private void readItOut(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        player.stop();
        textToSpeech.stop();
    }
}
