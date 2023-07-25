package com.example.foodorderingappadminpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.foodorderingappadminpanel.databinding.ActivitySignupBinding
import com.example.foodorderingappadminpanel.modelclass.signupmodelclass
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class Signup : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            if(binding.Name.text.toString().equals("")||
                binding.Lastname.text.toString().equals("")||
                binding.Emailorphone.text.toString().equals("")||
                binding.Loginpassword.text.toString().equals("")||
                binding.cnfpassword.text.toString().equals("")){
                Toast.makeText(this, "Please fill the details", Toast.LENGTH_SHORT).show()
            }else if(!binding.Loginpassword.text.toString().equals(binding.cnfpassword.text.toString())){
                Toast.makeText(this, "password doesn't match", Toast.LENGTH_SHORT).show()



            }
            else{
                Firebase.auth.createUserWithEmailAndPassword(binding.Emailorphone.text.toString(),binding.Loginpassword.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful) {

                        var signupmodelclass = signupmodelclass(
                            binding.Name.text.toString(),

                            binding.Lastname.text.toString(),
                            binding.Emailorphone.text.toString(),
                            binding.Loginpassword.text.toString()
                        )

                        Firebase.database.reference.child("Admin SignedUp User")
                            .child(Firebase.auth.currentUser!!.uid).setValue(signupmodelclass)
                            .addOnSuccessListener {
                                MotionToast.createToast(this,
                                    "Hurray success 😍",
                                    "Upload Completed successfully!",
                                    MotionToastStyle.SUCCESS,
                                    MotionToast.GRAVITY_BOTTOM,
                                    MotionToast.LONG_DURATION,
                                    ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))

//                                startActivity(Intent(this@Signup, LoginActivity::class.java))


                            }
                    }

                }.addOnFailureListener {
                    MotionToast.createToast(this,
                        "Failed ☹️",
                        "Profile Update Failed!",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold))

                }
            }
        }












    }
}