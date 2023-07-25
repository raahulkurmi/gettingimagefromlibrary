package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Apiinterface apiinterface;
    RecyclerView recyclerView;
    ArrayList<layout>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleview);

        apiinterface=Retrfoitinstance.getRetrofit().create(Apiinterface.class);
        apiinterface.getpost().enqueue(new Callback<List<postpojo>>() {
            @Override
            public void onResponse(Call<List<postpojo>> call, Response<List<postpojo>> response) {
                if(response.body().size()>0){
                    List<postpojo> postpojo=response.body();


                    Toast.makeText(MainActivity.this, "Text is not empty", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Text is empty", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<postpojo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}