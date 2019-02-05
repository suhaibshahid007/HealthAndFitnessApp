package com.example.muhammadsuhaib.healthandfitnessapp.Fragments;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TableLayout;

import com.example.muhammadsuhaib.healthandfitnessapp.R;

import java.util.ArrayList;

/**
 * Created by Muhammad Suhaib on 5/8/2018.
 */

public class Health extends Fragment {

     ViewPager viewPager;
     TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_health,container,false);
        viewPager = (ViewPager)v.findViewById(R.id.viewPagerNetwork);
         establishViewPager(viewPager);
        tabLayout = (TabLayout)v.findViewById(R.id.tabsGroup);
        tabLayout.setupWithViewPager(viewPager);
        return v ;
    }

    // here the function that set up the view pager ...

    public void establishViewPager(ViewPager viewPager)
    {
       ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
       adapter.addFragment(new WeightGain() , "Weight Gain");
       adapter.addFragment(new WeightLoss() , "Weight Loss");
       viewPager.setAdapter(adapter);
    }

    // here the inner class ....
    class ViewPagerAdapter extends FragmentPagerAdapter{
        public ArrayList<Fragment> fragmentsArrayList = new ArrayList<>();
        public ArrayList<String> fragmentsTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm ) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentsArrayList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentsTitle.get(position);
        }

        @Override
        public int getCount() {
            return fragmentsArrayList.size();
        }

        public void addFragment(Fragment fragment , String fragmentTilte)
        {
             fragmentsArrayList.add(fragment);
             fragmentsTitle.add(fragmentTilte);
        }
    }
}
