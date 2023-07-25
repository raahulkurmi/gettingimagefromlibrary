package com.example.alertdailog2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder Ext=new AlertDialog.Builder(this);
        Ext.setIcon(R.drawable.ic_launcher_background);
        Ext.setTitle("Delete");
        Ext.setTitle("Are you sure want to exit");
        Ext.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Not exit",Toast.LENGTH_SHORT).show();
            }
        });
        Ext.setNegativeButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
                Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_SHORT).show();


            }
        });
        Ext.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext()," cancelled",Toast.LENGTH_SHORT).show();

            }
        });
        Ext.show();
    }
}