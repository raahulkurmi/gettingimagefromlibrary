package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Spinner spin;
    AutoCompleteTextView auto;
    //array approach
    //int [] arr=new int[]{1,2,3,4,5};
    //arraylist approach
    
    
    ArrayList<String> arrnames =new ArrayList<>();
    ArrayList<String> idtype=new ArrayList<>();
    ArrayList<String> arrlanguage=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        spin=findViewById(R.id.spin);
        auto=findViewById(R.id.auto);
        
        
        
        arrnames.add("Rahul");
        arrnames.add("Ramesh");
        arrnames.add("Rohan");
        arrnames.add("Rohit");
        arrnames.add("Ravi");
        arrnames.add("Ramesh");
        arrnames.add("Raju");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        arrnames.add("Rahul");
        
        
        idtype.add("adhar card");
        idtype.add("Rashan card");
        idtype.add("Driving license");

        idtype.add("Passport");
        idtype.add("Voter id");
        idtype.add("Coollege id");
        
        ArrayAdapter<String> list=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,idtype);
        spin.setAdapter(list);
        

//      ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,arrnames);
//
//    list.setAdapter(adapter);


//
//
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//              if(i==0){
//                  Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
//              }
//
//            }
//        });

        //autocomplete

        arrlanguage.add("nepali");
        arrlanguage.add("nepali");
        arrlanguage.add("nepali");
        arrlanguage.add("nepali");
        arrlanguage.add("nepali");
        arrlanguage.add("nepali");
        arrlanguage.add("nepali");
        arrlanguage.add("nepali");
        arrlanguage.add("nepali");
        arrlanguage.add("nepali");


        ArrayAdapter<String> autocompte=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrlanguage);
        auto.setAdapter(autocompte);
        auto.setThreshold(1);


    }
}