package com.example.todo_pt

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.UUID

class TodoViewModel: ViewModel() {
    private var _todos = mutableStateOf<List<TodoItem>>(emptyList())
    val todos: State<List<TodoItem>> = _todos

    fun addTodo(title: String, description: String) {
        val todo = TodoItem(
            id = UUID.randomUUID().toString(),
            title = title,
            description = description
        )

        _todos.value += todo
    }
}