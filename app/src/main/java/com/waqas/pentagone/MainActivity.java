package com.example.android.seproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentA.selectedlist
{


    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ArrayList<String>dishesname;
    ArrayList<String>dishprice;


    @Override
    public void addtolist(String name, String price)
    {
     dishesname.add(name);
     dishprice.add(price);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       dishesname = new ArrayList<>();
       dishprice = new ArrayList<>();
        ImageButton fab = (ImageButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent confirmorder = new Intent(getApplicationContext(), com.example.android.seproject.confirmorder.class);
                confirmorder.putExtra("dishname",dishesname);
                confirmorder.putExtra("dishprice",dishprice);
                startActivity(confirmorder);
            }
        });
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
