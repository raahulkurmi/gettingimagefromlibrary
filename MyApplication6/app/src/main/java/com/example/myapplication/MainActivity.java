package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button opencamera,opengallery;
    private final int request_camera=1;
    private final int request_galley=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageview);
        opencamera=findViewById(R.id.opencamera);
        opengallery=findViewById(R.id.opengallery);


        opengallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent igallery=new Intent(Intent.ACTION_PICK);
                igallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(igallery,request_galley);
            }
        });

        opencamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent icamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(icamera,request_camera);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==request_camera){
                Bitmap img=(Bitmap)(data.getExtras().get("data"));
                imageView.setImageBitmap(img);

            }
            if(requestCode==request_galley){
                imageView.setImageURI(data.getData());
            }
        }
    }
}