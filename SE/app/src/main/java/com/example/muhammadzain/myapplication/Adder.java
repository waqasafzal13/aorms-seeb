package com.example.muhammadzain.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adder extends AppCompatActivity {
    Button Btn1, Btn2, Btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adder);
        Btn1=findViewById(R.id.u);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adder.this, AddUser.class);
                startActivity(i);
            }
        });


        Btn3=findViewById(R.id.m);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adder.this, Pakistani.class);
                startActivity(i);
            }
        });
    }
    }
