package com.waqas.pentagone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ListActivity extends AppCompatActivity {

    CardView manager, chef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        manager = findViewById(R.id.manager_id);
        chef = findViewById(R.id.chef_id);

        chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, ChefActivity.class);
                startActivity(intent);
            }
        });
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
