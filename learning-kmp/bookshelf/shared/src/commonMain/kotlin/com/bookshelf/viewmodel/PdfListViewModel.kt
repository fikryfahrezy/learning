package com.bookshelf.viewmodel

import com.bookshelf.model.PdfDocument
import com.bookshelf.repository.AnnotationRepository
import com.bookshelf.repository.PdfRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class PdfListState(
    val documents: List<PdfDocument> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)

class PdfListViewModel(
    private val repository: PdfRepository,
    private val annotationRepository: AnnotationRepository
) {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(job + Dispatchers.Main)

    private val _state = MutableStateFlow(PdfListState())
    val state: StateFlow<PdfListState> = _state.asStateFlow()

    init {
        observeDocuments()
    }

    private fun observeDocuments() {
        scope.launch {
            repository.observeDocuments().collect { docs ->
                _state.value = _state.value.copy(documents = docs, isLoading = false)
            }
        }
    }

    fun deleteDocument(documentId: String) {
        scope.launch {
            runCatching {
                repository.deleteDocument(documentId)
                annotationRepository.deleteDocumentAnnotations(documentId)
            }.onFailure { e -> _state.value = _state.value.copy(errorMessage = e.message) }
        }
    }

    fun clearError() {
        _state.value = _state.value.copy(errorMessage = null)
    }

    fun onDestroy() {
        job.cancel()
    }
}
