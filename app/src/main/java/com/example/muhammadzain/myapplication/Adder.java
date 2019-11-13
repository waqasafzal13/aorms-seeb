package com.example.muhammadzain.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Adder extends AppCompatActivity {
    Button Btn1, Btn2, Btn3,owner,customer,hall_manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adder);
        Btn1=findViewById(R.id.m);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adder.this, Login.class);
                startActivity(i);
            }
        });

        Btn2=findViewById(R.id.i);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adder.this, Login.class);
                startActivity(i);
            }
        });

        Btn3=findViewById(R.id.u);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adder.this, Login.class);
                startActivity(i);
            }
        });

        owner=findViewById(R.id.owner);
        owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adder.this, ReportPage.class);
                startActivity(i);
            }
        });

        customer=findViewById(R.id.customer);
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adder.this, MusaMainActivity.class);
                startActivity(i);
            }
        });

        hall_manager=findViewById(R.id.hall_manager);
        hall_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adder.this, Table_Availability.class);
                startActivity(i);
            }
        });
    }
    }
