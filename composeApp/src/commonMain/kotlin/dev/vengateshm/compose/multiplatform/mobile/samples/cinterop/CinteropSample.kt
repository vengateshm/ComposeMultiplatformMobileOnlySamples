package dev.vengateshm.compose.multiplatform.mobile.samples.cinterop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.vengateshm.compose.multiplatform.mobile.samples.permissions.sendSms

@Composable
fun CinteropSample(modifier: Modifier = Modifier) {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    sendSms(
                        "123456",
                        "Hello from compose multiplatform mobile app!"
                    )
                }
            ) {
                Text(text = "Open Messaging App")
            }
        }
    }
}