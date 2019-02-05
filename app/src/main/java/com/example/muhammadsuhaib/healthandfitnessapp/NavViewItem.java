package com.example.muhammadsuhaib.healthandfitnessapp;

/**
 * Created by Muhammad Suhaib on 5/5/2018.
 */

public class NavViewItem {

    private String icon ;
    private String itemName;

    // constructor..
    public NavViewItem(String i , String n)
    {
        icon = i;
        itemName = n;
    }

    public String getIcon() {
        return icon;
    }

    public String getItemName()
    {
        return itemName;
    }
}
