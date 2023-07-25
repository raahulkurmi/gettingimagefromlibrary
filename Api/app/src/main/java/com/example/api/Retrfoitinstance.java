package com.example.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrfoitinstance {
    private  static Retrofit retrofit;
    private static final String baseurl="https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit=new Retrofit.Builder().
                    baseUrl(baseurl).
                    addConverterFactory(GsonConverterFactory.
                            create())
                    .build();
        }
        return retrofit;
    }
}
