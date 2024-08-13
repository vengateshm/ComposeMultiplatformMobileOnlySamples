package dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun AppAlertDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit
) {
    UIKitAlertDialog(modifier = modifier, onDismissRequest = onDismissRequest)
}