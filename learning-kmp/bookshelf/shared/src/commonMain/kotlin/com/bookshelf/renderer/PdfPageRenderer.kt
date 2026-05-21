package com.bookshelf.renderer

/**
 * Platform-specific PDF page renderer.
 * Android uses android.graphics.pdf.PdfRenderer.
 * iOS uses PDFKit.
 */
expect class PdfPageRenderer(filePath: String) {
    val pageCount: Int
    fun renderPage(pageIndex: Int, targetWidth: Int, targetHeight: Int): ByteArray
    fun close()
}
