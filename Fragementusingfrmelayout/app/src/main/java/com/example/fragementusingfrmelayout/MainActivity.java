package com.example.fragementusingfrmelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create new fragment and transaction
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();


// Replace whatever is in the fragment_container view with this fragment
                transaction.add(R.id.frag, new afragment());

// Commit the transaction
                transaction.commit();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();


// Replace whatever is in the fragment_container view with this fragment
                transaction.add(R.id.frag, new bfragemnet());

// Commit the transaction
                transaction.commit();

            }
        });
    }
}