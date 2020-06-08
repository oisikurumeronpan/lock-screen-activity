package com.arstkn.lock_screen_activity

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    companion object {
        const val CHANNEL_ID = "keepScreenChannel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Example Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager =
                getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
}