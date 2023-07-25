package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration extends AppCompatActivity {
    EditText name,mobile,email,pass,password;
    AppCompatButton signup1;
    TextView signin;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.name);
        mobile=findViewById(R.id.mobile);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        password=findViewById(R.id.password);
        signup1=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Name=name.getText().toString();
                final String Mobile=mobile.getText().toString();
                final String Email=email.getText().toString();
                final String Pass=pass.getText().toString();
                final String Password=password.getText().toString();
                if(Name.isEmpty()|| Mobile.isEmpty()||Email.isEmpty()||Pass.isEmpty()||Password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill all the blank",Toast.LENGTH_SHORT).show();
                }
                else if(!Pass.equals(Password)){
                    Toast.makeText(getApplicationContext(),"Password is not matching",Toast.LENGTH_SHORT).show();

                }

                else {

                    databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(Mobile)){
                                Toast.makeText(getApplicationContext(),"Number ALready exist",Toast.LENGTH_SHORT).show();

                            }
                            else{

                                databaseReference.child("user1").child(Mobile).child("Full name").setValue(Name);
                                databaseReference.child("user1").child(Mobile).child("Email").setValue(Email);
                                databaseReference.child("user1").child(Mobile).child("Password").setValue(Password);
                                Toast.makeText(getApplicationContext(),"User registeres succesfully",Toast.LENGTH_SHORT).show();
                                finish();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });



                }

            }
        });

    }
}