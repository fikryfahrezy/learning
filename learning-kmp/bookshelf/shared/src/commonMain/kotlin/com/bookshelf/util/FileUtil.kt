package com.bookshelf.util

expect fun copyFile(sourcePath: String, destPath: String): Boolean
expect fun deleteFile(path: String): Boolean
expect fun getFileSize(path: String): Long
expect fun readTextFile(path: String): String?
expect fun writeTextFile(path: String, content: String): Boolean
expect fun createDirectories(path: String)
expect fun fileExists(path: String): Boolean
expect fun currentTimeMillis(): Long
