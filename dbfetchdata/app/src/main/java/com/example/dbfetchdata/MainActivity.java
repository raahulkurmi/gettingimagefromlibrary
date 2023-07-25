package com.example.dbfetchdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper db=new dbhelper(this);
//        db.addcontact("Rahul","2353416234");
       ArrayList<list> array= db.fetchdata();
       for(int i=0;i< array.size();i++){
           Log.d("Contact_info","Name"+ array.get(i).name + " ,Contact "+ array.get(i).contact);
       }

    }
}