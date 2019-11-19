package com.example.muhammadzain.myapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MUSA_ViewPagerAdapter extends FragmentPagerAdapter {

    public MUSA_ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new MUSA_FragmentA();
        }
        else if (position == 1)
        {
            fragment = new MUSA_FragmentB();
        }
        else if (position == 2)
        {
            fragment = new MUSA_FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Fast Food";
        }
        else if (position == 1)
        {
            title = "Continental";
        }
        else if (position == 2)
        {
            title = "Chinese";
        }
        return title;
    }
}
