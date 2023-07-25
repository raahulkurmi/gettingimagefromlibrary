package com.example.dyanamicfragement;

import static com.example.dyanamicfragement.R.id.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int ROOT_FRAGEMENT_TAG = 1;
    Button frageA,frageB,fragec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frageA=findViewById(R.id.FrageA);
        frageB=findViewById(R.id.Frageb);
        fragec=findViewById(R.id.FrageC);
        loadfrag(new AFragment(),0);

        frageA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create new fragment and transaction
                loadfrag(new AFragment(),0);







        }
        });

        frageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new BFragment(),1);

            }
        });
        fragec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new CFragment(),1);

            }
        });

    }
    public void loadfrag(Fragment frag,int flag) {
         FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(flag==0){
            transaction.add(R.id.fragment, frag);
            fragmentManager.popBackStack(ROOT_FRAGEMENT_TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            transaction.addToBackStack(String.valueOf(ROOT_FRAGEMENT_TAG));


                }
        else {
                transaction.replace(R.id.fragment, frag);
            transaction.addToBackStack(null);

}
                transaction.commit();

    }

}