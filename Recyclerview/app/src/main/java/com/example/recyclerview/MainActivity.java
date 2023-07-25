package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView Recycle;
    ArrayList<Contactmodel> Name=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Recycle =findViewById(R.id.Recycle);
        Recycle.setLayoutManager(new LinearLayoutManager(this));




        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Rahul","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Rajesh","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Rohan","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Rahul","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Sohan","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Binod","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Mukesh","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"suresh","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"lutesh","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"cutesh","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Laudu","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"saudu","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"kaudu","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"topu","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"motu","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"loku","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Rajesh","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Rohan","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Rahul","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"lamde","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"chamde","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"kamde","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"lapde","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"sapde","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"napde","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"nonu","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"chonu","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"Rahul","9812124234"));


        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"sonu","9812124234"));
        Name.add(new Contactmodel(R.drawable.ic_launcher_background,"tonu","9812124234"));

       adapterclass adapter=new adapterclass(this,Name);
       Recycle.setAdapter(adapter);


    }
}