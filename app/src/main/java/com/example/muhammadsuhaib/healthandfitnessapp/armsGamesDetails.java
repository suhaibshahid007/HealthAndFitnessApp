package com.example.muhammadsuhaib.healthandfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class armsGamesDetails extends AppCompatActivity {

    public TextView gamesName;
    public GifImageView gifImageView;
    public ImageView bulletImage;
    public TextView gameDes;
    public TextView gamesDesSecond;
    public TextView gameScheduleName;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_arms_games_details);


            gifImageView = (GifImageView) findViewById(R.id.gifImage);
            gamesName = (TextView)findViewById(R.id.exerciseName);
            bulletImage = (ImageView)findViewById(R.id.bulletGame);
            gameDes = (TextView)findViewById(R.id.gameInstructionsOne);
            gamesDesSecond = (TextView)findViewById(R.id.gameInstructionsTwo);
            gameScheduleName = (TextView)findViewById(R.id.gameScheduleName);

            // here get the data from the bundle ....

            Bundle bundle =  getIntent().getExtras();
            String exerciseName = bundle.getString("exerciseName");
            int imageId = bundle.getInt("imageId");

            gamesName.setText(exerciseName);
            gifImageView.setImageResource(imageId);

            if (exerciseName.equals("Cable Biceps Curl")) {
                gameDes.setText("Adjsut pulley to lowest position.While standing with back straight, hold handle with overhand Grip.Handle is positioned in front of your thighs ");
                gamesDesSecond.setText("Lift handle up while keeping your upper arms in place.Refrain from using your shoulders during the movement.Hold for one Second. Return to startig position");
                gameScheduleName.setText("Cable Biceps Curl");
            }
            else if (exerciseName.equals("Cable Pushdown (OverHand Grip)")){
                gameDes.setText("Adjust pulley to the highest level.Hold handle with overhand Grip.Stand with feet shoulder with apart. Keep your back straight");
                gamesDesSecond.setText("While keeping your upper arms stationary, pull handle downward.Hold for one second.Return to starting position");
                gameScheduleName.setText("Cable Pushdown Triceps");
            }
            else if(exerciseName.equals("Cable Tricep Extension"))
            {
                gifImageView.setImageResource(R.drawable.cabletricepextension);
                gamesName.setText("Cable Triceps Extension)");
                // bulletImage.setImageResource(R.drawable.bulletmark);
                gameDes.setText("Adjust pulley at the highest position.Face away from the pulley.Keep back bend and straight.Hold onto the handle behind you with overhand Grip and hold it overhead.");
                gamesDesSecond.setText("Fully straightened out your arm.Hol for one second.Return to starting position.");
                gameScheduleName.setText("Cable Triceps Extension");
            }
            else if(exerciseName.equals("Dumbbell Bicep Curl"))
            {
                gifImageView.setImageResource(R.drawable.dumbellbicepcurl);
                gamesName.setText("Dumbbell Biceps Curl");
                //  bulletImage.setImageResource(R.drawable.bulletmark);
                gameDes.setText("Stand up straight with a dumbbell in each hand at arm's length. Keep your elbows close to your torso and rotate the palms of your hands until they are facing forward. This will be your starting position.");
                gamesDesSecond.setText("Now, keeping the upper arms stationary, exhale and curl the weights while contracting your biceps. Continue to raise the weights until your biceps are fully contracted and the dumbbells are at shoulder level. Hold the contracted position for a brief pause as you squeeze your biceps.Then, inhale and slowly begin to lower the dumbbells back to the starting position.");
                gameScheduleName.setText("Dumbbell Biceps Curl");
            }
            else if(exerciseName.equals("Bodyweigt Bench Dips"))
            {
                gifImageView.setImageResource(R.drawable.bicepsdips);
                gamesName.setText("Bodyweight Bench Dips");
                // bulletImage.setImageResource(R.drawable.bulletmark);
                gameDes.setText("Place your palms at the edge of the bench with fingers curled around the edge of the bench.Keep your arms wider than the shoulder with apart.Position the rest of your body in front of the bench.Keep legs straight." );
                gamesDesSecond.setText("Bend your arms until your upper arms are parallel with teh ground.Hold for a second.Return to starting position. ");
            }
            else if(exerciseName.equals("Fat Grip Bicep Curl"))
            {
                gifImageView.setImageResource(R.drawable.flatbicepcurl);
                gamesName.setText("Fat Grip Bicep Curl");
                //  bulletImage.setImageResource(R.drawable.bulletmark);
                gameDes.setText("Place a Fat Grip Opens a New Window.  around the dumbbell handle and perform your bicep curls. (If you don’t have a Fat Grip, wrap a small towel around the handle.)");
                gamesDesSecond.setText("With a thicker handle, you have to squeeze much harder just to hold the same amount of weight, which boosts your neural drive and activate more musculature. Also, because it strengths your grip, it allows you to hold more weight during conventional bicep exercises. ");
                gameScheduleName.setText("Fat Grip Bicep Curl");
            }
            else if(exerciseName.equals("Dumbbell Triceps Extension"))
            {
                gifImageView.setImageResource(R.drawable.dumbeltricepextension);
                gamesName.setText("Dumbbell Triceps Extension(Flat Bench)");
                //  bulletImage.setImageResource(R.drawable.bulletmark);
                gameDes.setText("Lie back on the flat bench.Hold dumbbell with both hands.Fully extend arms above your head.");
                gamesDesSecond.setText("While keeping your upper arms stationary,lower the dumbbell until it is behind your head.Refrain from flaring your elbows.Hold for one second.Return to starting position.");
                gameScheduleName.setText("Dumbbell Triceps Extension(Flat Bench)");
            }
            else if(exerciseName.equals("EZ Curl Bar Biceps"))
            {
                gifImageView.setImageResource(R.drawable.ezcurlbiceps);
                gamesName.setText("EZ Curl Biceps(Underhand Grip)");
                //   bulletImage.setImageResource(R.drawable.bulletmark);
                gameDes.setText("While standing with back staright,hold EZ curl bar with shoulder width underhand Grip. EZ curl bar is positioned in front of your thighs.");
                gamesDesSecond.setText("Lift EZ curl bar up while keeping your upper arms in place.Keeping your upper arms in place.Refrain from using your shoulders during the movement.Hold for one second.Lower your arms back to the starting position.");
                gameScheduleName.setText("EZ Curl Biceps(Underhand Grip)");

            }
        }
    }
