package dev.vengateshm.compose.multiplatform.mobile.samples.koin.context_binding

import org.koin.core.module.Module
import org.koin.dsl.KoinConfiguration

expect val appPlatformModule: Module

fun createKoinConfiguration(): KoinConfiguration {
    return KoinConfiguration {
        modules(appPlatformModule)
    }
}