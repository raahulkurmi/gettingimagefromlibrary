package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.btmnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.home){
                    fragmanager(new BlankFragment(),false);

                } else if (id==R.id.first) {
                    fragmanager(new BlankFragment2(),false);

                }
                else if (id==R.id.second) {
                    fragmanager(new BlankFragment3(),false);
                }

                else if (id==R.id.third) {
                    fragmanager(new BlankFragment4(),false);

                }
                else   {
                    fragmanager(new BlankFragment5(),true);

                }



                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.fourth);
    }
    public void fragmanager(Fragment frag,boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag) {
            ft.add(R.id.framelayout, frag);
        }
        else {
            ft.replace(R.id.framelayout,frag);
        }
        ft.commit();
    }
}