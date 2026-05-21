package com.bookshelf.renderer

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import java.io.ByteArrayOutputStream
import java.io.File

actual class PdfPageRenderer actual constructor(filePath: String) {

    private val fileDescriptor = ParcelFileDescriptor.open(
        File(filePath),
        ParcelFileDescriptor.MODE_READ_ONLY
    )
    private val renderer = PdfRenderer(fileDescriptor)

    actual val pageCount: Int get() = renderer.pageCount

    actual fun renderPage(pageIndex: Int, targetWidth: Int, targetHeight: Int): ByteArray {
        val page = renderer.openPage(pageIndex)

        val pageWidth = page.width
        val pageHeight = page.height
        val scale = minOf(
            targetWidth.toFloat() / pageWidth,
            targetHeight.toFloat() / pageHeight
        )

        val bitmapWidth = (pageWidth * scale).toInt().coerceAtLeast(1)
        val bitmapHeight = (pageHeight * scale).toInt().coerceAtLeast(1)

        val bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.WHITE)

        page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        page.close()

        return ByteArrayOutputStream().use { stream ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 95, stream)
            bitmap.recycle()
            stream.toByteArray()
        }
    }

    actual fun close() {
        renderer.close()
        fileDescriptor.close()
    }
}
