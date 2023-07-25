package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
ActivityMainBinding.inflate(layoutInflater)
    }
    val list=ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        list.add("Nepal")
        list.add("india")
        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list)

        binding.spinner.adapter=adapter





    }
}