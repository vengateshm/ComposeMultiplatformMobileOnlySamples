package dev.vengateshm.compose.multiplatform.mobile.samples.horizontal_pager

import androidx.compose.ui.graphics.Color
import composemultiplatformmobilesamples.composeapp.generated.resources.Res
import composemultiplatformmobilesamples.composeapp.generated.resources.harry
import composemultiplatformmobilesamples.composeapp.generated.resources.hermione
import composemultiplatformmobilesamples.composeapp.generated.resources.ron
import org.jetbrains.compose.resources.DrawableResource
import kotlin.random.Random

data class Character(
    val id: Int,
    val name: String,
    val species: Species = Species.HUMAN,
    val photo: DrawableResource,
    val bgColor: Color = Color.LightGray
)

enum class Species {
    HUMAN
}

val characters by lazy {
    listOf(
        Character(
            id = 1,
            name = "Harry",
            photo = Res.drawable.harry,
        ),
        Character(
            id = 2,
            name = "Hermione",
            photo = Res.drawable.hermione,
        ),
        Character(
            id = 3,
            name = "Ron",
            photo = Res.drawable.ron,
        )
    )
}