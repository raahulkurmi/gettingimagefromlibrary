package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val list=ArrayList<dataclass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        list.addAll(dataprovider.getdata())
        binding.rectangles.layoutManager=LinearLayoutManager(this)
        binding.rectangles.adapter=recyclerviewadapter(list)
        binding.rectangles.setHasFixedSize(true)





    }
}