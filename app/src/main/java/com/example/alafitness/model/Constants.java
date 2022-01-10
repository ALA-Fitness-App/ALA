package com.example.alafitness.model;

import com.example.alafitness.R;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<Exercise> getExercises() {

        ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();

        exercisesList.add(new Exercise("Plank", "Core", R.drawable.plank, 10_000));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.workout_end, 10_000));
        exercisesList.add(new Exercise("Squat", "Legs", R.drawable.squat, 10_000));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.workout_end, 10_000));
        exercisesList.add(new Exercise("Push up", "Arms", R.drawable.pushup, 10_000));

        return exercisesList;
    }
}
