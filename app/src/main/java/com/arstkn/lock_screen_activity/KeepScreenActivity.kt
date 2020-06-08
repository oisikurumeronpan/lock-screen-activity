package com.arstkn.lock_screen_activity

import android.app.NotificationManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_keep_screen.*

class KeepScreenActivity : AppCompatActivity() {
    private var notificationManager: NotificationManagerCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("KeepScreenActivity", "onCreate start")

        setContentView(R.layout.activity_keep_screen)
        notificationManager = NotificationManagerCompat.from(this)

        val service = Intent(this, NotificationService::class.java)
        startForegroundService(service)

        stop_activity.setOnClickListener {
            stopService(service)

            finishAndRemoveTask()
        }

        window.addFlags(
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
}
