package dev.vengateshm.compose.multiplatform.mobile.samples.koin.context_binding

import android.content.Context
import android.os.Build

actual class AppPlatform(private val context: Context) {
    actual fun getAppPlatformName(): String {
        return "Android - ${Build.VERSION.SDK_INT} ${context.packageName}"
    }
}