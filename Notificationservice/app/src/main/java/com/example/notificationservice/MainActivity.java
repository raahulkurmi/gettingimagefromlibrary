package com.example.notificationservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    private static final String Channel_id="channelid";
    private static final int Notification_id=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable image= ResourcesCompat.getDrawable(getResources(), R.drawable.newicon,null);
        BitmapDrawable largeicon=(BitmapDrawable) image;
        assert largeicon != null;
        Bitmap icon=largeicon.getBitmap();


        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification=new Notification.Builder(getApplicationContext()).
                    setLargeIcon(icon).
                    setSmallIcon(R.drawable.newicon).
                    setContentText("You have a message from Rahul").
                    setChannelId(Channel_id).
                    setSubText("New Message").build();
             nm.createNotificationChannel(new NotificationChannel(Channel_id,"new message",NotificationManager.IMPORTANCE_HIGH));
        }else {
            notification=new Notification.Builder(getApplicationContext()).
                    setLargeIcon(icon).
                    setSmallIcon(R.drawable.newicon).
                    setContentText("You have a message from Rahul").

                    setSubText("New Message").build();
        }
      nm.notify(Notification_id,notification);
    }
}