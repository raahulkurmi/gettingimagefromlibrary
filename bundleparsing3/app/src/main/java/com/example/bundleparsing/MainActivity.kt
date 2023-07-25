package com.example.bundleparsing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bundleparsing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent=Intent(this,parsing::class.java)
        val bundle=Bundle()
        bundle.putString("Name","Rahul")
        bundle.putString("college","Rku")
        intent.putExtras(bundle)
        startActivity(intent)
    }
}