package dev.vengateshm.compose.multiplatform.mobile.samples.proper_way_to_inject_context

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun EmailClientApp(modifier: Modifier = Modifier) {
    MaterialTheme {
        KoinContext {
            val emailClient = koinInject<EmailClient>()
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        emailClient.open("Wish", "Hello") {

                        }
                    }
                ) {
                    Text(text = "Open email client")
                }
            }
        }
    }
}