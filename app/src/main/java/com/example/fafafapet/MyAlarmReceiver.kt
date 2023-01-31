package com.example.fafafapet

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService

class MyAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val notificationId = 30103
        val CHANNEL_ID = "notification_channel_id"
        val name = "ON/OFF"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val nNotifyChannel = NotificationChannel(CHANNEL_ID, name, importance)
        val mBuilder = NotificationCompat.Builder(context !!, CHANNEL_ID)
            .setSmallIcon(R.drawable.logoandroid)
            .setContentText("Anda dapat melakukan Konsultasi dengan Dokter")
            .setContentTitle("Pengingat Konsultasi")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        var mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        for (s in mNotificationManager.notificationChannels){
            mNotificationManager.deleteNotificationChannel(s.id)
        }

        mNotificationManager.createNotificationChannel(nNotifyChannel)
        mNotificationManager.notify(notificationId, mBuilder.build())

    }
}