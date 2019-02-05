package com.example.muhammadsuhaib.healthandfitnessapp.Fragments;


import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.muhammadsuhaib.healthandfitnessapp.MainActivity;
import com.example.muhammadsuhaib.healthandfitnessapp.MyBroadcastReceiver;
import com.example.muhammadsuhaib.healthandfitnessapp.R;

/**
 * Created by Muhammad Suhaib on 6/27/2018.
 */

public class More extends Fragment {

    public SwitchCompat font_setting , meal_setting ;
    public SharedPreferences sharedPreferences ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_more , null);

        font_setting = (SwitchCompat)v.findViewById(R.id.font_switch);
        meal_setting = (SwitchCompat)v.findViewById(R.id.diet_switch);

        // here generate the shared preferenences to store the state of switches ...

        sharedPreferences = getActivity().getSharedPreferences("my_data", Context.MODE_PRIVATE);

        // call fucntion to maintain the previous state of switch combat...
        checkSwitchesState();

          // here the code for font settings ....
        font_setting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    sharedPreferences.edit().putBoolean("font" , true).commit();
                    Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                    startActivity(intent);
                }
                else
                {
                    sharedPreferences.edit().putBoolean("font" , false).commit();
                }
            }
        });

        // here the code for the switch settings ....

        meal_setting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    sharedPreferences.edit().putBoolean("meal",true).commit();
                    startMealReminder();
                }
                else
                {
                    sharedPreferences.edit().putBoolean("meal",false).commit();
                    stopMealReminder();
                }
            }
        });

        return v;
    }

    // here the function that start the diet reminder ...

    public void startMealReminder()
    {
        Intent intent = new Intent(getActivity() , MyBroadcastReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity() , 0 , intent , PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Service.ALARM_SERVICE);
        int interval = 1000 * 16;

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , System.currentTimeMillis() , interval , pendingIntent);

    }

    // here the function that stop the meal reminder .....

    public void stopMealReminder()
    {

        Intent intent = new Intent(getActivity() , MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity() , 0 , intent , PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Service.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }

    // here the function that check if switch is on then set the switch on and vice versa ....
    private void checkSwitchesState() {

        Boolean font , meal;

        font = sharedPreferences.getBoolean("font" , false);
        meal = sharedPreferences.getBoolean("meal" , false);
        if(font)
        {
            font_setting.setChecked(true);
        }

        if(meal)
        {
           meal_setting.setChecked(true);
        }
    }
}
