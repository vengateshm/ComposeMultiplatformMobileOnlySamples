package dev.vengateshm.compose.multiplatform.mobile.samples

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import dev.vengateshm.compose.multiplatform.mobile.samples.cinterop.CinteropSample
import dev.vengateshm.compose.multiplatform.mobile.samples.di.initializeKoin
import dev.vengateshm.compose.multiplatform.mobile.samples.horizontal_pager.CharacterApp
import dev.vengateshm.compose.multiplatform.mobile.samples.location.CurrentLocationApp
import dev.vengateshm.compose.multiplatform.mobile.samples.location.LocationTracking
import dev.vengateshm.compose.multiplatform.mobile.samples.location.PlacesAutoComplete
import dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui.AppAlertDialogSample
import dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui.LocalNativeViewFactory
import dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui.NativeButtonSample
import dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui.NativeViewFactory
import dev.vengateshm.compose.multiplatform.mobile.samples.permissions.PermissionsApp

fun MainViewController(
    nativeViewFactory: NativeViewFactory
) = ComposeUIViewController(
    configure = {
        initializeKoin()
    }
) {
    //PermissionsApp()
    //CinteropSample()
    //CurrentLocationApp()
    //LocationTracking()
    //PlacesAutoComplete()
    //AppAlertDialogSample()
    //CharacterApp()
    CompositionLocalProvider(LocalNativeViewFactory provides nativeViewFactory) {
        NativeButtonSample()
    }
}