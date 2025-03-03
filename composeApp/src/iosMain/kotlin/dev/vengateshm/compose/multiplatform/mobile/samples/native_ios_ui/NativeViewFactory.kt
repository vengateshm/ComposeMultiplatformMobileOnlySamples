package dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui

import androidx.compose.runtime.staticCompositionLocalOf
import platform.UIKit.UIViewController

interface NativeViewFactory {
    fun createButtonView(
        label: String,
        onClick: () -> Unit
    ): UIViewController
}

val LocalNativeViewFactory = staticCompositionLocalOf<NativeViewFactory> {
    error("No view factory provided")
}