package com.example.opeingcamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button opencamera;
    private final int req=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.imageview);
        opencamera=findViewById(R.id.opencamera);

        opencamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inext=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(inext,req);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==req){
                Bitmap img=(Bitmap)data.getExtras().get("data");
                image.setImageBitmap(img);
            }
        }
    }
}