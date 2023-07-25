package com.example.collegeprojectfinal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.collegeprojectfinal.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.instantapps.Launcher
import com.google.android.gms.tasks.Task
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var googlesigninclient : GoogleSignInClient
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var googleSignInOptions=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
        googlesigninclient=GoogleSignIn.getClient(this,googleSignInOptions)






binding.signinusinggoogle.setOnClickListener {
    var googlesingin=googlesigninclient.signInIntent
    Launcher.launch(googlesingin)
}








        binding.imagebutton.setOnClickListener {
            if(binding.enteremail.text.toString().equals("") || binding.enterpassword.text.toString().equals(""))
            {
                Toast.makeText(this, "Enter the credential", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Firebase.auth.signInWithEmailAndPassword(binding.enteremail.text.toString(),binding.enterpassword.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){

                        Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,homeactivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }


        binding.register.setOnClickListener {
            startActivity(Intent(this,registeractivity::class.java))
            finish()
        }

    }







    override fun onStart() {
        super.onStart()
        if(Firebase.auth.currentUser!=null){
            startActivity(Intent(this,homeactivity::class.java))
            finish()

        }
    }

    private val Launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        result->
        if(result.resultCode==Activity.RESULT_OK){

            val task=GoogleSignIn.getSignedInAccountFromIntent(result.data)
            if(task.isSuccessful){
                val account:GoogleSignInAccount?=task.result
                val credential=GoogleAuthProvider.getCredential(account?.idToken,null)
                Firebase.auth.signInWithCredential(credential).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this, "succes", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                    }
                }


            }



        }else{
            Toast.makeText(this, "Goole sigin canclled", Toast.LENGTH_SHORT).show()
        }



    }
// The fixed code for handling the result
//private val Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//    if (result.resultCode == Activity.RESULT_OK) {
//        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//        try {
//            val account = task.getResult(ApiException::class.java)
//            val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
//            Firebase.auth.signInWithCredential(credential)
//                .addOnCompleteListener { signInTask ->
//                    if (signInTask.isSuccessful) {
//                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
//                    } else {
//                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
//                    }
//                }
//        } catch (e: ApiException) {
//            Toast.makeText(this, "Google sign-in failed", Toast.LENGTH_SHORT).show()
//        }
//    } else {
//        Toast.makeText(this, "Google sign-in canceled", Toast.LENGTH_SHORT).show()
//    }
//}


}