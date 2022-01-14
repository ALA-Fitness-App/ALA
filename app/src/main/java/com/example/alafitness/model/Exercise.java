package com.example.alafitness.model;

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
