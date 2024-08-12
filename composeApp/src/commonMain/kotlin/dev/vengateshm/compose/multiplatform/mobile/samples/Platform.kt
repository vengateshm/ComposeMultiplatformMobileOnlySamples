package dev.vengateshm.compose.multiplatform.mobile.samples

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform