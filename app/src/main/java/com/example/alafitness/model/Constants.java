package com.example.alafitness.model;

import static com.example.alafitness.model.ExerciseType.ARMS;
import static com.example.alafitness.model.ExerciseType.CARDIO;
import static com.example.alafitness.model.ExerciseType.LEGS;
import static com.example.alafitness.model.ExerciseType.CORE;

import com.example.alafitness.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Constants {

    public static List<Exercise> getExercises() {

        ArrayList<Exercise> exercisesList = new ArrayList<>();

        exercisesList.add(new Exercise("Get ready!", ExerciseType.BREAK, R.drawable.rest));
        exercisesList.add(new Exercise("Break", ExerciseType.BREAK, R.drawable.rest));

        exercisesList.add(new Exercise("Plank", ExerciseType.CORE, R.drawable.plank));
        exercisesList.add(new Exercise("Toe Taps", ExerciseType.CORE, R.drawable.toetap));
        exercisesList.add(new Exercise("Flutters", ExerciseType.CORE, R.drawable.flutters));
        exercisesList.add(new Exercise("Ab-bikes", ExerciseType.CORE, R.drawable.ab_bikes));
        exercisesList.add(new Exercise("Heel tap", ExerciseType.CORE, R.drawable.heeltap));
        exercisesList.add(new Exercise("X mountain climbers", ExerciseType.CORE, R.drawable.crossbody_mountclimber));
        exercisesList.add(new Exercise("Side dips", CORE, R.drawable.plankdips));

        exercisesList.add(new Exercise("Squat", ExerciseType.LEGS, R.drawable.squats));
        exercisesList.add(new Exercise("Glute bridge", ExerciseType.LEGS, R.drawable.glutebridge));
        exercisesList.add(new Exercise("Lateral lunge", ExerciseType.LEGS, R.drawable.laterallunge));
        exercisesList.add(new Exercise("Lunge", ExerciseType.LEGS, R.drawable.walkinglunge));

        exercisesList.add(new Exercise("Push up", ARMS, R.drawable.pushups));
        exercisesList.add(new Exercise("Commando", ARMS, R.drawable.commando));
        exercisesList.add(new Exercise("Single arm superman", ExerciseType.ARMS, R.drawable.singlearmsuperman));
        exercisesList.add(new Exercise("Shoulder tap", ARMS, R.drawable.shouldertap));
        exercisesList.add(new Exercise("Lay down push-up", ARMS, R.drawable.laydownpushup));

        exercisesList.add(new Exercise("Jumping jacks", ExerciseType.CARDIO, R.drawable.jumps));
        exercisesList.add(new Exercise("Burpee", ExerciseType.CARDIO, R.drawable.burpee));
        exercisesList.add(new Exercise("High knees", ExerciseType.CARDIO, R.drawable.highknees));
        exercisesList.add(new Exercise("Mountain climber", ExerciseType.CARDIO, R.drawable.mountainclimbers));
        exercisesList.add(new Exercise("Squat jump", ExerciseType.CARDIO, R.drawable.squatjump));
        exercisesList.add(new Exercise("Half burpee", ExerciseType.CARDIO, R.drawable.halfburpee));

        return exercisesList;
    }

    public static Exercise getExercise(String exerciseName) {

        for (Exercise exercise : getExercises()) {
            exercise.getExerciseName();

            if (exerciseName.equals(exercise.getExerciseName())) {
                return exercise;
            }
        }
        return null;
    }

    public static List<Exercise> getRandomExerciseList(ExerciseType exerciseType) {

        List<Exercise> typeOfExercises = new ArrayList<>();
        List<Exercise> randomList = new ArrayList<>();

        for (Exercise exercise : getExercises()) {
            exercise.getExerciseType();

            if (exerciseType.equals(exercise.getExerciseType())) {
                typeOfExercises.add(exercise);
            }
        }

        Collections.shuffle(typeOfExercises);
        Exercise randomExercise1 = typeOfExercises.get(0);
        Exercise randomExercise2 = typeOfExercises.get(1);
        Exercise randomExercise3 = typeOfExercises.get(2);

        randomList.add(randomExercise1);
        randomList.add(randomExercise2);
        randomList.add(randomExercise3);

        return randomList;
    }

    public static List<TimedExercise> getExpressExercises() {

        ArrayList<TimedExercise> expressExercisesList = new ArrayList<>();

        expressExercisesList.add(new TimedExercise(getExercise("Get ready!"), 16l));

        for (int i = 0; i < 2; i++) {
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(0), 41l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(0), 41l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(0), 41l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 11l));
        }

        for (int i = 0; i < 3; i++) {
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(0), 31l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(1), 31l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(1), 31l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 11l));
        }

        for (int i = 0; i < 4; i++) {
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(1), 21l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(2), 21l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(2), 21l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 11l));
        }

        expressExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(0), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(0), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(0), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 11l));
        expressExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(0), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(1), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(1), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 11l));
        expressExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(1), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(2), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(2), 21l));

        return expressExercisesList;
    }

    public static List<TimedExercise> getPyramidExercises() {

        ArrayList<TimedExercise> pyramidExercisesList = new ArrayList<>();

        pyramidExercisesList.add(new TimedExercise(getExercise("Get ready!"), 16l));

        for (int i = 0; i < 3; i++) {
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(0), 21l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(0), 31l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(1), 41l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(0), 31l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(0), 21l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 31l));
        }

        for (int i = 0; i < 3; i++) {
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(1), 11l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(1), 21l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(2), 31l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(2), 21l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(2), 11l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 31l));
        }

        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(0), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(0), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(1), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(0), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(0), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 61l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(1), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(1), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(2), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(2), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(2), 21l));

        return pyramidExercisesList;
    }

    public static List<TimedExercise> getDemoExercises() {

        ArrayList<TimedExercise> demoExercisesList = new ArrayList<>();

        demoExercisesList.add(new TimedExercise(getExercise("Get ready!"), 11l));

        demoExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(0), 11l));
        demoExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        demoExercisesList.add(new TimedExercise(getRandomExerciseList(LEGS).get(0), 16l));
        demoExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        demoExercisesList.add(new TimedExercise(getRandomExerciseList(CARDIO).get(0), 11l));
        demoExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        demoExercisesList.add(new TimedExercise(getRandomExerciseList(ARMS).get(0), 16l));
        demoExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        demoExercisesList.add(new TimedExercise(getRandomExerciseList(CORE).get(1), 11l));

        return demoExercisesList;
    }
}
