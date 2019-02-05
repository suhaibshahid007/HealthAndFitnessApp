package com.example.muhammadsuhaib.healthandfitnessapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.muhammadsuhaib.healthandfitnessapp.R;
import com.example.muhammadsuhaib.healthandfitnessapp.mealsDetailActivity1;

/**
 * Created by Muhammad Suhaib on 5/13/2018.
 */

public class WeightGain extends Fragment {

    public RelativeLayout day1,day2,day3,day4,day5,day6,day7;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weight_gain,container,false);


        day1 = v.findViewById(R.id.day1);
        day2 = v.findViewById(R.id.day2);
        day3 = v.findViewById(R.id.day3);
        day4 = v.findViewById(R.id.day4);
        day5 = v.findViewById(R.id.day5);
        day6 = v.findViewById(R.id.day6);
        day7 = v.findViewById(R.id.day7);
        // here the click listener ...
        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , mealsDetailActivity1.class);
                i.putExtra("day" ,"1");
                startActivity(i);
            }
        });

        day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , mealsDetailActivity1.class);
                i.putExtra("day" ,"2");
                startActivity(i);
            }
        });

        day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , mealsDetailActivity1.class);
                i.putExtra("day" ,"3");
                startActivity(i);
            }
        });

        day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , mealsDetailActivity1.class);
                i.putExtra("day" ,"4");
                startActivity(i);
            }
        });

        day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , mealsDetailActivity1.class);
                i.putExtra("day" ,"5");
                startActivity(i);
            }
        });

        day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , mealsDetailActivity1.class);
                i.putExtra("day" ,"6");
                startActivity(i);
            }
        });

        day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , mealsDetailActivity1.class);
                i.putExtra("day" ,"7");
                startActivity(i);
            }
        });

        return v;
    }

}
