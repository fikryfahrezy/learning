package com.bookshelf.android.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import com.bookshelf.model.AnnotationPoint
import com.bookshelf.model.AnnotationStroke

@Composable
fun DrawingCanvas(
    strokes: List<AnnotationStroke>,
    isDrawingEnabled: Boolean,
    penColor: String = "#FFFF0000",
    penWidth: Float = 4f,
    onStrokeComplete: (AnnotationStroke) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var currentPoints by remember { mutableStateOf<List<AnnotationPoint>>(emptyList()) }

    Canvas(
        modifier = modifier.clipToBounds().then(
            if (isDrawingEnabled) Modifier.pointerInput(penColor, penWidth) {
                detectDragGestures(
                    onDragStart = { offset ->
                        currentPoints = listOf(
                            AnnotationPoint(offset.x / size.width, offset.y / size.height)
                        )
                    },
                    onDrag = { change, _ ->
                        currentPoints = currentPoints + AnnotationPoint(
                            change.position.x / size.width,
                            change.position.y / size.height
                        )
                    },
                    onDragEnd = {
                        if (currentPoints.size >= 2) {
                            onStrokeComplete(AnnotationStroke(currentPoints, penColor, penWidth))
                        }
                        currentPoints = emptyList()
                    },
                    onDragCancel = { currentPoints = emptyList() }
                )
            } else Modifier
        )
    ) {
        val allStrokes = strokes + if (currentPoints.size >= 2) {
            listOf(AnnotationStroke(currentPoints, penColor, penWidth))
        } else emptyList()

        for (stroke in allStrokes) {
            if (stroke.points.size < 2) continue
            val path = Path()
            path.moveTo(stroke.points[0].x * size.width, stroke.points[0].y * size.height)
            for (point in stroke.points.drop(1)) {
                path.lineTo(point.x * size.width, point.y * size.height)
            }
            drawPath(
                path = path,
                color = parseAnnotationColor(stroke.colorHex),
                style = Stroke(
                    width = stroke.strokeWidth * density,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round
                )
            )
        }
    }
}

fun parseAnnotationColor(hex: String): Color = runCatching {
    val clean = hex.trimStart('#')
    val full = if (clean.length == 6) "FF$clean" else clean
    val a = full.substring(0, 2).toInt(16)
    val r = full.substring(2, 4).toInt(16)
    val g = full.substring(4, 6).toInt(16)
    val b = full.substring(6, 8).toInt(16)
    Color(r, g, b, a)
}.getOrDefault(Color.Red)
