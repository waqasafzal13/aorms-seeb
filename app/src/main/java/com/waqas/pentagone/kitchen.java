package com.waqas.pentagone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.waqas.pentagone.ListActivity;
import com.waqas.pentagone.R;

import androidx.appcompat.app.AppCompatActivity;

public class kitchen extends AppCompatActivity {


    ImageView imglogo;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imglogo = findViewById(R.id.login_img);
        Picasso.get().load(R.drawable.kitchen_logo).into(imglogo);
        button = findViewById(R.id.login_btn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kitchen.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }
}


