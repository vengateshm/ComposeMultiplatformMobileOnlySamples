package dev.vengateshm.compose.multiplatform.mobile.samples.koin.context_binding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import org.koin.compose.KoinMultiplatformApplication
import org.koin.compose.koinInject
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun KoinContextBindingSample() {
    KoinMultiplatformApplication(
        config = createKoinConfiguration()
    ) {
        MaterialTheme {
            val appPlatform = koinInject<AppPlatform>()

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = appPlatform.getAppPlatformName(),
                    fontSize = 32.sp
                )
            }
        }
    }
}