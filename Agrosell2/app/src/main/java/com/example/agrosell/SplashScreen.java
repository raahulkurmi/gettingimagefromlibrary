package com.example.agrosell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView splash=findViewById(R.id.Splash);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.alpha);
        splash.startAnimation(anim);

        new Handler().postDelayed(() -> {
            Intent inext=new Intent(SplashScreen.this,Secondpage.class);

            startActivity(inext);

        },2000);




    }

}