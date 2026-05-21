package com.bookshelf.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CancellationToken(private val doCancel: () -> Unit) {
    fun cancel() = doCancel()
}

/**
 * Bridges KMP StateFlow to a Swift-friendly callback for use with SwiftUI ObservableObject.
 */
fun <T> StateFlow<T>.observe(onChange: (T) -> Unit): CancellationToken {
    val job = SupervisorJob()
    val scope = CoroutineScope(job + Dispatchers.Main)
    scope.launch {
        collect { value -> onChange(value) }
    }
    return CancellationToken { job.cancel() }
}
