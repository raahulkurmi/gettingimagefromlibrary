package com.example.alarammanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
static int Alarm_service=10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.timeinsec);
        button=findViewById(R.id.setalaram);

        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int time=Integer.parseInt(editText.getText().toString());
              long trigger=System.currentTimeMillis()+(time* 1000);
              Intent ibroadcast=new Intent(getApplicationContext(),Myreciever.class);
              PendingIntent pendingIntent;
              pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                      Alarm_service, ibroadcast, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

              alarmManager.set(AlarmManager.RTC_WAKEUP,trigger,pendingIntent);


          }
      });
    }
}