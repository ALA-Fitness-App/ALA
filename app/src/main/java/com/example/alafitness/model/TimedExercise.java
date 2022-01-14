package com.example.alafitness.model;

public class TimedExercise {

    Exercise exercise;
    Long duration;

    public TimedExercise(Exercise exercise, Long duration) {
        this.exercise = exercise;
        this.duration = duration;
    }

    public String getName() {
        return exercise.getExerciseName();
    }

    public ExerciseType getType() {
        return exercise.getExerciseType();
    }

    public int getImageLink() {
        return exercise.getImageLink();
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
