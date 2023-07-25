package com.example.implicitintnentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnshare,btndial,btnmessage,btnemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndial=findViewById(R.id.dial);
        btnemail=findViewById(R.id.email);
        btnmessage=findViewById(R.id.message);
        btnshare=findViewById(R.id.share);
        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idial=new Intent(Intent.ACTION_DIAL);
                idial.setData(Uri.parse("tel:+891832432523"));
                startActivity(idial);
            }
        });
        btnmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imsg=new Intent(Intent.ACTION_SENDTO);
                imsg.setData(Uri.parse("smsto:"+Uri.encode("+0973242332")));
                imsg.putExtra("sms_body","please solve the problem");
                startActivity(imsg);
            }
        });
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iemail=new Intent(Intent.ACTION_SEND);
                iemail.setType("message/rfc8222");
                iemail.putExtra(Intent.EXTRA_EMAIL,new String[] {"77rahulchaufar@gmail","jhhjv@gmail.com"});
                iemail.putExtra(Intent.EXTRA_SUBJECT,"my sbject");
                iemail.putExtra(Intent.EXTRA_TEXT,"my fist mail");
                startActivity(Intent.createChooser(iemail,"via "));
            }
        });
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ishare=new Intent(Intent.ACTION_SEND);
                ishare.setType("text/plain");
                ishare.putExtra(Intent.EXTRA_TEXT,"solve the issue");
                startActivity(Intent.createChooser(ishare,"Via"));

            }
        });

    }
}