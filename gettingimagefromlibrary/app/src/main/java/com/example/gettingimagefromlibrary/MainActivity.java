package com.example.gettingimagefromlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button getimage;
    ImageView img;
    private final int req=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getimage=findViewById(R.id.getimage);
        img=findViewById(R.id.picture);



        getimage.setOnClickListener(view -> {
            Intent inext=new Intent(Intent.ACTION_PICK);
            inext.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            startActivityForResult(inext,req);





        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==req){
                assert data != null;
                img.setImageURI(data.getData());



            }
        }
    }
}