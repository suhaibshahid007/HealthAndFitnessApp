package com.example.muhammadsuhaib.healthandfitnessapp;

/**
 * Created by Muhammad Suhaib on 6/2/2018.
 */

public class YogaExercises {

    public int imageId;
    public String exerciseName;

    public YogaExercises(int imageId, String exerciseName) {
        this.imageId = imageId;
        this.exerciseName = exerciseName;
    }

    // here the getter functions...

    public int getImageId() {
        return imageId;
    }

    public String getExerciseName() {
        return exerciseName;
    }
}
