package com.example.lottie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lottie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.summer.setOnClickListener {
            binding.animationView2.visibility=View.GONE
            binding.animationView.visibility=View.VISIBLE
            binding.animationView3.visibility=View.GONE

        }
        binding.rain.setOnClickListener {
            binding.animationView.visibility=View.GONE
            binding.animationView2.visibility=View.VISIBLE
            binding.animationView3.visibility=View.GONE
        }
        binding.cloud.setOnClickListener {
            binding.animationView.visibility=View.GONE
            binding.animationView3.visibility=View.VISIBLE
            binding.animationView2.visibility=View.GONE
        }
    }
}