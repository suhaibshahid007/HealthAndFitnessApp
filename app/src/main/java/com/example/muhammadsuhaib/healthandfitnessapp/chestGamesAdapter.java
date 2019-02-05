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
 * Created by Muhammad Suhaib on 5/24/2018.
 */

public class chestGamesAdapter extends RecyclerView.Adapter<chestGamesAdapter.ViewHolder> {

    public ArrayList<chestGames> gamesList ;
    public Context context;
    public chestGamesAdapter(Context context , ArrayList<chestGames> gamesList) {

        this.context = context;
        this.gamesList = gamesList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =  LayoutInflater.from(context).inflate(R.layout.chestgamelistview ,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final  int position) {

        holder.textView.setText(gamesList.get(position).getGameName());
        holder.imageView.setImageResource(R.drawable.b);
        int imageID = gamesList.get(position).getImageId();
        holder.gameImage.setImageResource(imageID);

        // now check the game name name put the image according to them ..
        /*
        if(position == 0)
        {
            holder.gameImage.setImageResource(R.drawable.bodyweight);
        }
        else if(position ==1)
        {
            holder.gameImage.setImageResource(R.drawable.barbellbenchpress);
        }
        else if(position ==2)
        {
            holder.gameImage.setImageResource(R.drawable.cabley);
        }
        else if(position ==3)
        {
            holder.gameImage.setImageResource(R.drawable.cablefly);
        }
        else if(position ==4)
        {
            holder.gameImage.setImageResource(R.drawable.dumbbelbenchpress);
        }
        else if(position ==5)
        {
            holder.gameImage.setImageResource(R.drawable.dumbellfloorpress);
        }
        else if(position ==6)
        {
            holder.gameImage.setImageResource(R.drawable.kettlebenchpress);
        }
        else if(position ==7)
        {
            holder.gameImage.setImageResource(R.drawable.closegripbench);
        }
        else if(position ==8)
        {
           holder.gameImage.setImageResource(R.drawable.kettlebenchpress);
        }
        else if(position ==9)
        {
            holder.gameImage.setImageResource(R.drawable.kettlebellfloorpress);
        }
       */

        // here the listener ...

        holder.clickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , chestGameDetails.class);
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

    public class ViewHolder  extends RecyclerView.ViewHolder {

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
