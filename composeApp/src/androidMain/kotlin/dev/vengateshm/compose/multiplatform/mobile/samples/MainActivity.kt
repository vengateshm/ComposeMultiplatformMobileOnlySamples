package dev.vengateshm.compose.multiplatform.mobile.samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.vengateshm.compose.multiplatform.mobile.samples.cinterop.CinteropSample
import dev.vengateshm.compose.multiplatform.mobile.samples.location.CurrentLocationApp
import dev.vengateshm.compose.multiplatform.mobile.samples.permissions.PermissionsApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //PermissionsApp()
            //CinteropSample()
            CurrentLocationApp()
        }
    }
}