package com.example.cloudmessanging2;

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

import java.util.Objects;

public class Mymessangingservice extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("token",token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        pushnotification(Objects.requireNonNull(message.getNotification()).getBody() ,
                message.getNotification().getTitle());
    }

    private void pushnotification(String titile,String message) {
        final String chanell_id="push";
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification=new Notification.Builder(this).
                    setSmallIcon(R.drawable.ic_launcher_background).setContentTitle(titile).
                    setSubText(message).
                    setContentIntent(pi).
                    setAutoCancel(true).build();
            notificationManager.createNotificationChannel(new NotificationChannel(chanell_id,"push notifciation",NotificationManager.IMPORTANCE_HIGH));
        }else {
            notification=new Notification.Builder(this).
                    setSmallIcon(R.drawable.ic_launcher_background).setContentTitle(titile).
                    setSubText(message).
                    setContentIntent(pi).
                    setAutoCancel(true).build();

        }
        if(notificationManager!=null){
            notificationManager.notify(1,notification);
        }

    }
}
