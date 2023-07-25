package com.example.collegemanageent_adminpanell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    MaterialCardView notice;
    Intent inext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notice=findViewById(R.id.notice);











    }

    public void onclick(View view){
        switch ((view.getId())){
            case R.id.notice:
                inext=new Intent(getApplicationContext(),uploadnotice.class);
                startActivity(inext);


        }
        

    }
}