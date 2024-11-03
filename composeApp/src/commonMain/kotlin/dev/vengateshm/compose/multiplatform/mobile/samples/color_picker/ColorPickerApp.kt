package dev.vengateshm.compose.multiplatform.mobile.samples.color_picker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ColorPickerApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var pickedColor by remember { mutableStateOf<ColorItem?>(null) }
    println("Composition : $pickedColor")

    NavHost(
        navController = navController,
        startDestination = "main_scr"
    ) {
        composable("main_scr") {
            MainScreen(
                onOpenColorPickerClick = {
                    navController.navigate("picker_scr")
                },
                onClearColor = {
                    pickedColor = null
                },
                pickedColor = pickedColor
            )
        }
        composable("picker_scr") {
            PickerScreen(
                onColorPicked = {
                    pickedColor = it
                    navController.popBackStack()
                }
            )
        }
    }
}