package com.example.accelermometersensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimeZone;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        if (!(sensorManager != null)) {
            Sensor accelorosensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(accelorosensor!=null){
               sensorManager.registerListener(this,accelorosensor,sensorManager.SENSOR_DELAY_NORMAL);

            }

        }
        else {
            Toast.makeText(this,"Sensor not deteced",Toast.LENGTH_SHORT).show();
        }
    }

    @Override 
    public void onSensorChanged(SensorEvent sensorEvent) {
         if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
             ((TextView)findViewById(R.id.senorvalue)).setText("X :"+sensorEvent.values[0]+" ,Y : "+sensorEvent.values[1]+" ,z : "+sensorEvent.values[2 ]);
         }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}