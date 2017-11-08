package com.example.moonc.cse_ru_3_1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by moonc on 11/2/2017.
 */

public class FireBaseMessagingService extends FirebaseMessagingService {


    public static final int Notification_id = 123;
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String from = remoteMessage.getFrom();
        String body;
        if(remoteMessage.getData().size()>0)
        {
            // checkign the data payload
        }

        if(remoteMessage.getNotification()!=null)
        {
            body = remoteMessage.getNotification().getBody();
            showNotifications(from,body);
            //Checking the notification payload
        }


    }

    private void showNotifications(String from, String body) {
        Intent intent = new Intent(this.getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,Notification_id,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification mNotification = builder.setSmallIcon(R.mipmap.louncher)
                .setContentTitle(from)
                .setContentText(body)
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),R.mipmap.louncher))
                .build();

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(Notification_id,mNotification);
    }
}
