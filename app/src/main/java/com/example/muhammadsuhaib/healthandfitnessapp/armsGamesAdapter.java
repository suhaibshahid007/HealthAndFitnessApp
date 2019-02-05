package com.example.muhammadsuhaib.healthandfitnessapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Suhaib on 7/3/2018.
 */

public class armsGamesAdapter extends RecyclerView.Adapter<armsGamesAdapter.ViewHolder> {

    public Context context;
    public  ArrayList<armsGames> gamesList;
    public armsGamesAdapter(Context context , ArrayList<armsGames> gamesList)
    {
       this.context = context;
       this.gamesList = gamesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.armsgameslistview , null);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(armsGamesAdapter.ViewHolder holder,final  int position) {

        holder.textView.setText(gamesList.get(position).getGameName());
        holder.imageView.setImageResource(R.drawable.b);
        int imageID = gamesList.get(position).getImageId();
        holder.gameImage.setImageResource(imageID);

        // here the listener ...

        holder.clickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , armsGamesDetails.class);
                intent.putExtra("imageId" , gamesList.get(position).getImageId());
                intent.putExtra("exerciseName" , gamesList.get(position).getGameName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    // here the inner class....
    public class ViewHolder  extends  RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;
        public ImageView gameImage;
        public RelativeLayout clickLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.gameName);
            imageView = (ImageView)itemView.findViewById(R.id.goImage);
            gameImage = (ImageView)itemView.findViewById(R.id.gameImage);
            clickLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }

    }
}
