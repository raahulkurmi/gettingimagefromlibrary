package com.example.firebaseauthenctication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView signup,forgetpass;

    EditText username,userpassword;
    Button signin;
    ProgressBar progess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        signup=findViewById(R.id.sign_up);
        forgetpass=findViewById(R.id.forgetpassword);
        username=findViewById(R.id.Enteremail);
        userpassword=findViewById(R.id.Enterpassword);
        signin=findViewById(R.id.Signin);
        progess=findViewById(R.id.progress);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progess.setVisibility(View.VISIBLE);
                String Signemail=signup.getText().toString();
                String Userpassword=userpassword.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(Signemail,Userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progess.setVisibility(View.GONE);
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login succesful", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progess.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });







        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });

    }
}