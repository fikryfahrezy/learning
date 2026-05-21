package com.bookshelf.android.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun BookIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size).maybeSemantics(contentDescription)) {
        val w = this.size.width; val h = this.size.height
        val lw = max(1.5f, w * 0.065f)
        val stroke = Stroke(lw, cap = StrokeCap.Round, join = StrokeJoin.Round)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint
        drawPath(Path().apply {
            moveTo(w * .5f, h * .14f); lineTo(w * .06f, h * .24f)
            lineTo(w * .06f, h * .84f); lineTo(w * .5f, h * .76f); close()
        }, c, style = stroke)
        drawPath(Path().apply {
            moveTo(w * .5f, h * .14f); lineTo(w * .94f, h * .24f)
            lineTo(w * .94f, h * .84f); lineTo(w * .5f, h * .76f); close()
        }, c, style = stroke)
        drawLine(c, Offset(w * .5f, h * .14f), Offset(w * .5f, h * .76f),
            strokeWidth = max(1f, lw * .6f), cap = StrokeCap.Round)
    }
}

@Composable
fun BooksStackIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size).maybeSemantics(contentDescription)) {
        val w = this.size.width; val h = this.size.height
        val lw = max(1.5f, w * 0.08f)
        val stroke = Stroke(lw, cap = StrokeCap.Round, join = StrokeJoin.Round)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint
        val bw = w * .20f; val gap = w * .075f; val baseY = h * .88f
        val configs = listOf(
            Pair(w * .08f, h * .18f),
            Pair(w * .08f + bw + gap, h * .30f),
            Pair(w * .08f + (bw + gap) * 2, h * .22f)
        )
        for ((x, topY) in configs) {
            drawPath(Path().apply {
                addRoundRect(RoundRect(x, topY, x + bw, baseY, CornerRadius(2f)))
            }, c, style = stroke)
        }
        drawLine(c, Offset(w * .04f, baseY), Offset(w * .96f, baseY),
            strokeWidth = lw, cap = StrokeCap.Round)
    }
}

@Composable
fun PlusIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size).maybeSemantics(contentDescription)) {
        val w = this.size.width; val h = this.size.height
        val lw = max(2f, w * .13f)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint
        drawLine(c, Offset(w * .22f, h * .5f), Offset(w * .78f, h * .5f), lw, StrokeCap.Round)
        drawLine(c, Offset(w * .5f, h * .22f), Offset(w * .5f, h * .78f), lw, StrokeCap.Round)
    }
}

@Composable
fun TrashIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size).maybeSemantics(contentDescription)) {
        val w = this.size.width; val h = this.size.height
        val lw = max(1.5f, w * .09f)
        val stroke = Stroke(lw, cap = StrokeCap.Round, join = StrokeJoin.Round)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint
        drawPath(Path().apply {
            moveTo(w * .20f, h * .30f); lineTo(w * .26f, h * .87f)
            lineTo(w * .74f, h * .87f); lineTo(w * .80f, h * .30f)
        }, c, style = stroke)
        drawLine(c, Offset(w * .11f, h * .30f), Offset(w * .89f, h * .30f), lw, StrokeCap.Round)
        drawPath(Path().apply {
            moveTo(w * .38f, h * .30f); lineTo(w * .38f, h * .17f)
            lineTo(w * .62f, h * .17f); lineTo(w * .62f, h * .30f)
        }, c, style = stroke)
    }
}

@Composable
fun BackArrowIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size).maybeSemantics(contentDescription)) {
        val w = this.size.width; val h = this.size.height
        val lw = max(2f, w * .10f)
        val stroke = Stroke(lw, cap = StrokeCap.Round, join = StrokeJoin.Round)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint
        drawPath(Path().apply {
            moveTo(w * .58f, h * .22f); lineTo(w * .26f, h * .50f); lineTo(w * .58f, h * .78f)
        }, c, style = stroke)
        drawLine(c, Offset(w * .26f, h * .50f), Offset(w * .82f, h * .50f), lw, StrokeCap.Round)
    }
}

@Composable
fun ChevronLeftIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size).maybeSemantics(contentDescription)) {
        val w = this.size.width; val h = this.size.height
        val lw = max(2f, w * .11f)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint
        drawPath(Path().apply {
            moveTo(w * .63f, h * .22f); lineTo(w * .37f, h * .50f); lineTo(w * .63f, h * .78f)
        }, c, style = Stroke(lw, cap = StrokeCap.Round, join = StrokeJoin.Round))
    }
}

@Composable
fun ChevronRightIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size).maybeSemantics(contentDescription)) {
        val w = this.size.width; val h = this.size.height
        val lw = max(2f, w * .11f)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint
        drawPath(Path().apply {
            moveTo(w * .37f, h * .22f); lineTo(w * .63f, h * .50f); lineTo(w * .37f, h * .78f)
        }, c, style = Stroke(lw, cap = StrokeCap.Round, join = StrokeJoin.Round))
    }
}

@Composable
fun PencilIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    val semanticsModifier = if (contentDescription != null) {
        Modifier.semantics { this.contentDescription = contentDescription }
    } else Modifier

    Canvas(modifier = modifier.size(size).then(semanticsModifier)) {
        val w = this.size.width
        val h = this.size.height
        
        // Scale stroke width based on size, with a minimum floor
        val lw = max(1.5f, w * 0.08f)
        val stroke = Stroke(width = lw, cap = StrokeCap.Round, join = StrokeJoin.Round)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint

        val pencilPath = Path().apply {
            // Main Outline
            moveTo(w * 0.125f, h * 0.875f) // Bottom-left tip
            lineTo(w * 0.250f, h * 0.625f) // Left tip corner
            lineTo(w * 0.625f, h * 0.250f) // Left eraser base
            lineTo(w * 0.750f, h * 0.125f) // Top-left eraser
            lineTo(w * 0.875f, h * 0.250f) // Top-right eraser
            lineTo(w * 0.750f, h * 0.375f) // Right eraser base
            lineTo(w * 0.375f, h * 0.750f) // Right tip corner
            close()

            // Eraser separator line
            moveTo(w * 0.625f, h * 0.250f)
            lineTo(w * 0.750f, h * 0.375f)

            // Tip separator line
            moveTo(w * 0.250f, h * 0.625f)
            lineTo(w * 0.375f, h * 0.750f)
        }

        drawPath(pencilPath, color = c, style = stroke)
    }
}

@Composable
fun UndoIcon(
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(size).maybeSemantics(contentDescription)) {
        val w = this.size.width; val h = this.size.height
        val lw = max(1.5f, w * 0.10f)
        val c = if (tint == Color.Unspecified) Color(0xFF49454F) else tint
        drawPath(Path().apply {
            moveTo(w * .35f, h * .28f); lineTo(w * .18f, h * .44f); lineTo(w * .35f, h * .60f)
        }, c, style = Stroke(lw, cap = StrokeCap.Round, join = StrokeJoin.Round))
        drawPath(Path().apply {
            moveTo(w * .18f, h * .44f); lineTo(w * .68f, h * .44f)
            cubicTo(w * .85f, h * .44f, w * .85f, h * .74f, w * .68f, h * .74f)
            lineTo(w * .40f, h * .74f)
        }, c, style = Stroke(lw, cap = StrokeCap.Round, join = StrokeJoin.Round))
    }
}

private fun Modifier.maybeSemantics(description: String?): Modifier =
    if (description != null) this.semantics { contentDescription = description } else this
