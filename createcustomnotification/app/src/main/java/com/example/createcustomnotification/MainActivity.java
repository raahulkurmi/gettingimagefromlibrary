package com.example.createcustomnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {
    final private static String Channel_id="Channel_id";
    final private  static int messageid=1;
    final private  static int REQ=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable image= ResourcesCompat.getDrawable(getResources(),R.drawable.new_icon,null);
        BitmapDrawable largeicon=(BitmapDrawable)image;
        assert largeicon != null;
        Bitmap bitmap=largeicon.getBitmap();
        Intent inotify=new Intent(getApplicationContext(),MainActivity.class);

        inotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,REQ,inotify,
                PendingIntent.FLAG_UPDATE_CURRENT |PendingIntent.FLAG_IMMUTABLE );


        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
//Bigpicture notification
        Notification.BigPictureStyle bigPictureStyle=new Notification.BigPictureStyle().
                bigPicture(bitmap).
              bigLargeIcon(bitmap).
                setBigContentTitle("Image sent by Rahul").
                setSummaryText("Image message");

        Notification.InboxStyle inboxStyle =new Notification.InboxStyle().
        addLine("A").
                addLine("A").
                addLine("B").
                addLine("c").
                addLine("D").
                addLine("e").
                addLine("f").
                addLine("g").
                addLine("h").
                setBigContentTitle("Full message").
                setSummaryText("Message from raman");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification=new Notification.Builder(getApplicationContext()).
                    setLargeIcon(bitmap).
                    setSmallIcon(R.drawable.new_icon).
                    setContentText("Are you okaay?").
                    setChannelId(Channel_id).
                    setStyle(inboxStyle).
                    setStyle(bigPictureStyle).
                    setAutoCancel(false).
                    setOngoing(true).
                    setContentIntent(pendingIntent).
                    setSubText("You have a message from Rahul").
                    build();
            nm.createNotificationChannel(new NotificationChannel(Channel_id,
                    "New Message",
                    NotificationManager.IMPORTANCE_HIGH));
        }else {

               notification=new Notification.Builder(this).
                        setLargeIcon(bitmap).
                        setSmallIcon(R.drawable.new_icon).
                        setContentText("Are you okaay?").
                       setContentIntent(pendingIntent).

                       setStyle(bigPictureStyle).
                       setStyle(inboxStyle).
                       setAutoCancel(false).
                       setOngoing(true).
                        setSubText("You have a message from Rahul").
                        build();
            }


nm.notify(messageid,notification);
        }

    }
