package com.arstkn.lock_screen_activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_activity.setOnClickListener {
            val intent = Intent(this, KeepScreenActivity::class.java)
            startActivity(intent)
        }
    }
}