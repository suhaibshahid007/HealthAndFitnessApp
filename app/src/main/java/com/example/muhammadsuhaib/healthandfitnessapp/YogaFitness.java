package com.example.muhammadsuhaib.healthandfitnessapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Muhammad Suhaib on 6/2/2018.
 */

public class YogaFitness extends Fragment {

    public RecyclerView recyclerView;
    public ArrayList<YogaExercises> yogaList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragement_yoga_fitness , container ,false);

        recyclerView = (RecyclerView)v.findViewById(R.id.recylerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        yogaList = new ArrayList<YogaExercises>();
        // call the function that add the object in the array list ...



         fillYogaData();

         yogaExercisesAdapter adapter = new yogaExercisesAdapter(getContext() , yogaList);
          recyclerView.setAdapter(adapter);


        return  v ;

    }

    public void fillYogaData()
    {
        yogaList.add(new YogaExercises(R.drawable.easy_pose ,"Easy Pose"));
        yogaList.add(new YogaExercises(R.drawable.cobra_pose ,"Cobra Pose"));
        yogaList.add(new YogaExercises(R.drawable.downward_facing_dog ,"Downward Facing Dog"));
        yogaList.add(new YogaExercises(R.drawable.boat_pose ,"Boat Pose"));
        yogaList.add(new YogaExercises(R.drawable.half_pigeon ,"Half Pigeon"));
        yogaList.add(new YogaExercises(R.drawable.low_lunge ,"Low Lunge"));
        yogaList.add(new YogaExercises(R.drawable.upward_bow ,"Upward Bow"));
        yogaList.add(new YogaExercises(R.drawable.crescent_lunge ,"Crescent Lunge"));
        yogaList.add(new YogaExercises(R.drawable.warrior_pose ,"Warrior Pose"));
        yogaList.add(new YogaExercises(R.drawable.bow_pose ,"Bow Pose"));
        yogaList.add(new YogaExercises(R.drawable.warrior_pose_2 ,"Warrior Pose 2"));
    }
}
