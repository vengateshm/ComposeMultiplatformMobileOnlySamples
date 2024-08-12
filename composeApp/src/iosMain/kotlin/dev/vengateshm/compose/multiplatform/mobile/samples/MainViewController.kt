package dev.vengateshm.compose.multiplatform.mobile.samples

import androidx.compose.ui.window.ComposeUIViewController
import dev.vengateshm.compose.multiplatform.mobile.samples.cinterop.CinteropSample
import dev.vengateshm.compose.multiplatform.mobile.samples.location.CurrentLocationApp
import dev.vengateshm.compose.multiplatform.mobile.samples.permissions.PermissionsApp

fun MainViewController() = ComposeUIViewController {
    //PermissionsApp()
    //CinteropSample()
    CurrentLocationApp()
}