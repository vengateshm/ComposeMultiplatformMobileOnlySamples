package dev.vengateshm.compose.multiplatform.mobile.samples.koin.context_binding

import platform.UIKit.UIDevice

actual class AppPlatform {
    actual fun getAppPlatformName(): String {
        return "iOS ${UIDevice.currentDevice.systemVersion}"
    }
}