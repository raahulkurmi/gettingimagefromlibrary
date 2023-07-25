package com.example.notifiactionmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String channel_id="message_chaneel";
    private static final int notificationid=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.newicon, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeicon = bitmapDrawable.getBitmap();


        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this).
                    setLargeIcon(largeicon).
                    setSmallIcon(R.drawable.newicon).
                    setContentText("New message").
                    setSubText("New message from Raman")
                    .setChannelId(channel_id)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(channel_id,"new message",NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification=new Notification.Builder(this).
            setLargeIcon(largeicon).
                    setSmallIcon(R.drawable.newicon).
                    setContentText("New message").
                    setSubText("New message from Raman")

                    .build();

        }
       nm.notify(notificationid,notification);

    }


}