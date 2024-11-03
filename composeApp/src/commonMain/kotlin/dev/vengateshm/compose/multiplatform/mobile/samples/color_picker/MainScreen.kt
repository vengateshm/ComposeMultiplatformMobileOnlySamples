package dev.vengateshm.compose.multiplatform.mobile.samples.color_picker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onOpenColorPickerClick: () -> Unit,
    onClearColor: () -> Unit,
    pickedColor: ColorItem?
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (pickedColor != null) {
            Box(
                modifier = Modifier.size(100.dp)
                    .background(
                        color = pickedColor.color,
                        shape = RoundedCornerShape(8.dp)
                    )
            )
            Spacer(modifier = Modifier.height(height = 16.dp))
            Button(onClick = onOpenColorPickerClick) {
                Text(text = "Pick a color")
            }
            Spacer(modifier = Modifier.height(height = 16.dp))
            Button(onClick = onClearColor) {
                Text(text = "Clear color")
            }
        } else {
            Button(onClick = onOpenColorPickerClick) {
                Text(text = "Pick a color")
            }
        }
    }
}