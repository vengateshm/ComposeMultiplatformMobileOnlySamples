package dev.vengateshm.compose.multiplatform.mobile.samples

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}