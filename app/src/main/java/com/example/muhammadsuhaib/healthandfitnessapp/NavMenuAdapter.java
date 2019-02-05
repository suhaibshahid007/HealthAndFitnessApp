package com.example.muhammadsuhaib.healthandfitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Suhaib on 5/5/2018.
 */

public class NavMenuAdapter extends BaseAdapter {

    public Context context ;
    public ArrayList<NavViewItem> navViewItems;
   public  TextView category_name;
   public ImageView category_image;
    // here the constructor is ...

    public NavMenuAdapter(Context context , ArrayList<NavViewItem> navViewItems)
    {
        this.context = context;
        this.navViewItems = navViewItems;
    }
    @Override
    public int getCount() {
        return navViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       convertView = LayoutInflater.from(context).inflate(R.layout.nav_menu_item_layout,null);
        category_name = (TextView)convertView.findViewById(R.id.text_category);
        category_image = (ImageView)convertView.findViewById(R.id.nav_view_icon);
        category_name.setText(navViewItems.get(position).getItemName());
        // now set the image by checking the category ...

        if(position ==0)
        {
            category_image.setImageResource(R.drawable.health);
        }
        else if(position ==1)
        {
            category_image.setImageResource(R.drawable.fitness);
        }
        else if(position ==2)
        {
            category_image.setImageResource(R.drawable.yoga);
        }
        else if(position ==3)
        {
            category_image.setImageResource(R.drawable.consult);
        }
        else if(position ==4)
        {
            category_image.setImageResource(R.drawable.more);
        }
        else if(position ==5)
        {
            category_image.setImageResource(R.drawable.calculator);
        }
        else if(position ==6)
        {
            category_image.setImageResource(R.drawable.logout);
        }
        else if(position ==7)
        {
            category_image.setImageResource(R.drawable.human);
        }

        return convertView;
    }
}
