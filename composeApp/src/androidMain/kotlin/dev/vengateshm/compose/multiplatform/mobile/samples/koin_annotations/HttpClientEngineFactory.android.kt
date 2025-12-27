package dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual class HttpClientEngineFactory {
    actual fun getHttpEngine(): HttpClientEngine {
        return OkHttp.create()
    }
}