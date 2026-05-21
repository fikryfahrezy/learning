package com.bookshelf.repository

import com.bookshelf.model.PdfDocument
import kotlinx.coroutines.flow.Flow

interface PdfRepository {
    fun observeDocuments(): Flow<List<PdfDocument>>

    @Throws(Exception::class)
    suspend fun addDocument(localFilePath: String, displayName: String): PdfDocument

    @Throws(Exception::class)
    suspend fun deleteDocument(documentId: String)

    suspend fun getDocument(documentId: String): PdfDocument?
    suspend fun renderThumbnail(document: PdfDocument, targetWidth: Int, targetHeight: Int): ByteArray?
    suspend fun renderPage(document: PdfDocument, pageIndex: Int, targetWidth: Int, targetHeight: Int): ByteArray?
}
