package com.bookshelf.repository

import com.bookshelf.model.AnnotationStroke
import com.bookshelf.model.DocumentAnnotations
import com.bookshelf.util.createDirectories
import com.bookshelf.util.deleteFile
import com.bookshelf.util.readTextFile
import com.bookshelf.util.writeTextFile
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SharedAnnotationRepository(private val storageDirectory: String) : AnnotationRepository {

    private val annotationsDirectory = "$storageDirectory/annotations"
    private val json = Json { prettyPrint = true; ignoreUnknownKeys = true }

    init {
        createDirectories(annotationsDirectory)
    }

    private fun filePath(documentId: String) = "$annotationsDirectory/$documentId.json"

    private fun loadDocumentAnnotations(documentId: String): DocumentAnnotations {
        val content = readTextFile(filePath(documentId)) ?: return DocumentAnnotations(documentId)
        return runCatching {
            json.decodeFromString<DocumentAnnotations>(content)
        }.getOrDefault(DocumentAnnotations(documentId))
    }

    private fun saveDocumentAnnotations(doc: DocumentAnnotations) {
        writeTextFile(filePath(doc.documentId), json.encodeToString(doc))
    }

    override suspend fun loadPageStrokes(documentId: String, pageIndex: Int): List<AnnotationStroke> =
        loadDocumentAnnotations(documentId).pageStrokes[pageIndex.toString()] ?: emptyList()

    override suspend fun savePageStrokes(documentId: String, pageIndex: Int, strokes: List<AnnotationStroke>) {
        val doc = loadDocumentAnnotations(documentId)
        val updated = if (strokes.isEmpty()) {
            doc.copy(pageStrokes = doc.pageStrokes - pageIndex.toString())
        } else {
            doc.copy(pageStrokes = doc.pageStrokes + (pageIndex.toString() to strokes))
        }
        saveDocumentAnnotations(updated)
    }

    override suspend fun deleteDocumentAnnotations(documentId: String) {
        deleteFile(filePath(documentId))
    }
}
