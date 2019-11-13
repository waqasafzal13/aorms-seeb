package com.example.muhammadzain.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MusaMainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ArrayList<String>dishesname;
    ArrayList<String>dishprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musa_main);
        setContentView(R.layout.activity_main);
        dishesname = new ArrayList<>();
        dishprice = new ArrayList<>();
        ImageButton fab = (ImageButton) findViewById(R.id.fab);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Intent confirmorder = new Intent(getApplicationContext(), com.example.muhammadzain.myapplication.confirmorder.class);
                confirmorder.putExtra("dishname",dishesname);
                confirmorder.putExtra("dishprice",dishprice);
                startActivity(confirmorder);
            }
        });

        }

    public void addtolist(String name, String price)
    {
        dishesname.add(name);
        dishprice.add(price);
    }

}
