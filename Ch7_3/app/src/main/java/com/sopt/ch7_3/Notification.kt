package com.sopt.ch7_3

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.view.View

class Notification : AppCompatActivity() {

    val notificationId = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
    }

    fun sendNotification(view: View){
        val CHANNEL_ID = "Channel ID"
        val CHANNEL_NAME = "Name of channel"
        val description = "This is channel"
        val importance = NotificationManager.IMPORTANCE_HIGH
        var manager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,importance)
            channel.description = description
            channel.enableLights(true)
            channel.lightColor= Color.RED
            channel.enableVibration(true)
            channel.setShowBadge(false)
            manager.createNotificationChannel(channel)

        }

        var builder = NotificationCompat.Builder(this,CHANNEL_ID)
        builder.setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("A Notification")
                .setContentText("This is an example notification")

        var resultIntent = Intent(this@Notification,ResultActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(this,0,resultIntent,PendingIntent.FLAG_CANCEL_CURRENT)

        builder.setContentIntent(pendingIntent)

        manager.notify(notificationId,builder.build())

    }
}
