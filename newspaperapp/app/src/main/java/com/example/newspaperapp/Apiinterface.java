package com.example.newspaperapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public abstract class Apiinterface {
    static String BASE_URL="https://newsapi.org/v2/";
    @GET("top-headlines")
    abstract Call<mainnews> getNews(
            @Query("country") String country,
            @Query("pagesize") int size,
            @Query("apikey") String apikey


    );
    abstract Call<mainnews> getcatergoryNews(
            @Query("country") String country,
            @Query("pagesize") int size,
            @Query("category") String category,

            @Query("apikey") String apikey


    );
}
