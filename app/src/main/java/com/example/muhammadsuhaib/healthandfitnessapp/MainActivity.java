package com.example.muhammadsuhaib.healthandfitnessapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.muhammadsuhaib.healthandfitnessapp.Fragments.Health;

import com.example.muhammadsuhaib.healthandfitnessapp.Fragments.Health;
import com.example.muhammadsuhaib.healthandfitnessapp.Fragments.More;
import com.example.muhammadsuhaib.healthandfitnessapp.Fragments.MuscleFitness;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public TextView fragmentTitle;
    public ListView listView;
    public ArrayList<NavViewItem> navViewItems;
    public DrawerLayout drawerLayout;
    public SharedPreferences sharedPreferences;
    //public SharedPreferences sharedPreferencesSecond;
    public static  int currentFragment =1;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create the object of the array list ...
        navViewItems = new ArrayList<NavViewItem>();
       android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
         fragmentTitle = toolbar.findViewById(R.id.text_health);

         sharedPreferences = getSharedPreferences("Data",MODE_PRIVATE);
         currentFragment = sharedPreferences.getInt("fragment",1);

        // sharedPreferencesSecond = getSharedPreferences("data",MODE_PRIVATE);


         initializeNavViewItems();


         drawerLayout = findViewById(R.id.drawer_layout);
       ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawerLayout ,toolbar ,
               R.string.navigation_drawer_open,R.string.navigation_drawer_close);

       drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        // initialze the navigation view ...
        final NavigationView navigationView = findViewById(R.id.nav_menu);
        listView = findViewById(R.id.list_view_container);
        NavMenuAdapter menuAdapter = new NavMenuAdapter(this , navViewItems);
        listView.setAdapter(menuAdapter);

        loadFragment();

        auth = FirebaseAuth.getInstance();

        // here the code that implements the listener on the item in the list view....
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(navViewItems.get(position).getItemName().equals("Meal Plan"))
                {
                    currentFragment =1;
                    sharedPreferences.edit().putInt("fragment",currentFragment);
                    loadFragment();
                    fragmentTitle.setText("Meal Plan");
                }
                else if(navViewItems.get(position).getItemName().equals("Muscle Fitness"))
                {
                    currentFragment =2;
                    sharedPreferences.edit().putInt("fragment",currentFragment);
                    loadFragment();
                    fragmentTitle.setText("Muscle Fitness");
                }
                else if(navViewItems.get(position).getItemName().equals("Yoga Fitness"))
                {
                    currentFragment = 3;
                    sharedPreferences.edit().putInt("fragment" , currentFragment);
                    loadFragment();
                    fragmentTitle.setText("Yoga Exercises");
                }
                else if(navViewItems.get(position).getItemName().equals("BMI Calculator"))
                {
                    currentFragment = 6;
                    sharedPreferences.edit().putInt("fragment" , currentFragment);
                    loadFragment();
                }
                else if (navViewItems.get(position).getItemName().equals("Log Out"))
                {
                    currentFragment = 7;
                    sharedPreferences.edit().putInt("fragment" , currentFragment);
                    loadFragment();
                }
                else if (navViewItems.get(position).getItemName().equals("More"))
                {
                    currentFragment = 8 ;
                    sharedPreferences.edit().putInt("fragment" , currentFragment);
                    loadFragment();
                }

                // to close the drawer layout
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    // here the function that initialixe the navigation menu items...

    public void initializeNavViewItems()
    {
        navViewItems.clear();
        navViewItems.add(new NavViewItem("", "Meal Plan"));
        navViewItems.add(new NavViewItem("", "Muscle Fitness"));
        navViewItems.add(new NavViewItem("", "Yoga Fitness"));
        navViewItems.add(new NavViewItem("", "More"));
        navViewItems.add(new NavViewItem("", "BMI Calculator"));
        navViewItems.add(new NavViewItem("", "Log Out"));
    }

    // here the function that loads the fragmnet ...

    public void loadFragment()
    {
        if(currentFragment ==1)
        {
          getSupportFragmentManager().beginTransaction().replace(R.id.my_container, new Health()).commit();
            fragmentTitle.setText("Meal Plan");
        }
        if(currentFragment ==2)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_container , new MuscleFitness()).commit();
            fragmentTitle.setText("Muscle Fitness");
        }
        if(currentFragment ==3)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_container , new YogaFitness()).commit();
            fragmentTitle.setText("Yoga Exercises");
        }
        if(currentFragment == 6)
        {
            showBMICalculator();
        }
        if(currentFragment ==7)
        {
           // logOutUser();
        }
        if(currentFragment ==8)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_container , new More()).commit();
            fragmentTitle.setText("More");
        }
    }

    // here the code for the calculator...

    public void showBMICalculator()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bmi , null);

        alertDialog.setView(v);

        //  here declare the edit text and get the data from them ...

        final  EditText age , wei , hei ;
        final TextView resultBmi;
        Button calBtn ;
        calBtn = (Button)v.findViewById(R.id.calculateBMI);

        age = (EditText)v.findViewById(R.id.age);
        wei = (EditText)v.findViewById(R.id.weight);
        hei = (EditText)v.findViewById(R.id.height);

        resultBmi = (TextView)v.findViewById(R.id.result_set);

        // declare the variables double...

        // here the click listener on the calculate button ...

        calBtn.setOnClickListener(new View.OnClickListener() {

            String ageTemp , weight , height ;
            @Override
            public void onClick(View v) {

                ageTemp = age.getText().toString();
                weight = wei.getText().toString();
                height = hei.getText().toString();

                if(TextUtils.isEmpty(ageTemp))
                {
                    age.setError("Required");
                    return;
                }


                 if(TextUtils.isEmpty(height))
                 {
                     hei.setError("Required");
                     return;
                 }

                if(TextUtils.isEmpty(weight))
                {
                    wei.setError("Required");
                    return ;
                }
                 // here the formula to compute the body mass ...
                double bmi_wei , bmi_hei;

                bmi_wei = Double.valueOf(weight);
                bmi_hei = Double.valueOf(height)/100;

                double bmi_final = bmi_wei/(bmi_hei * bmi_hei);

                resultBmi.setText("Your BMI is " + String.valueOf(bmi_final).substring(0,4) + " You fall in the category of ");

                if(bmi_final >25)
                {
                    resultBmi.append("OverWeight.");
                }
                else if(bmi_final < 25 && bmi_final >18.5)
                {
                    resultBmi.append("Healthy.");
                }
                else
                {
                    resultBmi.append("Under-weight .");
                }


            }
        });

       alertDialog.show();

    }

    // here the code that log-out the user from the app.....

    public void logOutUser()
    {
        auth.signOut();
        if(auth.getCurrentUser() ==null)
        {
            startActivity(new Intent(MainActivity.this , LoginUser.class));
           // sharedPreferencesSecond.edit().putBoolean("flag",false);
            finish();
        }
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
         else
        {
           logOutUser();
            //super.onBackPressed();
        }

    }





}
