package com.example.muhammadsuhaib.healthandfitnessapp;

import java.io.Serializable;

/**
 * Created by Muhammad Suhaib on 5/24/2018.
 */

public class chestGames  {

    public int imageId;
    public String gameName;
    public String gameDescription;


    public chestGames( int id , String gameName , String gameDescription )
    {
        this.imageId = id;
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
