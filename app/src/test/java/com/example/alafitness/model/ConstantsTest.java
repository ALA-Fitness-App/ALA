package com.example.alafitness.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

class ConstantsTest {

    @Test
    void totalWorkoutTime() {

        assertEquals(20, Constants.totalWorkoutTime("express"));
        assertEquals(22, Constants.totalWorkoutTime("pyramid"));
        assertEquals(1, Constants.totalWorkoutTime("demo"));
    }

    @Test
    void getExercisesForActivityDemo() {
        List<TimedExercise> demoList = Constants.getExercisesForActivity("demo");
        assertEquals(demoList.get(1).getType(), demoList.get(9).getType());
        assertEquals(ExerciseType.CORE, demoList.get(9).getType());
    }

    @Test
    void getExercisesForActivityExpress() {
        List<TimedExercise> expressList = Constants.getExercisesForActivity("express");
        assertEquals(expressList.get(1).getType(), expressList.get(7).getType());
        assertEquals(ExerciseType.LEGS, expressList.get(9).getType());
    }

    @Test
    void getExercisesForActivityPyramid() {
        List<TimedExercise> pyramidList = Constants.getExercisesForActivity("pyramid");
        assertNotEquals(pyramidList.get(1).getType(), pyramidList.get(7).getType());
        assertNotEquals(ExerciseType.LEGS, pyramidList.get(9).getType());
    }
}