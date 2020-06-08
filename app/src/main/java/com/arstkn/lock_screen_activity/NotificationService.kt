package com.arstkn.lock_screen_activity

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.IBinder
import androidx.core.app.NotificationCompat

class NotificationService : Service() {
    private var player: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()

        val intent = Intent(this, KeepScreenActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(this, App.CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_menu_call)
            .setContentTitle("start KeepScreenActivity!!")
            .setContentText("content text")
            .setPriority(NotificationCompat.PRIORITY_MIN)
            .setFullScreenIntent(pendingIntent, true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setWhen(System.currentTimeMillis())

        startForeground(1, notification.build())
        startRing()
    }

    private fun startRing() {
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        player = MediaPlayer.create(this, uri)

        player?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
