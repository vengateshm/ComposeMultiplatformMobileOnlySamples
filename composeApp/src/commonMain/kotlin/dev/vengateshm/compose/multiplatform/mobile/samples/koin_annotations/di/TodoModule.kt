package dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.di

import dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.data.KtorToDoRepositoryImpl
import dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.domain.ToDoRepository
import dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.presentation.ToDoViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class TodoModule {

    @Factory(binds = [ToDoRepository::class])
    fun todoRepository(@AuthHttpClient httpClient: HttpClient) = KtorToDoRepositoryImpl (httpClient)

    @KoinViewModel
    fun todoViewModel(todoRepository: ToDoRepository) = ToDoViewModel(todoRepository)
}