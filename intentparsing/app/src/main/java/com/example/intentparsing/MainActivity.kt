package com.example.intentparsing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentparsing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private val binding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.intentpassingbutton.setOnClickListener {
            var int= Intent(this,next::class.java)

            int.putExtra("My msg","Hi my name is rahul")
            startActivity(int)
            finish()
        }
    }
}