package dev.vengateshm.compose.multiplatform.mobile.samples.color_picker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val PICKED_COLOR = "picked_color"
const val PICKED_COLOR_NAME = "picked_color_name"

@Composable
fun ColorPickerSetResult(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    println("Composition : ColorPickerSetResult")
    NavHost(
        navController = navController,
        startDestination = "main_scr"
    ) {
        composable("main_scr") {

            var pickedColor by remember { mutableStateOf<ColorItem?>(null) }
            println("Composition : $pickedColor")

            LaunchedEffect(navController.currentBackStackEntry) {
                navController.currentBackStackEntry?.savedStateHandle?.let { state ->
                    state.get<Int>(PICKED_COLOR)?.let { colorArgb ->
                        state.get<String>(PICKED_COLOR_NAME)?.let { name ->
                            pickedColor = ColorItem(name = name, color = Color(colorArgb))
                        }
                    }
                }
            }

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
                    navController.previousBackStackEntry?.savedStateHandle?.set(
                        PICKED_COLOR,
                        it.color.toArgb()
                    )
                    navController.previousBackStackEntry?.savedStateHandle?.set(
                        PICKED_COLOR_NAME,
                        it.name
                    )
                    navController.popBackStack()
                }
            )
        }
    }
}