package com.example.alafitness.model;

import com.example.alafitness.R;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<Exercise> getExercises() {

        ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();

        exercisesList.add(new Exercise("Get ready!", ExerciseType.BREAK, R.drawable.rest));
        exercisesList.add(new Exercise("Plank", ExerciseType.CORE, R.drawable.plank));
        exercisesList.add(new Exercise("Break", ExerciseType.BREAK, R.drawable.rest));
        exercisesList.add(new Exercise("Squat", ExerciseType.LEGS, R.drawable.squats));
        exercisesList.add(new Exercise("Push up", ExerciseType.ARMS, R.drawable.pushups));
        exercisesList.add(new Exercise("Jumping jacks", ExerciseType.CARDIO, R.drawable.jumps));
        exercisesList.add(new Exercise("Toe Taps", ExerciseType.CORE, R.drawable.toetap));
        exercisesList.add(new Exercise("Glute bridge", ExerciseType.LEGS, R.drawable.glutebridge));
        exercisesList.add(new Exercise("Commando", ExerciseType.ARMS, R.drawable.commando));
        exercisesList.add(new Exercise("Burpee", ExerciseType.CARDIO, R.drawable.burpee));
        exercisesList.add(new Exercise("Flutters", ExerciseType.CORE, R.drawable.flutters));
        exercisesList.add(new Exercise("Lateral lunge", ExerciseType.LEGS, R.drawable.laterallunge));
        exercisesList.add(new Exercise("Plank dips", ExerciseType.ARMS, R.drawable.plankdips));
        exercisesList.add(new Exercise("High knees", ExerciseType.CARDIO, R.drawable.highknees));
        exercisesList.add(new Exercise("Single arm superman", ExerciseType.CORE, R.drawable.singlearmsuperman));
        exercisesList.add(new Exercise("Walking lunge", ExerciseType.LEGS, R.drawable.walkinglunge));
        exercisesList.add(new Exercise("Shoulder tap", ExerciseType.ARMS, R.drawable.shouldertap));
        exercisesList.add(new Exercise("Mountain climber", ExerciseType.CARDIO, R.drawable.mountainclimbers));
        exercisesList.add(new Exercise("Ab-bikes", ExerciseType.CORE, R.drawable.ab_bikes));
        exercisesList.add(new Exercise("Squat jump", ExerciseType.LEGS, R.drawable.squatjump));
        exercisesList.add(new Exercise("Lay down push-up", ExerciseType.ARMS, R.drawable.laydownpushup));
        exercisesList.add(new Exercise("Half burpee", ExerciseType.CARDIO, R.drawable.halfburpee));
        exercisesList.add(new Exercise("Heel tap", ExerciseType.CORE, R.drawable.heeltap));      
        exercisesList.add(new Exercise("Cross body mountain climbers", ExerciseType.CARDIO, R.drawable.crossbody_mountclimber));

        return exercisesList;
    }

    public static Exercise getExercise(String exerciseName) {

        for ( Exercise exercise : getExercises() ) {
            exercise.getExerciseName();

            if (exerciseName.equals(exercise.getExerciseName())) {
                return exercise;
            }
        }
        return null;
    }

    public static List<TimedExercise> getTimedExercises() {

        ArrayList<TimedExercise> timedExercisesList = new ArrayList<>();

        timedExercisesList.add( new TimedExercise(getExercise("Get ready!"), 16l));

        return timedExercisesList;
    }
}
