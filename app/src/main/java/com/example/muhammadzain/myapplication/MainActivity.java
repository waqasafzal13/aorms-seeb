package com.example.muhammadzain.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.muhammadzain.myapplication.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    Button Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        Btn=findViewById(R.id.button);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Adder.class);
                startActivity(i);
            }
        });
    }
}
