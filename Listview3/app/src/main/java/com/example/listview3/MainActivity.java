package com.example.listview3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spin;
    AutoCompleteTextView autocomplete;
    ArrayList<String> id=new ArrayList<>();
    ArrayList<String> state=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin=findViewById(R.id.spin);
        autocomplete=findViewById(R.id.autocomplete);
        id.add("adhar");
        state.add("Gujrat");
        ArrayAdapter<String> name=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,id);
        spin.setAdapter(name);
        ArrayAdapter<String> statename=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,state);
        autocomplete.setAdapter(statename);
        autocomplete.setThreshold(1);


    }
}