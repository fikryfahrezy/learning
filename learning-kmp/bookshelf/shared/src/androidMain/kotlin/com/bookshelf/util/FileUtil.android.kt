package com.bookshelf.util

import java.io.File

actual fun copyFile(sourcePath: String, destPath: String): Boolean = runCatching {
    File(sourcePath).copyTo(File(destPath), overwrite = true)
}.isSuccess

actual fun deleteFile(path: String): Boolean = File(path).delete()

actual fun getFileSize(path: String): Long = File(path).length()

actual fun readTextFile(path: String): String? = runCatching {
    File(path).readText()
}.getOrNull()

actual fun writeTextFile(path: String, content: String): Boolean = runCatching {
    File(path).writeText(content)
}.isSuccess

actual fun createDirectories(path: String) {
    File(path).mkdirs()
}

actual fun fileExists(path: String): Boolean = File(path).exists()

actual fun currentTimeMillis(): Long = System.currentTimeMillis()
