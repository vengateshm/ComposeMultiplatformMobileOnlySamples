package dev.vengateshm.compose.multiplatform.mobile.samples.deeplinking

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    @Serializable
    data object List : Route

    @Serializable
    data class Detail(val id: Int) : Route
}