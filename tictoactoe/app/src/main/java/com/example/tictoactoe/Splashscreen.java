package com.example.tictoactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        TextView txt;
        txt= findViewById(R.id.rose);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.alpha);
        txt.startAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent inext=new Intent(Splashscreen.this,Secondpage.class);
                startActivity(inext);
                finishAffinity();


            }
        },4000);

    }
}