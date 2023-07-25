package com.example.postapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> names=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(this);
        AndroidNetworking.post("https://api.instantwebtools.net/v1/airlines").

                addBodyParameter("id","1").setPriority(Priority.HIGH).
                build().getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Res", response.toString());
                        JSONObject jsonObject= null;
                        try {
                            jsonObject = response.getJSONObject(1);
                            String name=jsonObject.getString("name");
                            names.add(name);
                            Log.d("name",name);


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