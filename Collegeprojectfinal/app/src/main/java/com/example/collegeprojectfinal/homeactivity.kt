package com.example.collegeprojectfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.collegeprojectfinal.databinding.ActivityHomeactivityBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.util.EventListener

class homeactivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityHomeactivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//fetching data fromt the database
       Firebase.database.reference.child("Users").child(Firebase.auth.currentUser!!.uid).addValueEventListener(
           object : ValueEventListener{
               override fun onDataChange(snapshot: DataSnapshot) {
                   var user=snapshot.getValue<signinuserclass>()
                   binding.textView4.text=user?.name

               }

               override fun onCancelled(error: DatabaseError) {

               }

           }




       )

        binding.signout.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}