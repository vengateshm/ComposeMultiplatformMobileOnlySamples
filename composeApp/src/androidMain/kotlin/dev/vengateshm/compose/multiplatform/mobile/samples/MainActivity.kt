package dev.vengateshm.compose.multiplatform.mobile.samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import dev.vengateshm.compose.multiplatform.mobile.samples.color_picker.ColorPickerApp
import dev.vengateshm.compose.multiplatform.mobile.samples.color_picker.ColorPickerSetResult
import dev.vengateshm.compose.multiplatform.mobile.samples.horizontal_pager.CharacterApp
import dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui.NativeButtonSample
import dev.vengateshm.compose.multiplatform.mobile.samples.proper_way_to_inject_context.EmailClientApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isChecking = true
        lifecycleScope.launch {
            delay(3000L)
            isChecking = false
        }
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                isChecking
            }
        }
        setContent {
            //PermissionsApp()
            //CinteropSample()
            //CurrentLocationApp()
            //LocationTracking()
            //PlacesAutoComplete()
            //AppAlertDialogSample()
            //CharacterApp()
            //EmailClientApp()
            //ColorPickerApp()
            //ColorPickerSetResult()
            NativeButtonSample()
        }
    }
}