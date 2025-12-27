package dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.di

import dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.HttpClientEngineFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
class AppModule {

    @Single
    @AuthHttpClient
    fun authHttpClient(engine: HttpClientEngine): HttpClient = HttpClient(engine) {

    }

    @Single
    @NoAuthHttpClient
    fun noAuthHttpClient(engine: HttpClientEngine): HttpClient = HttpClient(engine) {

    }

    @Factory
    fun httpClientEngine() = HttpClientEngineFactory().getHttpEngine()
}

@Named
public annotation class AuthHttpClient

@Named
public annotation class NoAuthHttpClient