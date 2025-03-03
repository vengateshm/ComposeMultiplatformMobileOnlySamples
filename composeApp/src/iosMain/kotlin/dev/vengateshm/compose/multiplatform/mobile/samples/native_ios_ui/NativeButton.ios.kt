package dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.UIKitViewController

@Composable
actual fun NativeButton(onClick: () -> Unit, modifier: Modifier) {
    val factory = LocalNativeViewFactory.current
    UIKitViewController(
        modifier = modifier
            .width(100.dp)
            .height(50.dp),
        factory = {
            factory.createButtonView(
                label = "IOS Button",
                onClick = onClick
            )
        }
    )
}