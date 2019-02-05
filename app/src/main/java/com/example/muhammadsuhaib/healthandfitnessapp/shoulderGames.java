package com.example.muhammadsuhaib.healthandfitnessapp;

/**
 * Created by Muhammad Suhaib on 5/30/2018.
 */

public class shoulderGames {

    public int imageId;
    public String gameName;

    public shoulderGames( int imageId,String gameName)
    {
        this.gameName = gameName;
        this.imageId = imageId;
    }

    public String getGameName() {
        return gameName;
    }

    public int getImageId() {
        return imageId;
    }
}
