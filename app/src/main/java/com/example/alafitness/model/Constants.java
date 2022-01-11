package com.example.alafitness.model;

import com.example.alafitness.R;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<Exercise> getExercises() {

        ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();

        exercisesList.add(new Exercise("Plank", "Core", R.drawable.plank, 11l));
        exercisesList.add(new Exercise("Time to rest", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("Squat", "Legs", R.drawable.squat, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("Push up", "Arms", R.drawable.pushup, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("Jumping jacks", "Cardio", R.drawable.jumps, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("Toe Taps", "Core", R.drawable.toe_taps, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("Glute bridge", "Legs", R.drawable.glute_bridge, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("Commando", "Arms", R.drawable.commando, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("Burpee", "Cardio", R.drawable.burpee, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("Flutters", "Core", R.drawable.flutters, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
        exercisesList.add(new Exercise("High knees", "Cardio", R.drawable.high_knees, 11l));

        return exercisesList;
    }
}
