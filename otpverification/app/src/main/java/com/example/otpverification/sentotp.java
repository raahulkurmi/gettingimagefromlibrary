package com.example.otpverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class sentotp extends AppCompatActivity {
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentotp);
        final EditText entermobile=findViewById(R.id.inpputmobile);
        Button getotp=findViewById(R.id.Getotp);

        final ProgressBar progressBar=findViewById(R.id.progressbar);

        getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(entermobile.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter the mobile number",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                getotp.setVisibility(View.INVISIBLE);
                PhoneAuthProvider.getInstance().verifyPhoneNumber("+91"+entermobile.getText().toString(),60, TimeUnit.SECONDS,sentotp.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        progressBar.setVisibility(View.GONE);
                        getotp.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        progressBar.setVisibility(View.GONE);
                        getotp.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCodeSent(@NonNull String verifiactionid, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                        progressBar.setVisibility(View.GONE);
                        getotp.setVisibility(View.VISIBLE);
                        Intent intent=new Intent(getApplicationContext(),verifyotp.class);
                        intent.putExtra("Mobile",entermobile.getText().toString());
                        intent.putExtra("verifiactionid",verifiactionid);
                        startActivity(intent);

                    }
                });
//                Intent intent=new Intent(getApplicationContext(),verifyotp.class);
//                intent.putExtra("Mobile",entermobile.getText().toString());
//
//                startActivity(intent);

                }

        });
    }

}