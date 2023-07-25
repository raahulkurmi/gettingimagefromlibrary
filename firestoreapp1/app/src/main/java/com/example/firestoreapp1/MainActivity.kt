package com.example.firestoreapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firestoreapp1.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db= Firebase.firestore
        val user= hashMapOf(
            "Name" to binding.Name.text.toString(),
            "Password" to binding.Password.text.toString(),



        )
        db.collection("users")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this,"Data added ",Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this," Data not added ",Toast.LENGTH_LONG).show()
            }
    }
}