package com.example.firebaseauthenctication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity {
EditText name,email,number,pass,cnfpass;
Button register;
FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.Entername);
        email=findViewById(R.id.Emailsec);
        number=findViewById(R.id.EnterNO);
        pass=findViewById(R.id.Enterpassword1);
        cnfpass=findViewById(R.id.cnfpassword);
        register=findViewById(R.id.Register);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=name.getText().toString();
                String Email=email.getText().toString();
                String Number=number.getText().toString();
                String Pass=pass.getText().toString();
                String Cnfpass=cnfpass.getText().toString();


                if(Name.isEmpty()||Email.isEmpty()||Number.isEmpty()||Pass.isEmpty()||Cnfpass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter all the field",Toast.LENGTH_SHORT).show();
                } else if (!Pass.equals(Cnfpass)) {
                    Toast.makeText(getApplicationContext(),"Password doesn't match",Toast.LENGTH_SHORT).show();


                }
                else{
                    firebaseAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            startActivity(new Intent(Register.this,MainActivity.class));

                                firebaseFirestore.collection("User").document(FirebaseAuth.getInstance().getUid()).set(new Contactmodel(Name,Email,Number));

                                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();







                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }
        });







    }
}