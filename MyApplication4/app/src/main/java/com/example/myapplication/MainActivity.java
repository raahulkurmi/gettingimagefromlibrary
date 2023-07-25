package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView hell;
        Button btntranslate,btnrotate,btnscale,btnalpha;

        hell=findViewById(R.id.Hell);
        btnrotate=findViewById(R.id.btnrotate);
        btnalpha=findViewById(R.id.btnalpha);
        btnscale=findViewById(R.id.btnscale);
        btntranslate=findViewById(R.id.btntranslate);
        btntranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                hell.startAnimation(anim);
            }
        });
        btnalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Animation anim2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
               hell.startAnimation(anim2);
            }
        });

        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim4=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
                hell.startAnimation(anim4);
            }
        });
        btnscale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim3=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                hell.startAnimation(anim3);
            }
        });


    }
}