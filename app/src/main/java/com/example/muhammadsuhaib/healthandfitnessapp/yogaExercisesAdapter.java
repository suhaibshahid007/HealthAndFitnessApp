package com.example.muhammadsuhaib.healthandfitnessapp;


import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.muhammadsuhaib.healthandfitnessapp.yogaDetailActivity;

import java.util.ArrayList;

/**
 * Created by Muhammad Suhaib on 6/2/2018.
 */

public class yogaExercisesAdapter extends RecyclerView.Adapter<yogaExercisesAdapter.ViewHolder> {

    Context context ;
    ArrayList<YogaExercises> yogaList;

    // here the constructor...
    public yogaExercisesAdapter(Context context , ArrayList<YogaExercises> yogaList) {

        this.context = context ;
        this.yogaList = yogaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.yogacustomlayout ,parent , false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // here the code that binds the data in the card view fields...

        holder.poseImage.setImageResource(yogaList.get(position).getImageId());
        holder.poseName.setText(yogaList.get(position).getExerciseName());
        holder.clickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(context , yogaDetailActivity.class);
               intent.putExtra("poseImageID" , yogaList.get(position).getImageId());
               intent.putExtra("poseName" , yogaList.get(position).getExerciseName());
               context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return yogaList.size();
    }

  public class ViewHolder extends RecyclerView.ViewHolder{

        // here create the image view and text view for the fields...
      public TextView poseName;
      public ImageView poseImage;
      public RelativeLayout clickLayout;
      public ViewHolder(View itemView) {
          super(itemView);

          poseName = (TextView)itemView.findViewById(R.id.poseName);
          poseImage = (ImageView) itemView.findViewById(R.id.poseImage);
          clickLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
      }

  }
}
