package com.example.realtimedatabse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Copyright");
            databaseReference.setValue("Rahul");
        DatabaseReference database= FirebaseDatabase.getInstance().getReference("Contact");
        contactmodel model=new contactmodel("Rahul","98123453w5");
        database.child("USER").setValue(model);

    }
}