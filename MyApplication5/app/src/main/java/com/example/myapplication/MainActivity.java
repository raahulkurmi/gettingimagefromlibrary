package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* card=findViewById(R.id.card);
        card.setRadius(50.0f);
        card.setCardElevation(11.0f);
        card.setUseCompatPadding(true);*/


    }
}