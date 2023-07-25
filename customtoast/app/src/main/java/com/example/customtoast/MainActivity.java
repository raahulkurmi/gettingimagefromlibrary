package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        Toast toast=new Toast(getApplicationContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               View view =getLayoutInflater().inflate(R.layout.custom_button_layout, (ViewGroup) findViewById( R.id.mylayout));
                toast.setView(view);
                TextView txtmsg=view.findViewById(R.id.txtmsg);
                txtmsg.setText("Message sent successfully");
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.END,0,0);
                toast.show();

            }
        });



    }
}