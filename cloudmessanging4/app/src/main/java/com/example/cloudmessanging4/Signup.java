package com.example.cloudmessanging4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Signup extends AppCompatActivity {
    TextView loginclick;
    EditText name,lastname,email,mobile,password,cnfpassword;
    AppCompatButton Signup;
   private FirebaseAuth Fauth;
   FirebaseFirestore Fstore=FirebaseFirestore.getInstance();
ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        loginclick=findViewById(R.id.textView6);
        name=findViewById(R.id.Firstname);
        lastname=findViewById(R.id.Lastname);
        email=findViewById(R.id.registeremail);
        mobile=findViewById(R.id.mobilenumber);
        password=findViewById(R.id.password);
        cnfpassword=findViewById(R.id.cnfpassword);
        Signup=findViewById(R.id.Signupbutton);
        progressBar=findViewById(R.id.progressbar);
        Fauth=FirebaseAuth.getInstance();

    Signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String Name=name.getText().toString();
            String Lastname=lastname.getText().toString();
            String Email=email.getText().toString();
            String Number=mobile.getText().toString();
            String Password=password.getText().toString();
            String Cnfpassword=cnfpassword.getText().toString();

            if(Name.isEmpty()||Lastname.isEmpty()||Email.isEmpty()||Number.isEmpty()||Password.isEmpty()||Cnfpassword.isEmpty()){
                Toast.makeText(getApplicationContext(),"Enter all the field ",Toast.LENGTH_SHORT).show();
            }
            if(!Password.equals(Cnfpassword)){
                Toast.makeText(getApplicationContext(),"Passowrd Doesn't match",Toast.LENGTH_SHORT).show();

            }
            Fauth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
//                        startActivity(new Intent(getApplicationContext(), Login.class));
                        Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();

                        Fstore.collection("User").document(FirebaseAuth.getInstance().getUid()).set(new Contactadapter(Name,Lastname,Number,Email,Password,Cnfpassword));
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();


                }
            });


        }
    });

//                String Name=name.getText().toString();
//                String Lastname=lastname.getText().toString();
//                String Email=email.getText().toString();
//                String Number=mobile.getText().toString();
//                String Password=password.getText().toString();
//                String Cnfpassword=cnfpassword.getText().toString();



                
               






        loginclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}