package dev.vengateshm.compose.multiplatform.mobile.samples.koin.context_binding

import org.koin.dsl.module

actual val appPlatformModule = module {
    single<AppPlatform> { AppPlatform() }
}