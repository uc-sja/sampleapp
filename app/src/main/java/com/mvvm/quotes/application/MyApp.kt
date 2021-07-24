package com.mvvm.quotes.application

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import java.util.*

class MyApp : Application() {
    private val TAG = "MyApp"
    init {
        instance = this
    }
    companion object{
        private var instance: MyApp? = null
        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    
    override fun onCreate() {
        super.onCreate()

        val context:Context = MyApp.applicationContext()

        val currentTime: Date = Calendar.getInstance().getTime();
        if(currentTime.hours > 20 || currentTime.hours < 5){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

    }
}