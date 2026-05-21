package com.bookshelf.android.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bookshelf.repository.AnnotationRepository
import com.bookshelf.repository.PdfRepository
import com.bookshelf.viewmodel.PdfListState
import com.bookshelf.viewmodel.PdfListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class PdfListAndroidViewModel(
    private val repository: PdfRepository,
    private val annotationRepository: AnnotationRepository,
    private val cacheDir: File
) : ViewModel() {

    private val sharedViewModel = PdfListViewModel(repository, annotationRepository)
    val state: StateFlow<PdfListState> = sharedViewModel.state

    fun importPdfFromUri(context: Context, uri: Uri, displayName: String) {
        viewModelScope.launch {
            val localPath = withContext(Dispatchers.IO) {
                copyUriToCache(context, uri)
            } ?: return@launch
            runCatching { repository.addDocument(localPath, displayName) }
        }
    }

    private fun copyUriToCache(context: Context, uri: Uri): String? = runCatching {
        val tempFile = File(cacheDir, "import_${System.currentTimeMillis()}.pdf")
        context.contentResolver.openInputStream(uri)?.use { input ->
            tempFile.outputStream().use { output -> input.copyTo(output) }
        }
        tempFile.absolutePath
    }.getOrNull()

    fun deleteDocument(documentId: String) = sharedViewModel.deleteDocument(documentId)

    override fun onCleared() {
        super.onCleared()
        sharedViewModel.onDestroy()
    }

    class Factory(
        private val repository: PdfRepository,
        private val annotationRepository: AnnotationRepository,
        private val cacheDir: File
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            PdfListAndroidViewModel(repository, annotationRepository, cacheDir) as T
    }
}
