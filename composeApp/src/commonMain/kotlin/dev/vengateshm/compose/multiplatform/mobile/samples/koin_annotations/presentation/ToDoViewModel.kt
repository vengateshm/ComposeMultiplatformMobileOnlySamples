package dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.compose.multiplatform.mobile.samples.koin_annotations.domain.ToDoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ToDoViewModel(private val toDoRepository: ToDoRepository) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<String>())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val todos = toDoRepository.getToDos()
            _state.update {
                todos
            }
        }
    }
}