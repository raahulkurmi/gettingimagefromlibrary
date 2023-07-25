package com.example.spinerdropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spin;
    ArrayList<String> id=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin =findViewById(R.id.Spin);
          id.add("adhar");
        id.add("driving");
        id.add("voter");
        id.add("rashan");
        id.add("pan");
        id.add("passport");
        id.add("college");

        ArrayAdapter<String> idname=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,id);
        spin.setAdapter(idname);

    }
}