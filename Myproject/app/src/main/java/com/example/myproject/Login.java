package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText login, password;
    TextView signup;

    AppCompatButton signin;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("user");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.Email);
        signin = findViewById(R.id.signin);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=login.getText().toString();
                String  pass=login.getText().toString();

                if(login.getText().toString().equals("") || password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"enter the value",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("user1").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(username)){
                                String password=snapshot.child(username).child("password").getValue(String.class);
                                if(password.equals(pass)){
                                    Toast.makeText(getApplicationContext(),"login ",Toast.LENGTH_SHORT).show();
                                }
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


//        signin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//
//                    String username = login.getText().toString();
//                    String userpass = password.getText().toString();
//                    DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("user");
//                    Query userquery = databaseReference1.orderByChild("").equalTo(username);
//                    userquery.addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            if (snapshot.exists()) {
//                                String pass = snapshot.child(username).child("password").getValue(String.class);
//                                if (pass.equals(userpass)) {
//                                    Toast.makeText(getApplicationContext(), "login succesful", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    Toast.makeText(getApplicationContext(), "user doesnot exsit", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//                }
//
//
//        });
//    }



//        }


//
//       signup.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//                Intent inext=new Intent(getApplicationContext(),Registration.class);
//                startActivity(inext);
//            }});
//
//    }
//

