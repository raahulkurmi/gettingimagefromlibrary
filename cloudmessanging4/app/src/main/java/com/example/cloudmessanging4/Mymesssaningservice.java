package com.example.cloudmessanging4;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.nio.channels.Channel;
import java.util.Objects;

public class Mymesssaningservice extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("Refreshed",token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        if (message.getNotification() != null) {
            pushnotification(Objects.requireNonNull(message.getNotification()).getTitle(),
                    message.getNotification().getBody());
        }
    }

    private void pushnotification(String title,String message) {

        Intent inotify=new Intent(this,MainActivity.class);
        inotify.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,inotify,PendingIntent.FLAG_UPDATE_CURRENT);



        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        String channel_id="push";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           String description="Push notification from cloud";
            CharSequence name="Push notifcaitoin";
            int importance=NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel=new NotificationChannel(channel_id,name,importance);
            channel.setDescription(description);
            nm.createNotificationChannel(channel);
            notification=new Notification.Builder(this).setSmallIcon(R.drawable.ic_launcher_background).
                    setContentTitle(title).setContentTitle(message).
                    setContentIntent(pi).
                    build();

        }
        else {
            notification=new Notification.Builder(this).
                    setSmallIcon(R.drawable.ic_launcher_background).
                    setContentTitle(title).
                    setContentTitle(message).
                    setContentIntent(pi).
                    build();

         }

        if(nm!=null){
    nm.notify(1,notification);
        }
     }
    }
