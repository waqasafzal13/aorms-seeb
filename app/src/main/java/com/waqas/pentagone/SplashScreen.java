package com.waqas.pentagone;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    ImageView imglogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imglogo = findViewById(R.id.splash_logo);
        Picasso.get().load(R.drawable.kitchen_logo).into(imglogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startMain = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(startMain);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
