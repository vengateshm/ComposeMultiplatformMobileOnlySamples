package dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.data

import dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.domain.ToDoRepository
import io.ktor.client.HttpClient

class KtorToDoRepositoryImpl(
    private val httpClient: HttpClient
) : ToDoRepository {
    override suspend fun getToDos(): List<String> {
        return (1..10).map { "Todo $it" }
    }
}