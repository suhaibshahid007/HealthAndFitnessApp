package com.example.muhammadsuhaib.healthandfitnessapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.muhammadsuhaib.healthandfitnessapp.chestGames;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class chestGamesList extends AppCompatActivity {
   public TextView toolBarTitle;
    public RecyclerView recyclerView;
    MaterialSearchView searchView;
    public ArrayList<chestGames>  gamesList ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_games_list);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chest Games");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));



        recyclerView = findViewById(R.id.recylerView);

        gamesList = new ArrayList<>();

        addChestGamesData();
        chestGamesAdapter adapter = new chestGamesAdapter(getApplicationContext(),gamesList);
        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView = (MaterialSearchView)findViewById(R.id.search_view);



        // here i set the list item click listener ....

      searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String query) {
              return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {

              if(newText !=null && !newText.isEmpty())
              {
                ArrayList<chestGames> chestGamesList = new ArrayList<>();

                for(chestGames games : gamesList)
                {
                     if(games.getGameName().contains(newText))
                     {
                         chestGamesList.add(games);
                     }
                }

                  chestGamesAdapter adapter = new chestGamesAdapter(getApplicationContext(),chestGamesList);
                  recyclerView.setAdapter(adapter);

              }
              else
              {
                  chestGamesAdapter adapter = new chestGamesAdapter(getApplicationContext(),gamesList);
                  recyclerView.setAdapter(adapter);
              }
              return true;
          }
      });
    }

    public void addChestGamesData()
    {
        gamesList.add(new chestGames(R.drawable.bodyweight, "Bodyweight Pushup" , "This game is for chest"));
        gamesList.add(new chestGames(R.drawable.barbellbenchpress,"Barbell Bench Press" , "This game is for lower chest"));
        gamesList.add(new chestGames(R.drawable.cabley,"Cable Crossover (High)","This game is for lower chest"));
        gamesList.add(new chestGames(R.drawable.cablefly,"Cable Fly(One Sided)" ,"This game is for chest"));
        gamesList.add(new chestGames(R.drawable.dumbbelbenchpress,"Dumbbell Bench Press","This game is for chest"));
        gamesList.add(new chestGames(R.drawable.dumbellfloorpress,"Dumbbell Floor Press","This game is for chest"));
        gamesList.add(new chestGames(R.drawable.kettlebenchpress,"Dumbbell Fly(Flat Bench)","This game is for chest"));
        gamesList.add(new chestGames(R.drawable.closegripbench,"Rod Bench Press(Close Grip)","This game is for chest"));
        gamesList.add(new chestGames(R.drawable.kettlebenchpress,"Kettlebell Bench Press (Incline)","This game is for chest"));
        gamesList.add(new chestGames(R.drawable.kettlebellfloorpress,"Kettlebell Floor Press","This game is for chest"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu , menu);

        MenuItem item = menu.findItem(R.id.action_Search_view);
        searchView.setMenuItem(item);
        return  true;
    }
}
