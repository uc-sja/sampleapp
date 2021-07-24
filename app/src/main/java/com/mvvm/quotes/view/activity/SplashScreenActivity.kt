package com.mvvm.quotes.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
   }
}