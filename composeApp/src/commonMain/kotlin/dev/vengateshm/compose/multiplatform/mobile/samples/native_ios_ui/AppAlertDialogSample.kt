package dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppAlertDialogSample(modifier: Modifier = Modifier) {
    MaterialTheme {
        var showDialog by remember { mutableStateOf(false) }
        if (showDialog) {
            Box(modifier = Modifier.fillMaxSize()) {
                AppAlertDialog(
                    modifier = Modifier.fillMaxWidth().padding(4.dp).align(Alignment.Center),
                    onDismissRequest = {
                        showDialog = false
                    }
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextButton(
                onClick = {
                    showDialog = true
                }
            ) {
                Text(text = "Show Alert", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}