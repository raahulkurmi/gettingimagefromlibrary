package com.example.newactiviyt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.newactiviyt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val animation: Animation = AnimationUtils.loadAnimation(this,R.anim.fadein)
        binding.introimage.startAnimation(animation)
        Handler().postDelayed({
            startActivity(Intent(this@MainActivity,MainActivity2::class.java))
            finish()

        },4000)
    }
}