package com.example.project;

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
    final String channel_id = "pushnotification";

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("Refreshed token", token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        if (message.getNotification() != null) {
            pushnotification(message.getNotification().getTitle(),
                    message.getNotification().getBody());
        }
    }

    private void pushnotification(String title, String Msg) {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        final String channel_id = "push_noti";
        Intent inotify = new Intent(this, MainActivity.class);
        inotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivity(this, 100, inotify, PendingIntent.FLAG_UPDATE_CURRENT);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            CharSequence name = "Custom channel";
            String description = "channel for push notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channel_id, name, importance);
            channel.setDescription(description);
            if (nm != null) {
                nm.createNotificationChannel(channel);
                notification = new Notification.Builder(this).setSmallIcon(R.drawable.google).
                        setContentIntent(pi).
                        setContentTitle(title).
                        setSubText(Msg).setAutoCancel(true).build();
            } else {
                notification = new Notification.Builder(this).
                        setSmallIcon(R.drawable.google).setContentIntent(pi).
                        setContentTitle(title).
                        setAutoCancel(true).
                        setSubText(Msg).

                        build();
            }
            if (nm != null) {
                nm.notify(1, notification);
            }

        }
    }
}
