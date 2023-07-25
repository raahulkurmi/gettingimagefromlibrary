package com.example.newspaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout;
//Toolbar toolbar;
   TabItem menu,sport,entertainment,health,technology,science;
   FragmentContainerView fragmentContainerView;
   String api="2e29eaf346d5451ea24f0c16a52e09cf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        fragmentContainerView=findViewById(R.id.fragementcontainer);

        tablayout=findViewById(R.id.include);
        menu=findViewById(R.id.home);
        sport=findViewById(R.id.sport);
        entertainment=findViewById(R.id.entertainment);
        health=findViewById(R.id.health);
        technology=findViewById(R.id.technology);
        science=findViewById(R.id.science);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              switch (tab.getPosition()){
                  case 0:{
                      setfragement(new homefragment());

                  }
                  case 1:
                  {
                      setfragement(new sportfragment());

                  }
                  case 2:{
                      setfragement(new sciencefragment());
                  }
                  case 3:{
                      setfragement(new healthfragment());
                  }
                  case 4:{
                      setfragement(new entertainmenfragment());

                  }
                  case 5:{
                      setfragement(new technologyfragment());

                  }
              }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });












    }
    private void setfragement(Fragment frag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragementcontainer, frag);

        ft.commit();



    }

}