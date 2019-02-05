package com.example.muhammadsuhaib.healthandfitnessapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class chestGameDetails extends AppCompatActivity {

    public TextView gamesName;
    public GifImageView gifImageView;
    public ImageView bulletImage;
    public TextView gameDes;
    public TextView gamesDesSecond;
    public TextView gameScheduleName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_game_details);


        gifImageView = (GifImageView) findViewById(R.id.gifImage);
        gamesName = (TextView)findViewById(R.id.exerciseName);
        bulletImage = (ImageView)findViewById(R.id.bulletGame);
        gameDes = (TextView)findViewById(R.id.gameInstructionsOne);
        gamesDesSecond = (TextView)findViewById(R.id.gameInstructionsTwo);
        gameScheduleName = (TextView)findViewById(R.id.gameScheduleName);
        // here the get the object from the intent...

        Bundle bundle = getIntent().getExtras();
        int imageId = bundle.getInt("imageId");
        String exerciseName = bundle.getString("exerciseName");
       // int position = getIntent().getExtras().getInt("data");

        gifImageView.setImageResource(imageId);
        gamesName.setText(exerciseName);

        if (exerciseName.equals("Bodyweight Pushup")) {

            gameDes.setText("Lie down the chest first with your hands on the Floor.Position hands next to your lower chest. Lift yourself with your arms so that only your hands and toes are on the floor.Maintain a straight back. ");
            gamesDesSecond.setText("Lower yourself until your chest is inches away from the Floor by bending your elbows. The elbows should bend towards your feet. Hold for one second. Return to your starting position");
            gameScheduleName.setText("Bodyweight Pushup(Floor_Regular Grip)");
        }
        else if (exerciseName.equals("Barbell Bench Press")){
            gameDes.setText("Lie back on the flat bench. Hold the barbell with overhand Grip. Distance between your hands is slightly wider than shoulder width. Hold the barbell with arms fully extended. The barbell is directly above your chest.");
            gamesDesSecond.setText(" Lower the barbell towards your lower chest as you keep your elbows close to your body. The barbell should slightly touch your chest at the end of movement. Keep your entire back on bench at all times. Refrain from any leg movements");
             gameScheduleName.setText("Barbell Bench Press");
        }
        else if(exerciseName.equals("Cable Crossover (High)"))
        {
            gameDes.setText("Adjust two pulleys to the highest position. Stand straight with feet shoulder with apart. Hold each handle with overhand Grip");
            gamesDesSecond.setText("Pull the pulley handles downwards until your forearms cross. Hold for one second. Return to starting position.");
            gameScheduleName.setText("Cable Crossover (High)");
        }
        else if(exerciseName.equals("Cable Fly(One Sided)"))
        {
            gameDes.setText("Adjust two pulleys to the lowest position. Lie down on the flat bench in between the pulleys. Hold onto the handles with neutral Grip. Extend your arms to your sides with a slight bend in your elbows.");
            gamesDesSecond.setText("Bring the handles towards the center of your chest without bending your elbows. Hold for one second. Return to starting position.");
            gameScheduleName.setText("Cable Fly(One Sided)");
        }
        else if(exerciseName.equals("Dumbbell Bench Press"))
        {
            gameDes.setText("Lie back on the flat bench. Hold the dumbbells with overhand Grip. Keep your arms fully extended." );
            gamesDesSecond.setText("Lower the dumbbells towards your lower chest as you keep your elbows close to your body. Hold for a brief movement, Return to starting position. Keep your entire back on the bench all the times. Refrain from any leg movements.");
            gameScheduleName.setText("Dumbbell Bench Press");
        }
        else if(exerciseName.equals("Dumbbell Floor Press"))
        {
            gameDes.setText("Lie down on the Floor. Grasp the dumbbells woith overhand Grip. Rest your upper arms on the Floor while pointing dumbbells toward the ceiling.");
            gamesDesSecond.setText("Fully extend arms towards the ceiling. Hold for one second. Keep your entire back on the bench at all times. Refrain from any leg movements. Return to starting position.");
            gameScheduleName.setText("Dumbbell Floor Press");
        }
        else if(exerciseName.equals("Dumbbell Fly(Flat Bench)"))
        {
            gameDes.setText("Lie down on the flat bench. Hold onto two dumbbells with neutral Grip. Fully extend your arms above your chest.");
            gamesDesSecond.setText("While maintaining a slight bend in your elbows, lower dumbbells to each side until the dumbbells are next to upper body. Hodl for one second. Return to starting position.");
            gameScheduleName.setText("Dumbbell Fly(Flat Bench)");
        }
        else if(exerciseName.equals("Rod Bench Press(Close Grip)"))
        {
            gameDes.setText("Grasp a barbell with an overhand grip 6 to 12 inches apart and hold it above your sternum with arms completely straight.");
            gamesDesSecond.setText("Slowly lower the bar down to your chest. Make sure you keep your elbows tucked in close to your sides, your upper arms forming a 45-degree angle to your body. Pause, and then press the bar in a straight line back up to the starting position.");
            gameScheduleName.setText("Rod Bench Press(Close Grip)");

        }
        else if(exerciseName.equals("Kettlebell Bench Press (Incline)"))
        {
            gameDes.setText("Lie back on the incline bench. Grasp the kettlebells with overhand Grip. Hold the kettlebells with arms fully extended. Kettlebells are directly above the center of your chest.");
            gamesDesSecond.setText("Lower the kettlebells towards the lower chest. Hold for a brief movement. As you raise the kettlebells back to starting position. generate the force upward with your chest and triceps muscles. Raise the kettlebells until your arms are fully extended. Refrain from any leg movements. ");
            gameScheduleName.setText("Kettlebell Bench Press(Incline)");

        }
        else if(exerciseName.equals("Kettlebell Floor Press"))
        {
            gameDes.setText("Lie down on the Floor. Grasp the kettlebells with overhand Grip. Rest your upper arms on the Floor while pointing kettlebells toward the ceiling.");
            gamesDesSecond.setText("Full extend arms towards the ceiling. Hold for one second. Keep your entire back on the bench at all times. Refrain from any leg movements. Return to starting position.");
            gameScheduleName.setText("Kettlebell Floor Press");
        }

    }
}
