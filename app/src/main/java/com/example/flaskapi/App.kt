package com.example.flaskapi

import android.app.Application
import android.content.Context
import java.lang.RuntimeException

class App : Application() {

    companion object {
        var context: Context? = null
        var INSTANCE: App? = null

        val instance: App
            get() {
                if (INSTANCE == null) {
                    throw RuntimeException("instance is null")
                }
                return INSTANCE as App
            }
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        Companion.context = this
    }
}