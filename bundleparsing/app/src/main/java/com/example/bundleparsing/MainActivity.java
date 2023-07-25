package com.example.bundleparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent inext,inext2;
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.but);
        btn1=findViewById(R.id.but1);
        inext=new Intent(getApplicationContext(),MainActivity2.class);
        inext2=new Intent(getApplicationContext(),MainActivity2.class);
        inext.putExtra("title1","AboutRahul");
        inext.putExtra("name","Rahul");
        inext.putExtra("class","4");

        inext2.putExtra("title1","Aboutramesh");
        inext.putExtra("name1","Ramesh");
        inext.putExtra("class1","4");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(inext);


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(inext2);
            }
        });

    }
}