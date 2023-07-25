package com.example.cloudmessanging2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
//            if(!task.isSuccessful()){
//                Log.d("token","failed");
//                return;
//            }
//            String token= task.getResult();
//            Log.d("Token",token);
//
//        });
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