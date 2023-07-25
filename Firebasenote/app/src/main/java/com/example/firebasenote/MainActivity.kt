package com.example.firebasenote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasenote.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)

    }
    var itemlist=ArrayList<user>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.insertbutton.setOnClickListener {
            val key = Firebase.database.reference.child("Note").push().key
            Firebase.database.reference.child("Note").child(key!!)
                .setValue(user(binding.note.text.toString(),key)).addOnSuccessListener {
                    Toast.makeText(this, "succes", Toast.LENGTH_SHORT).show()
                }

        }
        binding.insertview.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }


    }

}