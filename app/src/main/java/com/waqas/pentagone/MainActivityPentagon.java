package com.waqas.pentagone;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.muhammadzain.myapplication.R;
import com.example.muhammadzain.myapplication.ReportPage;

public class MainActivityPentagon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=new Intent(getApplicationContext(), ReportPage.class);
        startActivity(i);
    }
}
