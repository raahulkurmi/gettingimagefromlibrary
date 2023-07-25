package com.example.cloudmessanging4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class homeactivity extends AppCompatActivity {
    TextView name,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        name=findViewById(R.id.Name);
        mail=findViewById(R.id.Mail);

    }
}