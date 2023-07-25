package com.example.firebasecloudmessage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("Refreshed",token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        if(message.getNotification()!=null) {
            pushnotification(message.getNotification().getTitle(),
                    message.getNotification().getBody());
        }
    }

    private void pushnotification(String title, String body) {
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channel_id="push";
            CharSequence name="Notification";
            notificationManager.createNotificationChannel(new NotificationChannel(channel_id,name,NotificationManager.IMPORTANCE_HIGH));
            notification=new Notification.Builder(getApplicationContext()).
                    setSmallIcon(R.drawable.ic_launcher_background).
                    setContentTitle(title).setContentIntent(pi).
                    setAutoCancel(true).
                    setSubText(body).
                    build();
        }
        else {
            notification=new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.ic_launcher_background).
                    setContentTitle(title).setContentIntent(pi).setAutoCancel(true).setSubText(body).build();

        }
        if(notificationManager!=null){
            notificationManager.notify(1,notification);
        }


    }


}




