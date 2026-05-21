package com.bookshelf.repository

import com.bookshelf.model.PdfDocument
import com.bookshelf.renderer.PdfPageRenderer
import com.bookshelf.util.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SharedPdfRepository(private val storageDirectory: String) : PdfRepository {

    private val pdfDirectory = "$storageDirectory/pdfs"
    private val metadataFile = "$storageDirectory/library.json"
    private val _documents = MutableStateFlow<List<PdfDocument>>(emptyList())
    private val json = Json { prettyPrint = true; ignoreUnknownKeys = true }
    private var idCounter = 0L

    init {
        createDirectories(pdfDirectory)
        loadDocuments()
    }

    private fun loadDocuments() {
        val content = readTextFile(metadataFile) ?: return
        runCatching {
            _documents.value = json.decodeFromString<List<PdfDocument>>(content)
        }
    }

    private fun saveDocuments() {
        writeTextFile(metadataFile, json.encodeToString(_documents.value))
    }

    override fun observeDocuments(): Flow<List<PdfDocument>> = _documents.asStateFlow()

    override suspend fun addDocument(localFilePath: String, displayName: String): PdfDocument {
        val id = "doc_${currentTimeMillis()}_${idCounter++}"
        val destPath = "$pdfDirectory/$id.pdf"

        check(copyFile(localFilePath, destPath)) { "Failed to copy PDF to storage" }

        val pageCount = runCatching {
            val renderer = PdfPageRenderer(destPath)
            val count = renderer.pageCount
            renderer.close()
            count
        }.getOrDefault(0)

        val document = PdfDocument(
            id = id,
            title = displayName,
            filePath = destPath,
            pageCount = pageCount,
            fileSizeBytes = getFileSize(destPath),
            importedAt = currentTimeMillis()
        )

        _documents.value = _documents.value + document
        saveDocuments()
        return document
    }

    override suspend fun deleteDocument(documentId: String) {
        val doc = _documents.value.find { it.id == documentId }
            ?: throw IllegalArgumentException("Document not found: $documentId")
        deleteFile(doc.filePath)
        _documents.value = _documents.value.filter { it.id != documentId }
        saveDocuments()
    }

    override suspend fun getDocument(documentId: String): PdfDocument? =
        _documents.value.find { it.id == documentId }

    override suspend fun renderThumbnail(
        document: PdfDocument,
        targetWidth: Int,
        targetHeight: Int
    ): ByteArray? = renderPage(document, 0, targetWidth, targetHeight)

    override suspend fun renderPage(
        document: PdfDocument,
        pageIndex: Int,
        targetWidth: Int,
        targetHeight: Int
    ): ByteArray? = runCatching {
        val renderer = PdfPageRenderer(document.filePath)
        val bytes = renderer.renderPage(pageIndex, targetWidth, targetHeight)
        renderer.close()
        bytes
    }.getOrNull()
}
