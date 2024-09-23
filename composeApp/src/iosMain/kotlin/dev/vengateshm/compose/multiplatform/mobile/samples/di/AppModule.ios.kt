package dev.vengateshm.compose.multiplatform.mobile.samples.di

import dev.vengateshm.compose.multiplatform.mobile.samples.proper_way_to_inject_context.EmailClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val appModule = module {
//    single { EmailClient() }
    singleOf(::EmailClient)
}