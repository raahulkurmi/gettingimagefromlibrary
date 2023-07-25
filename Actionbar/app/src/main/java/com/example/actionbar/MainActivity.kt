package com.example.actionbar

import android.R
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.actionbar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
      if(supportActionBar!=null){
          supportActionBar!!.setDisplayHomeAsUpEnabled(true)
      }

        binding.toolbar.title="Rahul"
        binding.toolbar.subtitle="Chauhdhary"



    }
}