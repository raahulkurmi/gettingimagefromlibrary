package com.example.alertdailogbox;

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


//        AlertDialog alert=new AlertDialog.Builder(getApplicationContext()).create();
//        alert.setTitle("Term and condition");
//        alert.setIcon(R.drawable.baseline_branding_watermark_24);
//        alert.setMessage("Have you read all T & c");
//        alert.setButton("yes i have read t & c", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(),"Read",Toast.LENGTH_SHORT).show();
//            }
//        });
//        alert.show();
//        AlertDialog.Builder deldailog=new AlertDialog.Builder(getApplicationContext());
//                deldailog.setIcon(R.drawable.ic_launcher_background);
//                        deldailog.setTitle("Delete ");
//                        deldailog.setMessage("Are you sure want to delete");
//                        deldailog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                            //positive
//                                Toast.makeText(getApplicationContext(),"clicked yes",Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        deldailog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                //negative
//                                Toast.makeText(getApplicationContext(),"clicked no",Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        deldailog.show();
//
   }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitdialog=new AlertDialog.Builder(this);
        exitdialog.setIcon(R.drawable.ic_launcher_background);
        exitdialog.setTitle("Exit");
        exitdialog.setMessage("Are you sure want to exit");
        exitdialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_SHORT).show();
            }
        });
        exitdialog.setNegativeButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
                Toast.makeText(getApplicationContext(),"no",Toast.LENGTH_SHORT).show();
            }
        });
        exitdialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_SHORT).show();

            }
        });
        exitdialog.show();





    }
}