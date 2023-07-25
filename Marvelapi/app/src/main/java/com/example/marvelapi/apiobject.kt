package com.example.marvelapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiobject {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://meme-api.com/").
        addConverterFactory(GsonConverterFactory.create()).
        build()





    }


    val retrofitint by lazy {
        retrofit.create(apiinterface::class.java)
    }
}