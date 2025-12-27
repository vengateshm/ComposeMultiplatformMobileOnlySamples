package dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations

import io.ktor.client.engine.HttpClientEngine


expect class HttpClientEngineFactory() {
    fun getHttpEngine(): HttpClientEngine
}