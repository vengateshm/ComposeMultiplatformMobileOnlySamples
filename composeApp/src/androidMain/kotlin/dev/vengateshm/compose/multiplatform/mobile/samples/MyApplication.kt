package dev.vengateshm.compose.multiplatform.mobile.samples

import android.app.Application
import android.content.Context
import dev.vengateshm.compose.multiplatform.mobile.samples.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
        initializeKoin {
            androidContext(this@MyApplication)
        }
    }

    companion object {
        lateinit var appContext: Context
        fun getApplicationContext(): Context = appContext
    }
}