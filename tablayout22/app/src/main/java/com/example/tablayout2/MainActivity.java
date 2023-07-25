package com.example.tablayout2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tab);
        viewPager=findViewById(R.id.pager);
        viewpagermessengeradapter view=new viewpagermessengeradapter(getSupportFragmentManager());
        viewPager.setAdapter(view);
        tabLayout.setupWithViewPager(viewPager);


    }
}