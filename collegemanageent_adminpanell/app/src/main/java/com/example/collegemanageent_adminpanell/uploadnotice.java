package com.example.collegemanageent_adminpanell;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

public class uploadnotice extends AppCompatActivity {
    MaterialCardView addimage;
    private  final int REQ=1;
    Bitmap bitmap;
    ImageView noticeimageview;
    TextInputEditText noticetitle;
    MaterialButton uploadnotice;
    DatabaseReference reference;
    StorageReference storagerefrence;
    String downloadurl="";
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadnotice);
        reference = FirebaseDatabase.getInstance().getReference();
        storagerefrence = FirebaseStorage.getInstance().getReference();
        pd = new ProgressDialog(getApplicationContext());


        addimage = findViewById(R.id.Addimage);
        noticeimageview = findViewById(R.id.notceimageview);
        noticetitle = findViewById(R.id.noticetitle);
        uploadnotice = findViewById(R.id.uploadnoticebutton);


        uploadnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.requireNonNull(noticetitle.getText()).toString().isEmpty()) {
                    noticetitle.setError("Empty");
                    noticetitle.requestFocus();
                } else if (bitmap == null) {
                    uploaddata();


                } else
                    uploadimage();
            }

            private void uploaddata() {
                reference = reference.child("");
                final String uniquekey = reference.push().getKey();
                String title = Objects.requireNonNull(noticetitle.getText()).toString();


                Calendar calfordata = Calendar.getInstance();
                SimpleDateFormat currentdate = new SimpleDateFormat("dd-MM-yy");
                String date = currentdate.format(calfordata.getTime());
                Calendar calfortime = Calendar.getInstance();
                SimpleDateFormat currenttime = new SimpleDateFormat("hh:m a");
                String time = currenttime.format(calfortime.getTime());


                noticedata noticedata1 = new noticedata(title, downloadurl, date, time, uniquekey);
                assert uniquekey != null;
                reference.child(uniquekey).setValue(noticedata1).addOnSuccessListener(unused -> {
                    pd.dismiss();
                    Toast.makeText(getApplicationContext(), "posted", Toast.LENGTH_LONG).show();
                }).addOnFailureListener(e -> {
                    pd.dismiss();

                    Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_LONG).show();

                });


            }

            private void uploadimage() {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
                byte[] finalimage = baos.toByteArray();
                final StorageReference filepath;
                filepath = storagerefrence.child("Notice").child(Arrays.toString(finalimage) + "jpg");
                final UploadTask uploadtask = filepath.putBytes(finalimage);
                uploadtask.addOnCompleteListener(com.example.collegemanageent_adminpanell.uploadnotice.this, task -> {
                    if (task.isSuccessful()) {
                        uploadtask.addOnSuccessListener(taskSnapshot -> filepath.getDownloadUrl().addOnSuccessListener(uri -> {
                            downloadurl = String.valueOf(uri);
                            uploaddata();

                        }));
                    } else {
                        Toast.makeText(getApplicationContext(), "Somethingwent wrong", Toast.LENGTH_LONG).show();
                    }

                });


            }
        });


        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengallery();
            }

            private void opengallery() {
                Intent pickgallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickgallery, REQ);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==REQ){
                noticeimageview.setImageURI(data.getData());
            }
        }
    }
}



