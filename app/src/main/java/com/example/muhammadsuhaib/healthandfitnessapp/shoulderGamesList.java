package com.example.muhammadsuhaib.healthandfitnessapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class shoulderGamesList extends AppCompatActivity {

     public RecyclerView recyclerView;
     public ArrayList<shoulderGames> gamesList ;
     public Toolbar toolbar;
     public MaterialSearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_games_list);

        gamesList = new ArrayList<shoulderGames>();


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Shoulder Games");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        recyclerView = findViewById(R.id.recylerView);
        searchView = (MaterialSearchView)findViewById(R.id.search_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addShoulderGames();

       shoulderGameAdapter adapter = new shoulderGameAdapter(getApplicationContext() , gamesList);
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
                    ArrayList<shoulderGames> shoulderGamesList = new ArrayList<>();

                    for(shoulderGames games : gamesList)
                    {
                        if(games.getGameName().contains(newText))
                        {
                            shoulderGamesList.add(games);
                        }
                    }

                    shoulderGameAdapter adapter = new shoulderGameAdapter(getApplicationContext(),shoulderGamesList);
                    recyclerView.setAdapter(adapter);

                }
                else
                {
                    shoulderGameAdapter adapter = new shoulderGameAdapter(getApplicationContext(),gamesList);
                    recyclerView.setAdapter(adapter);
                }
                return true;
            }
        });
    }

    public void addShoulderGames()
    {
        gamesList.add(new shoulderGames(R.drawable.barbellpushpress,"Barbell Push Press"));
        gamesList.add(new shoulderGames(R.drawable.bentoverdumbell,"Bent Over Dumbbell (Lateral Raise)"));
        gamesList.add(new shoulderGames(R.drawable.barbellpushpress,"Barbell Shoulder Press (Military)"));
        gamesList.add(new shoulderGames(R.drawable.dumbbellcircles,"Dumbbell Arm Circles"));
        gamesList.add(new shoulderGames(R.drawable.dumbbelpushpress,"Dumbbell Push Press"));
        gamesList.add(new shoulderGames(R.drawable.dumbbellupright,"Dumbbell Upright Row"));
        gamesList.add(new shoulderGames(R.drawable.dumbbelllateral,"Dumbbell Raise (Lateral)"));
        gamesList.add(new shoulderGames(R.drawable.hammerjam,"Hammer Jammer"));
        gamesList.add(new shoulderGames(R.drawable.seatedbarbellpress,"Seated Barbell Shoulder Press"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu , menu);

        MenuItem item = menu.findItem(R.id.action_Search_view);
        searchView.setMenuItem(item);
        return  true;
    }
}
