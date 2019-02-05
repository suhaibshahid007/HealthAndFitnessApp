package com.example.muhammadsuhaib.healthandfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class shoulderGameDetails extends AppCompatActivity {

    public ImageView imageView;
    public TextView gameName;
    public TextView gameDesc;
    public TextView gameSecondDesc;
    public TextView gameSchedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_game_details);

        gameName = (TextView)findViewById(R.id.exerciseName);
        imageView = (ImageView)findViewById(R.id.gifImage);
        gameDesc = (TextView)findViewById(R.id.gameInstructionsOne);
        gameSecondDesc = (TextView)findViewById(R.id.gameInstructionsTwo);
         gameSchedule = (TextView)findViewById(R.id.gameScheduleName);

         // here get the data from the bundle ...

        Bundle bundle = getIntent().getExtras();
        String exerciseName = bundle.getString("exerciseName");
        int imageId = bundle.getInt("imageId");

        gameName.setText(exerciseName);
        imageView.setImageResource(imageId);

      //  int position = getIntent().getExtras().getInt("data");
        if(exerciseName.equals("Barbell Push Press"))
        {
            gameDesc.setText("Stand straight with feet shoulder with apart. Hold barbell with shoulder width overhead in front of your head.");
            gameSecondDesc.setText("Bend Knees slightly. Push up until your arms and legs are fully extended overhead. Return to starting position.");
             gameSchedule.setText("Barbell Push Press");
        }
        else if(exerciseName.equals("Bent Over Dumbbell (Lateral Raise)"))
        {
            gameDesc.setText(" With a dumbbell in each hand and your chest up, back flat, knees slightly bent and eyes fixed on a point on the floor just ahead of you, bend over at the hips until your torso is nearly parallel to the floor. Let the dumbbells hang directly beneath you with your elbows fixed in a slightly bent position.");
            gameSecondDesc.setText("From there, powerfully raise the dumbbells up and out to your sides in an arc until your upper arms are about parallel with the floor. Pause at the top for a squeeze, then lower the dumbbells back along the same path, stop just your arms go fully perpendicular to the floor, and start the next rep");
            gameSchedule.setText("Bent Over Dumbbell (Lateral Raise)");
        }
        else if(exerciseName.equals("Barbell Shoulder Press (Military)"))
        {
            imageView.setImageResource(R.drawable.barbellpushpress);
            gameName.setText("Barbell Shoulder Press (Military)");
            gameDesc.setText("While standing with back straight, hold barbell with overhand Grip. Distance between your hands should be wider than shoulder width apart. Position barbell slightly above your chest");
            gameSecondDesc.setText("Lift barbell overhead untill your arms are fully extended. Hold for one second. Return to starting position.");
            gameSchedule.setText("Barbell Shoulder Press Military");
        }
        else if(exerciseName.equals("Dumbbell Arm Circles"))
        {
            gameDesc.setText("While standing with feet shoulder width apart, hold dumbbells with neutral grip. Extend your arms straight out from your sides.Rotate dumbells in circle with your hands.");
            gameSecondDesc.setText("Rotate dumbells in circle with your hands");
            gameSchedule.setText("Dumbbell Arm Circles");
        }
        else if(exerciseName.equals("Dumbbell Push Press"))
        {
            imageView.setImageResource(R.drawable.dumbbelpushpress);
            gameName.setText("Dumbbell Push Press");
            gameDesc.setText("Stand straight with feet shoulder width apart. Hold dumbbells with neutral Grip. Dumbbells are positioned on your shoulders");
            gameSecondDesc.setText("Bend Knees slightly. Push up until your arms are fully extended overhead. Return to starting position.");
            gameSchedule.setText("Dumbbell Push Press");
        }
        else if(exerciseName.equals("Dumbbell Upright Row"))
        {
            imageView.setImageResource(R.drawable.dumbbellupright);
            gameName.setText("Dumbbell Upright Row");
            gameDesc.setText("Stand straight with your feet shoulder width apart. Hold dumbbells with overhand Grip. Dumbbells are positioned infront of your thighs.");
            gameSecondDesc.setText("Raise the dumbbells until they reach your neck . Wrists slightly flare out. Hold for one second. Return to starting position.");
            gameSchedule.setText("Dumbbell Upright Row");
        }
        else if(exerciseName.equals("Dumbbell Raise (Lateral)"))
        {
            imageView.setImageResource(R.drawable.dumbbelllateral);
            gameName.setText("Dumbbell Raise (Lateral)");
            gameDesc.setText("While standing straight feet shoulder width apart, hold dumbbells at your sides with neutral Grip. Keepyour arms straight.");
            gameSecondDesc.setText("Raise your arms to your sides until they are parallel with the ground. Hold for one second. Return to starting position");
            gameSchedule.setText("Dumbbell Raise (Lateral)");
        }
        else if(exerciseName.equals("Hammer Jammer"))
        {
            imageView.setImageResource(R.drawable.hammerjam);
            gameName.setText("Hammer Jammer");
            gameDesc.setText("Position a bar into a landmine or securely anchor it in a corner. Load the bar to an appropriate weight. Raise the bar from the floor, taking it to your shoulders with one or both hands. Adopt a wide stance. This will be your starting position.");
            gameSecondDesc.setText("Perform the movement by extending the elbow, pressing the weight up. Move explosively, extending the hips and knees fully to produce maximal force.Return to the starting position.");
            gameSchedule.setText("Hammer Jammer");
        }
        else if(exerciseName.equals("Seated Barbell Shoulder Press"))
        {
            imageView.setImageResource(R.drawable.seatedbarbellpress);
            gameName.setText("Seated Barbell Shoulder Press");
            gameDesc.setText("Grasp the bar outside of shoulder width with a palms-forward grip, elbows pointing down and outward. Carefully unrack the bar and hold it at shoulder level. In a smooth, strong motion, press the bar straight up to just short of elbow lockout. ");
            gameSecondDesc.setText("Squeeze, then lower the bar under control to a point right at your upper chest and clavicle area. Be sure to pull your face back as the bar passes to avoid giving yourself an impromptu nose job.");
            gameSchedule.setText("Seated Barbell Shoulder Press");
        }
    }
}

