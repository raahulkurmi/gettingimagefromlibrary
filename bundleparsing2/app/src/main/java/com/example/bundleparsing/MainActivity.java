package com.example.bundleparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent inext,inext2;
    Button Rahulbtn,binodbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rahulbtn=findViewById(R.id.Rahulbtn);
        binodbtn=findViewById(R.id.binodbtn);
        inext=new Intent(getApplicationContext(),MainActivity2.class);
        inext2=new Intent(getApplicationContext(),MainActivity2.class);
        inext.putExtra("title","aboutRahul");
        inext.putExtra("name","Rahul");
        inext.putExtra("class",4);


        inext2.putExtra("title","aboutbinod");
        inext2.putExtra("name","binod");
        inext2.putExtra("class",4);


        Rahulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(inext);
            }
        });
        binodbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(inext2);
            }
        });

    }
}