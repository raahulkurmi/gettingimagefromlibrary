package com.example.roomlibarary2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText title,amount;
AppCompatButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        amount=findViewById(R.id.amount);
        add=findViewById(R.id.add);





    }
}