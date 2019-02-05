package com.example.muhammadsuhaib.healthandfitnessapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class armsGamesList extends AppCompatActivity {

        public RecyclerView recyclerView;
        public ArrayList<armsGames> gamesList;
        public Toolbar toolbar ;
        public MaterialSearchView searchView;
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_arms_games_list);

            recyclerView = findViewById(R.id.recylerView);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));


            gamesList = new ArrayList<>();

            android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolBar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Arms Games");
            toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
            searchView = (MaterialSearchView)findViewById(R.id.search_view);

            addArmsGamesData();
            armsGamesAdapter adapter = new armsGamesAdapter(getApplicationContext(), gamesList);
            recyclerView.setAdapter(adapter);

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
                        ArrayList<armsGames> armsGamesList = new ArrayList<>();

                        for(armsGames games : gamesList)
                        {
                            if(games.getGameName().contains(newText))
                            {
                                armsGamesList.add(games);
                            }
                        }

                        armsGamesAdapter adapter = new armsGamesAdapter(getApplicationContext(),armsGamesList);
                        recyclerView.setAdapter(adapter);

                    }
                    else
                    {
                        armsGamesAdapter adapter = new armsGamesAdapter(getApplicationContext(),gamesList);
                        recyclerView.setAdapter(adapter);
                    }
                    return true;
                }
            });
        }
    private void addArmsGamesData() {
        gamesList.add(new armsGames(R.drawable.cablebicepcurl,"Cable Biceps Curl" , "This game is for Biceps"));
        gamesList.add(new armsGames(R.drawable.cablepushdown,"Cable Pushdown (OverHand Grip)","This game is for triceps"));
        gamesList.add(new armsGames(R.drawable.cabletricepextension,"Cable Tricep Extension" ,"This game is for triceps"));
        gamesList.add(new armsGames(R.drawable.dumbellbicepcurl,"Dumbbell Bicep Curl","This game is for biceps"));
        gamesList.add(new armsGames(R.drawable.bicepsdips,"Bodyweigt Bench Dips","This game is for triceps"));
        gamesList.add(new armsGames(R.drawable.flatbicepcurl,"Fat Grip Bicep Curl","This game is for biceps"));
        gamesList.add(new armsGames(R.drawable.dumbeltricepextension,"Dumbbell Triceps Extension","This game is for triceps"));
        gamesList.add(new armsGames(R.drawable.ezcurlbiceps,"EZ Curl Bar Biceps","This game is for biceps"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu , menu);

        MenuItem item = menu.findItem(R.id.action_Search_view);
        searchView.setMenuItem(item);
        return  true;
    }
}

