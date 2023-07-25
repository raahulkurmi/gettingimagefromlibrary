package com.example.countrynameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView lst;
ArrayList<String> names=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst =findViewById(R.id.list);
        AndroidNetworking.initialize(this);
                String url="https://reqres.in/api/users?page=2";
                AndroidNetworking.initialize(this);
                AndroidNetworking.get(url).setPriority(Priority.HIGH).
                        build().
                        getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("Res",response.toString());
                                try {
                                    for (int i=0;i<response.length();i++) {
                                        JSONArray jsonArray = response.getJSONArray("data");
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        String name = jsonObject.getString("name");
                                        names.add(name);
                                        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,names);
                                        lst.setAdapter(arrayAdapter);
                                    }
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                            }

                            @Override
                            public void onError(ANError anError) {
                                Log.e("Res",anError.toString());

                            }
                        });


    }
}