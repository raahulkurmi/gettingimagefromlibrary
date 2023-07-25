package com.example.infobyteinternshala

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.infobyteinternshala.databinding.ActivityLoginactivityBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.instantapps.Launcher
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Loginactivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginactivityBinding.inflate(layoutInflater)
    }
    private lateinit var googlesigninclient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googlesigninclient = GoogleSignIn.getClient(this, gso)





        binding.signinusinggoogle.setOnClickListener {
            var googlesingin = googlesigninclient.signInIntent
            Launcher.launch(googlesingin)
        }


    }

    private val Launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                if (task.isSuccessful) {
                    val account: GoogleSignInAccount? = task.result
                    val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
                    Firebase.auth.signInWithCredential(credential).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this@Loginactivity, "Suces", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@Loginactivity, "failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this@Loginactivity, "cancelled", Toast.LENGTH_SHORT).show()
                }
            }


        }
}