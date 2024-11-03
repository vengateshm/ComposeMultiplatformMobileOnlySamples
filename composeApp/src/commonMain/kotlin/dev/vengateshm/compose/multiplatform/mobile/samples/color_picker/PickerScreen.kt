package dev.vengateshm.compose.multiplatform.mobile.samples.color_picker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PickerScreen(modifier: Modifier = Modifier, onColorPicked: (ColorItem) -> Unit) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        items(colorList) { colorItem ->
            ColorListItem(
                modifier = Modifier.clickable {
                    onColorPicked(colorItem)
                },
                colorItem = colorItem
            )
        }
    }
}

@Composable
fun ColorListItem(
    modifier: Modifier = Modifier,
    colorItem: ColorItem
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier.size(100.dp)
                .background(
                    color = colorItem.color,
                    shape = RoundedCornerShape(8.dp)
                )
        )
        Spacer(modifier = Modifier.width(width = 16.dp))
        Text(text = colorItem.name)
    }
}