package dev.vengateshm.compose.multiplatform.mobile.samples

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        lateinit var appContext: Context
        fun getApplicationContext(): Context = appContext
    }
}