package dev.vengateshm.compose.multiplatform.mobile.samples.koin.context_binding

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val appPlatformModule = module {
    single<AppPlatform> { AppPlatform(androidContext()) }
}