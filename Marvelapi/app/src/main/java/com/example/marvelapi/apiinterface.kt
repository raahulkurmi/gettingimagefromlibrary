package com.example.marvelapi

import retrofit2.Call
import retrofit2.http.GET

interface apiinterface {
    @GET("gimme")
    fun getdata(): Call<dataclass>
}