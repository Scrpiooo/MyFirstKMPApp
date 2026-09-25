package org.example.project

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsCount {
    private val _readCount = MutableStateFlow(0)

    val readCount: StateFlow<Int> = _readCount.asStateFlow()

    fun markRead() {
        _readCount.value++
    }
}