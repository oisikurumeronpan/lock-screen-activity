package com.arstkn.lock_screen_activity

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*
import com.arstkn.lock_screen_activity.App.Companion.CHANNEL_ID

class MainActivity : AppCompatActivity() {
    private var notificationManager: NotificationManagerCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)

        start_activity.setOnClickListener {
            val intent = Intent(this, KeepScreenActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP

            Thread.sleep(5000)
            startActivity(intent)
        }
    }
}