package dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            AppModule().module,
            TodoModule().module,
        )
    }
}