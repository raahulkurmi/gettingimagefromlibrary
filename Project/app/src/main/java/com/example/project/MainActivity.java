package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {
    EditText Email, password;
    TextView forgetpassword, Registerclick;
    AppCompatButton Login, googlesignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        Login = findViewById(R.id.appCompatButton);
        googlesignup = findViewById(R.id.appCompatButton2);
        forgetpassword = findViewById(R.id.textView2);
        Registerclick = findViewById(R.id.Registerclick);


        Login.setOnClickListener(view -> {
            String Useremail = Email.getText().toString();
            String userpassword = password.getText().toString();
            if (Useremail.isEmpty() && userpassword.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter the Email & password", Toast.LENGTH_SHORT).show();

            } else if (Useremail.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter the Email", Toast.LENGTH_SHORT).show();
            } else if (userpassword.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter the password", Toast.LENGTH_SHORT).show();

            }
        });





        Registerclick.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Signup.class)));


        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Log.e("TOKENDETAIL","Token failed to recieved");
                return;
            }
            String token= task.getResult();
            Log.d("TOKEN",token);
        });



    }

}