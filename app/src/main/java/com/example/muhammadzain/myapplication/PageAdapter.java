package com.example.muhammadzain.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.muhammadzain.myapplication.DashboardFragment;
import com.waqas.pentagone.SummaryFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private int noOfTabs;
    private Context context;

    public PageAdapter(FragmentManager fragmentManager, int i, Context context) {
        super(fragmentManager);
        noOfTabs = i;
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0: {
                return new DashboardFragment();
            }
            case 1: {
                return new SummaryFragment();
            }

            default:
                return new DashboardFragment();
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

}
