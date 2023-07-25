package com.example.intentparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentparsing.databinding.ActivityNextBinding
import com.example.intentparsing.databinding.ActivityNextBinding.*

class next : AppCompatActivity() {
    private val binding by lazy{
        ActivityNextBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}