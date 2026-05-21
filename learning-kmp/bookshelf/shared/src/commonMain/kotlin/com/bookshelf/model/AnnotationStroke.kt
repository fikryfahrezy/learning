package com.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class AnnotationPoint(val x: Float, val y: Float)

@Serializable
data class AnnotationStroke(
    val points: List<AnnotationPoint>,
    val colorHex: String = "#FFFF0000",
    val strokeWidth: Float = 4f
)

@Serializable
data class DocumentAnnotations(
    val documentId: String,
    val pageStrokes: Map<String, List<AnnotationStroke>> = emptyMap()
)

// Builder used by iOS Swift code to construct AnnotationStroke without dealing with Kotlin List directly
class AnnotationStrokeBuilder {
    private val points = mutableListOf<AnnotationPoint>()

    fun addPoint(x: Float, y: Float) {
        points.add(AnnotationPoint(x, y))
    }

    val size: Int get() = points.size

    fun build(colorHex: String, strokeWidth: Float): AnnotationStroke? {
        if (points.size < 2) return null
        return AnnotationStroke(points.toList(), colorHex, strokeWidth)
    }

    fun clear() {
        points.clear()
    }
}
