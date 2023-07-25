package com.example.loginpage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    Button login;
    TextView email,password;
    Intent inext,inext2,inext3,inext4;
    TextView forget;
    ImageView facebook,gmail,insagram;
    String url="https://www.facebook.com/";
    String url1="https://mail.google.com/mail/u/0/#inbox";
    String url2="https://www.instagram.com/accounts/onetap/?next=%2F";
    CardView cardView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        login=findViewById(R.id.login);
        facebook=findViewById(R.id.facebook);
        gmail=findViewById(R.id.gmail);
        insagram=findViewById(R.id.insagram);
        cardView=findViewById(R.id.cardView);
        forget=findViewById(R.id.forget);
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);


        //for facebook



        inext=new Intent(MainActivity.this,MainActivity2.class);
        inext2=new Intent(Intent.ACTION_VIEW);
        inext2.setData(Uri.parse(url));
        //for gmail

        inext3=new Intent(Intent.ACTION_VIEW);
        inext3.setData(Uri.parse(url1));
        //for instagram

        inext4=new Intent(Intent.ACTION_VIEW);
       inext4.setData(Uri.parse(url2));
       cardView.setAnimation(anim);








        login.setOnClickListener(view -> {
            String Email=email.getText().toString();
            String Password=password.getText().toString();

            if (Email.equals("Rahul") && Password.equals("1234")){

                Toast.makeText(MainActivity.this,"correct",Toast.LENGTH_LONG).show();

            }
            else
              Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_LONG).show();

        });





        forget.setOnClickListener(view -> startActivity(inext));
        facebook.setOnClickListener(view -> startActivity(inext2));
        gmail.setOnClickListener(view -> startActivity(inext3));
       insagram.setOnClickListener(view -> startActivity(inext4));




    }
//    public void intent(View v){
//        inext=new Intent(MainActivity.this,MainActivity2.class);
//        startActivity(inext);
//
//    }

}