package com.example.bundleparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bundleparsing.databinding.ActivityParsing2Binding

class parsing : AppCompatActivity() {
    private val binding by lazy {
        ActivityParsing2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var string=intent.extras
        binding.textView.text= string!!.getString("Name")


    }

}