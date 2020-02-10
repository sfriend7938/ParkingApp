package com.example.parkingapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    //initialize variable for splash time constant
    private static int SPLASH_TIME_OUT = 10000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView imageView = findViewById(R.id.ivWelcomeLogo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imageView.startAnimation(animation);

        Thread timer = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(10000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    super.run();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }
}
