package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter;
    TextView value,title;
    Button count,reset;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value=findViewById(R.id.value);
        count=findViewById(R.id.count);
        reset=findViewById(R.id.reset);
        counter=0;

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                value.setText(""+counter);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter=0;
                value.setText(""+counter);
            }
        });


//        init();


    }
//    private void init() {
//        value = findViewById(R.id.value);
//        count = findViewById(R.id.count);
//        reset = findViewById(R.id.reset);
//    }
//    public void click(View v){
//        counter++;
//        value.setText(""+counter);
//    }




}