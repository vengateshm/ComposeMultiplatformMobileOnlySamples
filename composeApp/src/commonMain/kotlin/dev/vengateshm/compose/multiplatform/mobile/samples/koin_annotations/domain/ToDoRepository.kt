package dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.domain

interface ToDoRepository {
    suspend fun getToDos() : List<String>
}