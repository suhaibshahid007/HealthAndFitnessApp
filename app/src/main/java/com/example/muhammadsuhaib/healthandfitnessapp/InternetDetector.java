package com.example.muhammadsuhaib.healthandfitnessapp;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Muhammad Suhaib on 6/23/2018.
 */

public class InternetDetector {

    public Context context ;
    public InternetDetector(Context context) {
        this.context = context;
    }

    // here the function to check that internet is connected on android device ....

    public boolean isConnected()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);

        if(connectivityManager !=null)
        {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo !=null)
            {
                if(networkInfo.getState().equals(NetworkInfo.State.CONNECTED))
                {
                    return  true;
                }
            }

        }
        return  false;
    }

}
