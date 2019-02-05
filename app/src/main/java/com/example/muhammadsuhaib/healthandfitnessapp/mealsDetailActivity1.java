package com.example.muhammadsuhaib.healthandfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class mealsDetailActivity1 extends AppCompatActivity {
    public TextView day;
    public ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_detail1);

        day = findViewById(R.id.dayName);
        image = findViewById(R.id.image1);
        // get the data from the bundle..

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("day");

        if(data.equals("1"))
        {
            day.setText("Day 1");
        }
        else if(data.equals("2"))
        {
            day.setText("Day 2");

        }
        else if(data.equals("3"))
        {
            day.setText("Day 3");

        }
        else if(data.equals("4"))
        {
            day.setText("Day 4");
        }
        else if(data.equals("5"))
        {
            day.setText("Day 5");
        }
        else if(data.equals("6"))
        {
            day.setText("Day 6");
        }
        else
        {
            day.setText("Day 7");
        }
    }
}
