package com.arstkn.lock_screen_activity

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_keep_screen.*

class KeepScreenActivity : AppCompatActivity() {
    private var notificationManager: NotificationManagerCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keep_screen)
        notificationManager = NotificationManagerCompat.from(this)

        stop_activity.setOnClickListener {
            finish()
            notificationManager!!.cancel(1)
        }

        window.addFlags(
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
}
