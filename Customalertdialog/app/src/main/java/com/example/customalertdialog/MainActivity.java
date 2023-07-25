package com.example.customalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


   Dialog dialog=new Dialog(this);
   dialog.setContentView(R.layout.customlayout);
   Button cancel=dialog.findViewById(R.id.cancel);
   cancel.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           dialog.dismiss();
           Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_SHORT).show();
       }
   });
   dialog.show();



    }

}