package com.example.muhammadsuhaib.healthandfitnessapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Muhammad Suhaib on 6/30/2018.
 */

public class MyBroadcastReceiver  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        buildNotification(context);
    }

    // here the function that issue notification after specific alarm interval ...

    public void buildNotification(Context context)
    {

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // here the code of pending intent to open the activity in future ...
        Intent intent = new Intent(context , MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context , 0 , intent , PendingIntent.FLAG_UPDATE_CURRENT);

        // build notification...
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentText("its meal time");
        builder.setSmallIcon(R.drawable.plate);
        builder.setAutoCancel(true);
        builder.setSound(alarmSound);
        builder.setContentIntent(pendingIntent);
        // issue notification ...
        NotificationManager nm = (NotificationManager)context.getSystemService(Service.NOTIFICATION_SERVICE);

        nm.notify(0 , builder.build());

    }
}
