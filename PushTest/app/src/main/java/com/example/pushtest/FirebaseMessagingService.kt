package com.example.pushtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagingService : FirebaseMessagingService() {

    val TAG: String = "로그"
    lateinit var title:String
    lateinit var msg:String

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "FirebaseInstanceIDService - onNewToken() called")
//        sendRegistrationToServer(token)
    }

//    private fun sendRegistrationToServer(token: String) {
//
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        title = message.notification?.title.toString()
        msg = message.notification?.body.toString()

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

        val pendingIntent : PendingIntent = PendingIntent.getActivity(
            this,0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        Log.d(TAG, "FirebaseMessagingService - onMessageReceived() called2")
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager

        Log.d(TAG, "FirebaseMessagingService - onMessageReceived() called3")
        val channel = NotificationChannel("channelId", "channelName",IMPORTANCE_HIGH).apply {
            description = "Channel Description"
            enableLights(true)
            lightColor = Color.GREEN
        }
        Log.d(TAG, "FirebaseMessagingService - onMessageReceived() called4")

        notificationManager.createNotificationChannel(channel)

        Log.d(TAG, "FirebaseMessagingService - onMessageReceived() called5")

        val mBuilder : NotificationCompat.Builder = NotificationCompat.Builder(this, channel.id).setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle(title)
            .setContentText(msg)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))

        Log.d(TAG, "FirebaseMessagingService - onMessageReceived() called6")
        notificationManager.notify(0, mBuilder.build())

        Log.d(TAG, "FirebaseMessagingService - onMessageReceived() called7")

        mBuilder.setContentIntent(pendingIntent)
    }
}