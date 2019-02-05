package com.example.muhammadsuhaib.healthandfitnessapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class yogaDetailActivity extends AppCompatActivity {

    public int image_id;
    public String poseName;
    public TextView exerciseName , timerCountDown;
    public ImageView exerciseImage;

    public Button timerStartButton;

    boolean isRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_detail);

        Bundle bundle = getIntent().getExtras();
       image_id = bundle.getInt("poseImageID");
       poseName = bundle.getString("poseName");

       exerciseName = findViewById(R.id.exerciseName);
       exerciseImage =findViewById(R.id.detailImage);

       // now set the pose name and image...

        exerciseName.setText(poseName);
        exerciseImage.setImageResource(image_id);

        timerStartButton = (Button)findViewById(R.id.timerBtn);
        timerCountDown = (TextView)findViewById(R.id.timer);

        timerCountDown .setText(" ");

        // now add the count down timer on click listener of the button...

       timerStartButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (!isRunning) {

                   timerStartButton.setText("Done");
                   new CountDownTimer(10000, 1000) {

                       @Override
                       public void onTick(long millisUntilFinished) {

                           timerCountDown.setText(""+millisUntilFinished/1000);

                       }

                       @Override
                       public void onFinish() {

                       }
                   }.start();
               }

               else

               {
                   Toast.makeText(yogaDetailActivity.this, "Finish !!!", Toast.LENGTH_SHORT).show();
                   finish();
               }

               isRunning = !isRunning;
           }

       });

    }
}
