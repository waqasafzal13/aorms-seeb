package com.example.muhammadzain.myapplication;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.waqas.pentagone.PageAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabDashboard;
    TabItem tabSummary;
    TabItem tabGraphs;
    TabItem tabReview;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;

        toolbar = findViewById(R.id.home_toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.home_tablayout);
        viewPager = findViewById(R.id.hme_viewpager);
        tabDashboard = findViewById(R.id.dashboard);
        tabSummary = findViewById(R.id.summary);


        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), context);
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this, R.color.colorPrimary));
                    }
                } else if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.colorPrimaryDark));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.colorPrimaryDark));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this, R.color.colorPrimaryDark));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
