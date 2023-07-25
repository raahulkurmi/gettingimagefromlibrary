package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.videoview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var mediaController=MediaController(this)
        mediaController.setAnchorView(this.binding.videoView)

    var uri = Uri.parse(
        "android.resource://"
                + packageName + "/" + R.raw.rahul
    )

    binding.videoView.setMediaController(mediaController);
    binding.videoView.setVideoURI(uri)

    binding.videoView.requestFocus()
    binding.videoView.start()





    }
}