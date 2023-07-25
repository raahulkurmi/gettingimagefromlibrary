package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn;
        TextView txt,txt1;

        final int[] counter = {0};
        btn=findViewById(R.id.btn);
        txt=findViewById(R.id.txt);
        txt1=findViewById(R.id.txt2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      int count= counter[0]++;
                      txt1.setText(count);


            }
        });





    }


}