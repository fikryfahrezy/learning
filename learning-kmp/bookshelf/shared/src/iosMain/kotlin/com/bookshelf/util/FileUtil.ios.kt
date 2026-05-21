@file:OptIn(ExperimentalForeignApi::class)

package com.bookshelf.util

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.NSDate
import platform.Foundation.NSFileManager
import platform.Foundation.NSFileSize
import platform.Foundation.NSNumber
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.create
import platform.Foundation.dataWithContentsOfFile
import platform.Foundation.timeIntervalSince1970
import platform.Foundation.writeToFile

actual fun copyFile(sourcePath: String, destPath: String): Boolean {
    val fm = NSFileManager.defaultManager
    if (fm.fileExistsAtPath(destPath)) {
        fm.removeItemAtPath(destPath, null)
    }
    return fm.copyItemAtPath(sourcePath, destPath, null)
}

actual fun deleteFile(path: String): Boolean =
    NSFileManager.defaultManager.removeItemAtPath(path, null)

actual fun getFileSize(path: String): Long {
    val attrs = NSFileManager.defaultManager.attributesOfItemAtPath(path, null)
    return (attrs?.get(NSFileSize) as? NSNumber)?.longValue ?: 0L
}

actual fun readTextFile(path: String): String? {
    val data = NSData.dataWithContentsOfFile(path) ?: return null
    val bytes = ByteArray(data.length.toInt())
    bytes.usePinned { pinned ->
        platform.posix.memcpy(pinned.addressOf(0), data.bytes, data.length)
    }
    return bytes.decodeToString()
}

actual fun writeTextFile(path: String, content: String): Boolean {
    val bytes = content.encodeToByteArray()
    val data = bytes.usePinned { pinned ->
        NSData.create(bytes = pinned.addressOf(0), length = bytes.size.toULong())
    }
    return data.writeToFile(path, atomically = true)
}

actual fun createDirectories(path: String) {
    NSFileManager.defaultManager.createDirectoryAtPath(
        path,
        withIntermediateDirectories = true,
        attributes = null,
        error = null
    )
}

actual fun fileExists(path: String): Boolean =
    NSFileManager.defaultManager.fileExistsAtPath(path)

actual fun currentTimeMillis(): Long =
    (NSDate().timeIntervalSince1970 * 1000).toLong()
