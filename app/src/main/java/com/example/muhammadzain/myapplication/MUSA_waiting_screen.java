package com.example.muhammadzain.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MUSA_waiting_screen extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private  boolean timerRunning;
    private long timeLeft = 600000; //in milliseconds

    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musa_waiting_screen);

        countdownText = findViewById(R.id.countdown_text);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        initView();
        timer();
    }

    private void initView(){
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelOrderPressed();
            }
        });
    }

    private void cancelOrderPressed(){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Are you Sure You Want to Cancel")
                .setPositiveButton("Yes",null)
                .setNegativeButton("No",null)
                .show();

        Button positiveButton =  dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackToMenu();
            }
        });

        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void BackToMenu(){
        Intent intent = new Intent(this, MUSA_MainActivity.class);
        startActivity(intent);
    }

    private void timer(){
        if(timerRunning){
            stopTimer();
        }
        else{
            startTimer();
        }
    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning = true;
    }

    private void stopTimer(){
        countDownTimer.cancel();
        timerRunning = false;
    }

    private void updateTimer(){

        int seconds = (int) (timeLeft / 1000) % 60 ;
        int minutes = (int) ((timeLeft / (1000*60)) % 60);

        String timeString;

        timeString = "" + minutes;
        timeString += ":";

        timeString += seconds;

        countdownText.setText(timeString);
    }
}
