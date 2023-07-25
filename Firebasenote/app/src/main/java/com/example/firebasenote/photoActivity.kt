package com.example.firebasenote

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.firebasenote.databinding.ActivityPhotoBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.dataObjects
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class photoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityPhotoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent=Intent()
            intent.action=Intent.ACTION_PICK
            intent.type="image/*"
            imagelauncher.launch(intent)
        }

    }
    val imagelauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode==Activity.RESULT_OK){
            if(it.data!=null){
                val imageuri=it.data!!.data


                Firebase.firestore.collection("photo").document(). set(it.data!!.setData(imageuri))   .addOnSuccessListener { it ->

                    Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show()

                    Picasso.get().load(imageuri.toString()).into(binding.imageView);
                    Firebase.database.reference.child("photo").push().setValue(imageuri.toString()).addOnSuccessListener {
                        Toast.makeText(this, "image inserted in realtime database", Toast.LENGTH_SHORT).show()
                    }



                }.addOnFailureListener {

                    Toast.makeText(this, "inserted failed", Toast.LENGTH_SHORT).show()
                }

            }
        }


    }


}