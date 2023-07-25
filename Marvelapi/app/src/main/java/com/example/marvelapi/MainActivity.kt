package com.example.marvelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.marvelapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getdata()
    }

    private fun getdata() {
        apiobject.retrofitint.getdata().enqueue(object :Callback<dataclass>{
            override fun onResponse(call: Call<dataclass>, response: Response<dataclass>) {
        binding.text.text=response.body()?.title
                Toast.makeText(this@MainActivity, "data fetched", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<dataclass>, t: Throwable) {

            }

        })
    }
}