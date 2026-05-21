@file:OptIn(ExperimentalForeignApi::class)

package com.bookshelf.renderer

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGContextFillRect
import platform.CoreGraphics.CGContextScaleCTM
import platform.CoreGraphics.CGContextSetRGBFillColor
import platform.CoreGraphics.CGContextTranslateCTM
import platform.CoreGraphics.CGDataProviderCreateWithFilename
import platform.CoreGraphics.CGDataProviderRelease
import platform.CoreGraphics.CGPDFDocumentCreateWithProvider
import platform.CoreGraphics.CGPDFDocumentGetNumberOfPages
import platform.CoreGraphics.CGPDFDocumentGetPage
import platform.CoreGraphics.CGPDFDocumentRelease
import platform.CoreGraphics.CGPDFPageGetBoxRect
import platform.CoreGraphics.CGRectMake
import platform.CoreGraphics.CGSizeMake
import platform.CoreGraphics.kCGPDFMediaBox
import platform.CoreGraphics.CGContextDrawPDFPage
import platform.UIKit.UIGraphicsBeginImageContextWithOptions
import platform.UIKit.UIGraphicsEndImageContext
import platform.UIKit.UIGraphicsGetCurrentContext
import platform.UIKit.UIGraphicsGetImageFromCurrentImageContext
import platform.UIKit.UIImagePNGRepresentation
import platform.posix.memcpy

actual class PdfPageRenderer actual constructor(filePath: String) {

    private val document = run {
        val provider = CGDataProviderCreateWithFilename(filePath)
        val doc = provider?.let { CGPDFDocumentCreateWithProvider(it) }
        provider?.let { CGDataProviderRelease(it) }
        doc
    }

    actual val pageCount: Int
        get() = document?.let { CGPDFDocumentGetNumberOfPages(it).toInt() } ?: 0

    actual fun renderPage(pageIndex: Int, targetWidth: Int, targetHeight: Int): ByteArray {
        val doc = document ?: return ByteArray(0)
        // CGPDFDocument pages are 1-indexed
        val page = CGPDFDocumentGetPage(doc, (pageIndex + 1).toULong())
            ?: return ByteArray(0)

        val mediaBox = CGPDFPageGetBoxRect(page, kCGPDFMediaBox)
        val pageW = mediaBox.useContents { size.width }
        val pageH = mediaBox.useContents { size.height }
        if (pageW <= 0.0 || pageH <= 0.0) return ByteArray(0)

        val scale = minOf(targetWidth / pageW, targetHeight / pageH)
        val renderW = pageW * scale
        val renderH = pageH * scale

        UIGraphicsBeginImageContextWithOptions(CGSizeMake(renderW, renderH), false, 1.0)

        val ctx = UIGraphicsGetCurrentContext() ?: run {
            UIGraphicsEndImageContext()
            return ByteArray(0)
        }

        // White background
        CGContextSetRGBFillColor(ctx, 1.0, 1.0, 1.0, 1.0)
        CGContextFillRect(ctx, CGRectMake(0.0, 0.0, renderW, renderH))

        // PDF origin is bottom-left; UIKit is top-left — flip the context
        CGContextTranslateCTM(ctx, 0.0, renderH)
        CGContextScaleCTM(ctx, scale, -scale)

        CGContextDrawPDFPage(ctx, page)

        val image = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()

        val pngData = image?.let { UIImagePNGRepresentation(it) }
            ?: return ByteArray(0)

        return ByteArray(pngData.length.toInt()).also { arr ->
            arr.usePinned { pinned ->
                memcpy(pinned.addressOf(0), pngData.bytes, pngData.length)
            }
        }
    }

    actual fun close() {
        document?.let { CGPDFDocumentRelease(it) }
    }
}
