package com.example.recyclerviewpractice;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    RecyclerView Recycle;
    ArrayList<layoutitem> list=new ArrayList<>();
    myadapter myadapter;
    FloatingActionButton actionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Recycle=findViewById(R.id.Recycle);
        actionButton=findViewById(R.id.actionbutton);

      actionButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Dialog dialog = new Dialog(getApplicationContext());
              dialog.setContentView(R.layout.activity_updatelayout);
              EditText entname = dialog.findViewById(R.id.entname);
              EditText entcontact = dialog.findViewById(R.id.entcontact);
              Button submit = dialog.findViewById(R.id.submit);

              submit.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      String name = "",number="";
                      if(!entname.getText().toString().equals("")){
                           name=entname.getText().toString();

                      }else {
                          Toast.makeText(getApplicationContext(),"enter the name",Toast.LENGTH_SHORT).show();
                      }
                      if(!entcontact.getText().toString().equals("")) {
                           number = entcontact.getText().toString();
                      }else {
                          Toast.makeText(getApplicationContext(),"enter the contact",Toast.LENGTH_SHORT).show();

                      }

                      list.add(new layoutitem(name , number));
                      myadapter.notifyItemInserted(list.size()-1);
                      Recycle.scrollToPosition(list.size()-1);
                      dialog.dismiss();


                  }

              });
              dialog.show();


          }

      });



















        Recycle.setLayoutManager(new LinearLayoutManager(this));













        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"rohan","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"rajesh","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahulasd","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahulasfdz","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahulasd","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahudasfl","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahulasd","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahulsazx","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahuldfas","9813124235"));

        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahusafdz","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahsafdul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahasdul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Radashul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rasdazxhul","9813124235"));

        list.add(new layoutitem(R.drawable.ic_launcher_background,"Raadshul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Radashul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Raasdhul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Raasdhul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Raadshul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Raasdhul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"RaadszXhul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahdwaszul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahsxzul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Raasdhul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));
        list.add(new layoutitem(R.drawable.ic_launcher_background,"Rahul","9813124235"));

        myadapter myadapter=new myadapter(this,list);
        Recycle.setAdapter(myadapter);
    }
}