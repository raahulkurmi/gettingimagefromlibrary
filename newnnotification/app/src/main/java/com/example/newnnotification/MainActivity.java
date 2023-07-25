package com.example.newnnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private  static final String channel_id="welcome";
    private  static final int message_id=1;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NotificationManager nn=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification=new Notification.Builder(this).
                    setSubText("New message").
                    setContentText("You have a message from Rahul").
                    setChannelId(channel_id).
                    build();
            nn.createNotificationChannel(new NotificationChannel(channel_id,"new message",NotificationManager.IMPORTANCE_HIGH));
        }else{
            notification=new Notification.Builder(this).
                    setSubText("New message").
                    setContentText("You have a message from Rahul").

                    build();

        }
        nn.notify(message_id,notification);


    }
}