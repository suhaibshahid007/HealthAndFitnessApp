package com.example.muhammadsuhaib.healthandfitnessapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.muhammadsuhaib.healthandfitnessapp.R;
import com.example.muhammadsuhaib.healthandfitnessapp.armsGamesList;
import com.example.muhammadsuhaib.healthandfitnessapp.chestGamesList;
import com.example.muhammadsuhaib.healthandfitnessapp.shoulderGamesList;

/**
 * Created by Muhammad Suhaib on 5/23/2018.
 */

public class MuscleFitness extends Fragment {

    public RelativeLayout chestGames;
    public RelativeLayout shoulderGames;
    public RelativeLayout armsExercises ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.fragement_muscle_fitness ,container , false);

       chestGames = v.findViewById(R.id.chestFit);
       shoulderGames = v.findViewById(R.id.shoulderFit);
       armsExercises = v.findViewById(R.id.armsFit);

       chestGames.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent =  new Intent(getActivity(),chestGamesList.class);
               startActivity(intent);
           }
       });

       shoulderGames.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(getActivity() , shoulderGamesList.class);
               startActivity(intent);
           }
       });

       armsExercises.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity() , armsGamesList.class);
               startActivity(intent);
           }
       });
       return v;
    }
}
