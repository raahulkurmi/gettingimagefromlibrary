package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Firstactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstactivity);
        Button button;
        button =findViewById(R.id.button);


      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent inext;
              inext=new Intent(Firstactivity.this,MainActivity.class);
              startActivity(inext);
          }
      });
    }
}