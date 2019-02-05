package com.example.muhammadsuhaib.healthandfitnessapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    public Intent nextActivity;
   // public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       // sharedPreferences = getSharedPreferences("data" , MODE_PRIVATE);

        nextActivity = new Intent(splashScreen.this, MainActivity.class);
/*
        if(sharedPreferences.getBoolean("flag" , false)) {

            nextActivity = new Intent(splashScreen.this, MainActivity.class);
        }
        else
        {

            nextActivity = new Intent(splashScreen.this, LoginUser.class);
        }
*/
        startSplash(nextActivity);
    }

    // here the start splash function contains thread that start splash screen for 3 seconds....

    public void startSplash(final Intent activity)
    {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);

                    startActivity(activity);
                    finish();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }


            }
        }); thread.start();


    }
}
