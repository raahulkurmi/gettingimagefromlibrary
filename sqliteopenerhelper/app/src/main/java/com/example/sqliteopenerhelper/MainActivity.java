package com.example.sqliteopenerhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    ArrayList<String> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst=findViewById(R.id.list);
        dbhelper dbhelp=new dbhelper(this);
//        dbhelp.addcontact("Rahul","12124234");
//        dbhelp.addcontact("Raasf","121224q4234");
//        dbhelp.addcontact("Rahusfsl","12122344234");
//        dbhelp.addcontact("Rahsful","12124324234");
//        dbhelp.addcontact("Rahdsfzul","121232424234");
        ArrayList<Contactmodel> arr =dbhelp.fetch();
     for (int i=0;i< arr.size();i++){
         Log.d("Contact_info","Name"+arr.get(i).name+"Contact"+arr.get(i).contact);
     }






    }

}