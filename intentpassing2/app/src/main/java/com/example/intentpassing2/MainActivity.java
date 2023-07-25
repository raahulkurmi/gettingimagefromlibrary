package com.example.intentpassing2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        button = findViewById(R.id.button);
        Button but;
        but=findViewById(R.id.but);
        Intent inext2;
        Intent inext;

        inext = new Intent(MainActivity.this, MainActivity2.class);
        inext2=new Intent(MainActivity.this,MainActivity2.class);


        inext.putExtra("title", "home");
        inext.putExtra("name", "Rahul");
        inext.putExtra("Rollno", "32");



        inext2.putExtra("title1","Ramesh");
        inext2.putExtra("Name1","Ramesh");
        inext2.putExtra("Rollno1","23");


     button.setOnClickListener(view -> {

         startActivity(inext);


     });




        but.setOnClickListener(view -> startActivity(inext2));
    }



}