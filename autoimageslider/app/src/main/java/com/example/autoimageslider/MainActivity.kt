package com.example.autoimageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.autoimageslider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val slidemodel = ArrayList<SlideModel>() // Initialize the slidemodel variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root) // Use binding.root instead of R.layout.activity_main

        slidemodel.add(SlideModel(R.drawable.four, ScaleTypes.FIT))
        slidemodel.add(SlideModel(R.drawable.one, ScaleTypes.FIT))
        slidemodel.add(SlideModel(R.drawable.five, ScaleTypes.FIT))
        slidemodel.add(SlideModel(R.drawable.six, ScaleTypes.FIT))
        binding.imageSlider.setImageList(slidemodel)
    }
}
