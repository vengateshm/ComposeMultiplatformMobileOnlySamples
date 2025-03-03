package dev.vengateshm.compose.multiplatform.mobile.samples.native_ios_ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun NativeButton(onClick: () -> Unit, modifier: Modifier = Modifier)