package com.example.muhammadsuhaib.healthandfitnessapp;

/**
 * Created by Muhammad Suhaib on 7/3/2018.
 */

public class armsGames {

    public int imageId;
    public String gameName;
    public String gameDescription;


    public armsGames( int imageId , String gameName , String gameDescription )
    {
        this.imageId = imageId;
        this.gameName = gameName;
        this.gameDescription = gameDescription;
    }

    public String getGameName()
    {
        return gameName;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public int getImageId() {
        return imageId;
    }
}
