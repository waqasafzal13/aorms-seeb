package com.example.muhammadzain.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class MUSA_MainActivity extends AppCompatActivity implements MUSA_FragmentA.selectedlist {

    TabLayout tabLayout;
    ViewPager viewPager;
    MUSA_ViewPagerAdapter viewPagerAdapter;
    ArrayList<String>dishesname;
    ArrayList<String>dishprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musa_musa_main);
        dishesname = new ArrayList<>();
        dishprice = new ArrayList<>();
        ImageButton fab = (ImageButton) findViewById(R.id.fab);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new MUSA_ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Intent confirmorder = new Intent(getApplicationContext(), MUSA_confirmorder.class);
                confirmorder.putExtra("dishname",dishesname);
                confirmorder.putExtra("dishprice",dishprice);
                startActivity(confirmorder);
            }
        });

        }

        //check if its already in list thn remove otherwise add dish to list
    @Override
    public int addtolist(String name, String price)
    {
        int flag =0;
           if(dishesname.contains(name))
           {
               dishesname.remove(name);
               dishprice.remove(price);
               flag = 1;
           }
           else
           {
               dishesname.add(name);
               dishprice.add(price);
               flag =0;
           }
        return flag;
    }

    //return 0 is existed 1 if not
    @Override
    public int checktolist(String name, String price)
    {
        int flag =-1;
        if(dishesname.contains(name))
        {
            flag = 0;
        }
        else
        {
            flag =1;
        }
        return flag;
    }
}
