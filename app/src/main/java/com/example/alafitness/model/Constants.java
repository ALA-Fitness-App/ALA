package com.example.alafitness.model;

import com.example.alafitness.R;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<Exercise> getExercises() {

        ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();

        exercisesList.add(new Exercise("Get ready!", "Get ready!", R.drawable.rest, 6l));
        exercisesList.add(new Exercise("Plank", "Core", R.drawable.plank, 11l));
        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 6l));
        exercisesList.add(new Exercise("Squat", "Legs", R.drawable.squats, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 6l));
//        exercisesList.add(new Exercise("Push up", "Arms", R.drawable.pushups, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Jumping jacks", "Cardio", R.drawable.jumps, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Toe Taps", "Core", R.drawable.toetap, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Glute bridge", "Legs", R.drawable.glutebridge, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Commando", "Arms", R.drawable.commando, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Burpee", "Cardio", R.drawable.burpee, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Flutters", "Core", R.drawable.flutters, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Lateral lunge", "Legs", R.drawable.laterallunge, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Plank dips", "Arms", R.drawable.plankdips, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("High knees", "Cardio", R.drawable.highknees, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Single arm superman", "Core", R.drawable.singlearmsuperman, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Walking lunge", "Legs", R.drawable.walkinglunge, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Shoulder tap", "Arms", R.drawable.shouldertap, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Mountain climber", "Cardio", R.drawable.mountainclimbers, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Ab-bikes", "Core", R.drawable.ab_bikes, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Squat jump", "Legs", R.drawable.squatjump, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Lay down push-up", "Arms", R.drawable.laydownpushup, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Half burpee", "Cardio", R.drawable.halfburpee, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Heel tap", "Core", R.drawable.heeltap, 11l));
//        exercisesList.add(new Exercise("Break", "Break", R.drawable.rest, 11l));
//        exercisesList.add(new Exercise("Cross body mountain climbers", "Cardio", R.drawable.crossbody_mountclimber, 11l));

        return exercisesList;
    }
}
