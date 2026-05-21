package com.bookshelf.viewmodel

import com.bookshelf.model.AnnotationStroke
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

data class PdfReaderState(
    val document: PdfDocument? = null,
    val currentPageIndex: Int = 0,
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val pageStrokes: List<AnnotationStroke> = emptyList(),
    val isAnnotating: Boolean = false,
    val penColor: String = "#FFFF0000",
    val penWidth: Float = 4f
) {
    val currentPage: Int get() = currentPageIndex + 1
    val totalPages: Int get() = document?.pageCount ?: 0
    val canGoPrevious: Boolean get() = currentPageIndex > 0
    val canGoNext: Boolean get() = currentPageIndex < (totalPages - 1)
    val progress: Float
        get() = if (totalPages == 0) 0f else currentPage.toFloat() / totalPages.toFloat()
}

class PdfReaderViewModel(
    private val repository: PdfRepository,
    private val annotationRepository: AnnotationRepository,
    private val documentId: String
) {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(job + Dispatchers.Main)

    private val _state = MutableStateFlow(PdfReaderState())
    val state: StateFlow<PdfReaderState> = _state.asStateFlow()

    init {
        loadDocument()
    }

    private fun loadDocument() {
        scope.launch {
            val document = repository.getDocument(documentId)
            _state.value = if (document != null) {
                _state.value.copy(document = document, isLoading = false)
            } else {
                _state.value.copy(errorMessage = "Document not found", isLoading = false)
            }
            if (document != null) loadPageAnnotations(0)
        }
    }

    private fun loadPageAnnotations(pageIndex: Int) {
        scope.launch {
            val strokes = annotationRepository.loadPageStrokes(documentId, pageIndex)
            _state.value = _state.value.copy(pageStrokes = strokes)
        }
    }

    private fun saveCurrentPageStrokes(strokes: List<AnnotationStroke>) {
        scope.launch {
            annotationRepository.savePageStrokes(documentId, _state.value.currentPageIndex, strokes)
        }
    }

    fun jumpToPage(pageIndex: Int) {
        val totalPages = _state.value.document?.pageCount ?: return
        val clamped = pageIndex.coerceIn(0, totalPages - 1)
        _state.value = _state.value.copy(currentPageIndex = clamped, pageStrokes = emptyList())
        loadPageAnnotations(clamped)
    }

    fun nextPage() {
        if (_state.value.canGoNext) {
            val newIndex = _state.value.currentPageIndex + 1
            _state.value = _state.value.copy(currentPageIndex = newIndex, pageStrokes = emptyList())
            loadPageAnnotations(newIndex)
        }
    }

    fun previousPage() {
        if (_state.value.canGoPrevious) {
            val newIndex = _state.value.currentPageIndex - 1
            _state.value = _state.value.copy(currentPageIndex = newIndex, pageStrokes = emptyList())
            loadPageAnnotations(newIndex)
        }
    }

    fun toggleAnnotationMode() {
        _state.value = _state.value.copy(isAnnotating = !_state.value.isAnnotating)
    }

    fun setPenColor(colorHex: String) {
        _state.value = _state.value.copy(penColor = colorHex)
    }

    fun setPenWidth(width: Float) {
        _state.value = _state.value.copy(penWidth = width)
    }

    fun addStroke(stroke: AnnotationStroke) {
        val newStrokes = _state.value.pageStrokes + stroke
        _state.value = _state.value.copy(pageStrokes = newStrokes)
        saveCurrentPageStrokes(newStrokes)
    }

    fun undoLastStroke() {
        if (_state.value.pageStrokes.isEmpty()) return
        val newStrokes = _state.value.pageStrokes.dropLast(1)
        _state.value = _state.value.copy(pageStrokes = newStrokes)
        saveCurrentPageStrokes(newStrokes)
    }

    fun clearPageAnnotations() {
        _state.value = _state.value.copy(pageStrokes = emptyList())
        saveCurrentPageStrokes(emptyList())
    }

    fun clearError() {
        _state.value = _state.value.copy(errorMessage = null)
    }

    fun onDestroy() {
        job.cancel()
    }
}
