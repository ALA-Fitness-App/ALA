package com.example.alafitness.model;

import static com.example.alafitness.model.ExerciseType.ARMS;
import static com.example.alafitness.model.ExerciseType.CARDIO;
import static com.example.alafitness.model.ExerciseType.LEGS;
import static com.example.alafitness.model.ExerciseType.CORE;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.alafitness.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that lists all exercises available, and holds the information about the different workout types,
 * as well as methods to find an exercise by name, find all exercises of same type and shuffling their order,
 * and calculating the total workout time in minutes.
 */
public class Constants {

    /**
     * List of all the exercises as objects with a name, type and image.
     *
     * @retrun exercisesList - ArrayList.
     */
    private static List<Exercise> getExercises() {
        ArrayList<Exercise> exercisesList = new ArrayList<>();

        exercisesList.add(new Exercise("Get ready!", ExerciseType.BREAK, R.drawable.setreadygo));
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

    /**
     * Method to find an exercise with the specific name.
     *
     * @param exerciseName - String.
     * @return exercise - the exercise object that matches the specified exercise name.
     */
    private static Exercise getExercise(String exerciseName) {
        for (Exercise exercise : getExercises()) {
            exercise.getExerciseName();
            if (exerciseName.equals(exercise.getExerciseName())) {
                return exercise;
            }
        }
        return null;
    }

    /**
     * Method selects exercises with the specific type, adds them to an ArrayList and
     * shuffles it, then adds the shuffled exercises in order into a new ArrayList.
     *
     * @param exerciseType - Enum explaining type of exercise (CORE, LEGS, ARMS, CARDIO, BREAK).
     * @return randomList - an ArrayList containing exercises in random order.
     */
    private static ArrayList<Exercise> getRandomExerciseList(ExerciseType exerciseType) {
        List<Exercise> typeOfExercises = new ArrayList<>();
        ArrayList<Exercise> randomList = new ArrayList<>();
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

    /**
     * List of exercises for Express workout type, each exercise duration is set here.
     *
     * @return expressExercisesList - ArrayList.
     */
    private static List<TimedExercise> getExpressExercises() {
        ArrayList<TimedExercise> expressExercisesList = new ArrayList<>();
        ArrayList<Exercise> armsList = getRandomExerciseList(ARMS);
        ArrayList<Exercise> legsList = getRandomExerciseList(LEGS);
        ArrayList<Exercise> coreList = getRandomExerciseList(CORE);
        ArrayList<Exercise> cardioList = getRandomExerciseList(CARDIO);

        expressExercisesList.add(new TimedExercise(getExercise("Get ready!"), 16l));

        for (int i = 0; i < 2; i++) {
            expressExercisesList.add(new TimedExercise(armsList.get(0), 41l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(legsList.get(0), 41l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(cardioList.get(0), 41l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 11l));
        }

        for (int i = 0; i < 3; i++) {
            expressExercisesList.add(new TimedExercise(coreList.get(0), 31l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(cardioList.get(1), 31l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(legsList.get(1), 31l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 11l));
        }

        for (int i = 0; i < 4; i++) {
            expressExercisesList.add(new TimedExercise(coreList.get(1), 21l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(armsList.get(2), 21l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            expressExercisesList.add(new TimedExercise(cardioList.get(2), 21l));
            expressExercisesList.add(new TimedExercise(getExercise("Break"), 11l));
        }

        expressExercisesList.add(new TimedExercise(armsList.get(0), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(legsList.get(0), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(cardioList.get(0), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(coreList.get(0), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(cardioList.get(1), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(legsList.get(1), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(coreList.get(1), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(armsList.get(2), 21l));
        expressExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        expressExercisesList.add(new TimedExercise(cardioList.get(2), 21l));

        return expressExercisesList;
    }

    /**
     * List of exercises for Pyramid workout type, each exercise duration is set here.
     *
     * @return pyramidExercisesList - ArrayList.
     */
    private static List<TimedExercise> getPyramidExercises() {
        ArrayList<TimedExercise> pyramidExercisesList = new ArrayList<>();
        ArrayList<Exercise> armsList = getRandomExerciseList(ARMS);
        ArrayList<Exercise> legsList = getRandomExerciseList(LEGS);
        ArrayList<Exercise> coreList = getRandomExerciseList(CORE);
        ArrayList<Exercise> cardioList = getRandomExerciseList(CARDIO);

        pyramidExercisesList.add(new TimedExercise(getExercise("Get ready!"), 16l));

        for (int i = 0; i < 3; i++) {
            pyramidExercisesList.add(new TimedExercise(legsList.get(0), 21l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(coreList.get(0), 31l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(legsList.get(1), 41l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(armsList.get(0), 31l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(cardioList.get(0), 21l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 31l));
        }

        for (int i = 0; i < 3; i++) {
            pyramidExercisesList.add(new TimedExercise(coreList.get(1), 11l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(armsList.get(1), 21l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(coreList.get(2), 31l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(legsList.get(2), 21l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
            pyramidExercisesList.add(new TimedExercise(cardioList.get(2), 11l));
            pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 31l));
        }

        pyramidExercisesList.add(new TimedExercise(legsList.get(0), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(coreList.get(0), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(legsList.get(1), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(armsList.get(0), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(cardioList.get(0), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(coreList.get(1), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(armsList.get(1), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(coreList.get(2), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(legsList.get(2), 21l));
        pyramidExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        pyramidExercisesList.add(new TimedExercise(cardioList.get(2), 21l));

        return pyramidExercisesList;
    }

    /**
     * List of exercises for Demo workout, each exercise duration is set here.
     *
     * @return demoExercisesList - ArrayList.
     */
    private static List<TimedExercise> getDemoExercises() {
        ArrayList<TimedExercise> demoExercisesList = new ArrayList<>();
        ArrayList<Exercise> armsList = getRandomExerciseList(ARMS);
        ArrayList<Exercise> legsList = getRandomExerciseList(LEGS);
        ArrayList<Exercise> coreList = getRandomExerciseList(CORE);
        ArrayList<Exercise> cardioList = getRandomExerciseList(CARDIO);

        demoExercisesList.add(new TimedExercise(getExercise("Get ready!"), 11l));

        demoExercisesList.add(new TimedExercise(coreList.get(0), 11l));
        demoExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        demoExercisesList.add(new TimedExercise(legsList.get(0), 16l));
        demoExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        demoExercisesList.add(new TimedExercise(cardioList.get(0), 11l));
        demoExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        demoExercisesList.add(new TimedExercise(armsList.get(0), 16l));
        demoExercisesList.add(new TimedExercise(getExercise("Break"), 6l));
        demoExercisesList.add(new TimedExercise(coreList.get(1), 11l));

        return demoExercisesList;
    }

    /**
     * Method that calculates total workout time in minutes.
     *
     * @param passedActivity - String describing workout type.
     * @return totalDuration/60 - int, time in minutes.
     */
    public static int totalWorkoutTime(String passedActivity) {
        int totalDuration = 0;
        for (TimedExercise exercise : getExercisesForActivity(passedActivity)) {
            totalDuration += exercise.getDuration().intValue();
        }
        return totalDuration / 60; // to convert seconds to minutes
    }

    /**
     * Method that defines the type of workout that is called from the ExerciseActivity class.
     *
     * @param passedActivity - String, workout type e.g demo, express.
     * @return List<TimedExercise> - list of exercises depending on the workout type.
     */
    public static List<TimedExercise> getExercisesForActivity(String passedActivity) {
        switch (passedActivity) {
            case "demo":
                return getDemoExercises();
            case "express":
                return getExpressExercises();
            case "pyramid":
                return getPyramidExercises();
            default:
                Log.e("passed workout type", "The workout type not recognised.");
        }
        return null;
    }
}
