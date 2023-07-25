package com.example.customtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Toolbar");
        }
//        toolbar.setTitle("MY toolbar");
        toolbar.setSubtitle("Subtitle");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.open){
            Toast.makeText(this,"opening file",Toast.LENGTH_SHORT).show();
        } else if (id==R.id.save) {
            Toast.makeText(this,"item saved",Toast.LENGTH_SHORT).show();

        } else if (id==R.id.delete) {
Toast.makeText(this,"item deleted ",Toast.LENGTH_SHORT).show();
        }
        else {
            //android.R.id.home
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}