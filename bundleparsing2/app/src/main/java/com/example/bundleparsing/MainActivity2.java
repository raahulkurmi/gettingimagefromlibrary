package com.example.bundleparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt=findViewById(R.id.txt);
        Intent fromact=getIntent();
        String title=fromact.getStringExtra("title");
        String name=fromact.getStringExtra("name");
        int clas=fromact.getIntExtra("class",0);
        txt.setText(name+clas);


        getSupportActionBar().setTitle(title);




    }
}