package com.example.layoutdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Animation anim= AnimationUtils.loadAnimation(this,R.anim.alpha);
        TextView textView;
        textView=findViewById(R.id.textView);
        textView.startAnimation(anim);
        //creating the new handler class for the handling of the splash screen to control the splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setting intent for th splash activity to the main activity or home page
                Intent inext=new Intent(MainActivity3.this,MainActivity.class);
                //intialzing activity show it can start
                startActivity(inext);
                /*destroying th splash activity once its displayed from
                the activity as splash screen is displayed only one*/
             finish();


            }
            /*delaying process using mili second as all
            the calculation is counted in mili second in program
             */
        },4000);

    }
}