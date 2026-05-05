package com.example.antokeberapps.Pertemuan_6

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.antokeberapps.MainActivity
import com.example.antokeberapps.R
import com.example.antokeberapps.pertemuan_3.ThrdActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({

            if (isLogin) {
                startActivity(Intent(this, com.example.antokeberapps.pertemuan_4.DashboardActivity::class.java))
            } else {
                startActivity(Intent(this, com.example.antokeberapps.pertemuan_3.ThrdActivity::class.java))
            }

            finish()

        }, 2000)
    }
}