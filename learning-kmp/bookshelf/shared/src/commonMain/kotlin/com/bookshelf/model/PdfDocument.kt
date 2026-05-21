package com.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class PdfDocument(
    val id: String,
    val title: String,
    val filePath: String,
    val pageCount: Int,
    val fileSizeBytes: Long,
    val importedAt: Long
) {
    val formattedSize: String
        get() {
            val kb = fileSizeBytes / 1024.0
            val mb = kb / 1024.0
            return if (mb >= 1.0) "${(mb * 10).toLong() / 10.0} MB"
            else "${kb.toLong()} KB"
        }
}
