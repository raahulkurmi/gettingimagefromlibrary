package com.example.bundleparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt=findViewById(R.id.txt);
        Intent fromact=getIntent();
        Intent fromact2=getIntent();
        String title1=fromact.getStringExtra("title1");
        String title=fromact.getStringExtra("name");
        int clas=fromact.getIntExtra("class",0);
        String title2=fromact2.getStringExtra("name1");
        int clas1=fromact2.getIntExtra("class1",0);


       txt.setText(title+clas);
        txt.setText(title2+clas1);

    getSupportActionBar().setTitle(title1);




    }
}