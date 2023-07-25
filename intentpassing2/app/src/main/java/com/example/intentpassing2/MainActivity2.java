package com.example.intentpassing2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent fromact=getIntent();




       String name1=fromact.getStringExtra("Name1");

       int rollno2=fromact.getIntExtra("Rollno1",0);



        String title=fromact.getStringExtra("title");


        String name=fromact.getStringExtra("name");


       int rollno= fromact.getIntExtra("Rollno",0);

        TextView text;

        text=findViewById(R.id.text);

      text.setText("Name"+name+"Roll no"+rollno);



        text.setText("Name"+name1+"rollno"+rollno2);


      getSupportActionBar().setTitle(title);




    }
}