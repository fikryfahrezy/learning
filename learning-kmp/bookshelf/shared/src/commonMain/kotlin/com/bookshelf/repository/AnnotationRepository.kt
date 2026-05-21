package com.bookshelf.repository

import com.bookshelf.model.AnnotationStroke

interface AnnotationRepository {
    suspend fun loadPageStrokes(documentId: String, pageIndex: Int): List<AnnotationStroke>
    suspend fun savePageStrokes(documentId: String, pageIndex: Int, strokes: List<AnnotationStroke>)
    suspend fun deleteDocumentAnnotations(documentId: String)
}
