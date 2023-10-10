package com.example.appbase

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class BaseApplication : Application() {

    companion object {
        lateinit var instance: Application
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

    }
}