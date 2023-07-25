package com.example.dynamicproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<String>  names=new ArrayList<>();
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst=findViewById(R.id.listview);
        String url="https://reqres.in/api/users?page=2";


        AndroidNetworking.initialize(this);
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH).
                build().getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Req",response.toString());
                        try {
                            for(int i=0;i<response.length();i++) {
                                JSONArray jarry = response.getJSONArray("data");
                                JSONObject jsonObject = jarry.getJSONObject(i);
                                String name = jsonObject.getString("name");
                                names.add(name);
                                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.activity_list_item,names);
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