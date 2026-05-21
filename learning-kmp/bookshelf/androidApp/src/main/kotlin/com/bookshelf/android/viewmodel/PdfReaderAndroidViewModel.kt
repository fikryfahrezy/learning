package com.bookshelf.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bookshelf.model.AnnotationStroke
import com.bookshelf.repository.AnnotationRepository
import com.bookshelf.repository.PdfRepository
import com.bookshelf.viewmodel.PdfReaderState
import com.bookshelf.viewmodel.PdfReaderViewModel
import kotlinx.coroutines.flow.StateFlow

class PdfReaderAndroidViewModel(
    repository: PdfRepository,
    annotationRepository: AnnotationRepository,
    documentId: String
) : ViewModel() {

    private val sharedViewModel = PdfReaderViewModel(repository, annotationRepository, documentId)
    val state: StateFlow<PdfReaderState> = sharedViewModel.state

    fun jumpToPage(pageIndex: Int) = sharedViewModel.jumpToPage(pageIndex)
    fun nextPage() = sharedViewModel.nextPage()
    fun previousPage() = sharedViewModel.previousPage()
    fun toggleAnnotationMode() = sharedViewModel.toggleAnnotationMode()
    fun setPenColor(colorHex: String) = sharedViewModel.setPenColor(colorHex)
    fun setPenWidth(width: Float) = sharedViewModel.setPenWidth(width)
    fun addStroke(stroke: AnnotationStroke) = sharedViewModel.addStroke(stroke)
    fun undoLastStroke() = sharedViewModel.undoLastStroke()
    fun clearPageAnnotations() = sharedViewModel.clearPageAnnotations()

    override fun onCleared() {
        super.onCleared()
        sharedViewModel.onDestroy()
    }

    class Factory(
        private val repository: PdfRepository,
        private val annotationRepository: AnnotationRepository,
        private val documentId: String
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            PdfReaderAndroidViewModel(repository, annotationRepository, documentId) as T
    }
}
