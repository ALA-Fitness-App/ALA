package com.example.alafitness.model;

/**
 * Class that describes Exercise object,
 * has variables to set a duration time for an exercise.
 * Contains argument constructor and relevant getters.
 */
public class Exercise {
    private String exerciseName;
    private ExerciseType exerciseType;
    private int imageLink;

    public Exercise(String exerciseName, ExerciseType exerciseType, int imageLink) {
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.imageLink = imageLink;
            }

    public String getExerciseName() {
        return exerciseName;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public int getImageLink() {
        return imageLink;
    }

}
