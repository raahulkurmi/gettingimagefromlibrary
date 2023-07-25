package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    Intent inext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
                Boolean check= pref.getBoolean("flag",false);
                if(check)//for true condition
                {
                    inext =new Intent(getApplicationContext(),homeactivity.class);
                }

                else  {   //for false condition
                    inext=new Intent(getApplicationContext(),loginactivity.class);
                }
                startActivity(inext);

            }




        },4000);
    }
    }