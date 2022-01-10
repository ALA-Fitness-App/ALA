package com.example.alafitness.model;

public class Exercise {

    private String exerciseName;
    private String exerciseType;
    private int imageLink;
    private Long exerciseDuration;


    public Exercise(String exerciseName, String exerciseType, int imageLink, Long exerciseDuration) {
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.imageLink = imageLink;
        this.exerciseDuration = exerciseDuration;

    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int getImageLink() {
        return imageLink;
    }

    public Long getExerciseDuration() {
        return exerciseDuration;
    }
}
