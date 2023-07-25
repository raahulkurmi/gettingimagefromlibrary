package com.example.collegeprojectfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.collegeprojectfinal.databinding.ActivityRegisteractivityBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class registeractivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityRegisteractivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        binding.imagebutton.setOnClickListener { 
            if(binding.entername.text.toString().equals("")||binding.enteremail.text.toString().equals("")||
                binding.enterpassword.text.toString().equals("")||binding.entercnfpassword.text.toString().equals(""))

            {
                Toast.makeText(this, "enter the detail", Toast.LENGTH_SHORT).show()

            }
           else if (!binding.enterpassword.text.toString().equals(binding.entercnfpassword.text.toString())){
                Toast.makeText(this, "password mismatch", Toast.LENGTH_SHORT).show()
            }
            else{
                Firebase.auth.createUserWithEmailAndPassword(binding.enteremail.text.toString(),
                    binding.enterpassword.text.toString()).addOnCompleteListener {
                        if(it.isSuccessful){
                            var users=signinuserclass(binding.entername.text.toString(),
                                binding.enteremail.text.toString(),
                                binding.enterpassword.text.toString(),
                                binding.entercnfpassword.text.toString()
                            )
                            Firebase.database.reference.child("Users").child(Firebase.auth.currentUser!!.uid).
                            setValue(users).addOnSuccessListener {
                                startActivity(Intent(this,LoginActivity::class.java))
                                Toast.makeText(this, "inserted succesfully", Toast.LENGTH_SHORT).show()

                            }.addOnFailureListener {
                                Toast.makeText(this, "not inserted", Toast.LENGTH_SHORT).show()
                            }
                        }
                    else{
                            Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                        }
                }
            }

        }

        
        
        
        
        
        
        
        binding.alreadyaclogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

    }
}