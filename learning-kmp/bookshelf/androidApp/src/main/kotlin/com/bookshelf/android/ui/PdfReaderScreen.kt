package com.bookshelf.android.ui

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.foundation.Canvas
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bookshelf.android.viewmodel.PdfReaderAndroidViewModel
import com.bookshelf.design.AppSpacing
import com.bookshelf.design.AppStrings
import com.bookshelf.model.AnnotationStroke
import com.bookshelf.repository.AnnotationRepository
import com.bookshelf.repository.PdfRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private val PEN_COLORS = listOf("#FFFF0000", "#FF0000FF", "#FF000000", "#FF00AA00")
private val PEN_WIDTHS = listOf(2f, 4f, 8f)

@Composable
fun PdfReaderScreen(
    documentId: String,
    repository: PdfRepository,
    annotationRepository: AnnotationRepository,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: PdfReaderAndroidViewModel = viewModel(
        factory = PdfReaderAndroidViewModel.Factory(repository, annotationRepository, documentId)
    )
    val state by viewModel.state.collectAsStateWithLifecycle()
    var showJumpDialog by remember { mutableStateOf(false) }
    var scale by remember { mutableFloatStateOf(1f) }
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(state.currentPageIndex) {
        scale = 1f; offsetX = 0f; offsetY = 0f
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            AppTopBar(
                title = state.document?.title ?: "",
                onNavigateBack = onNavigateBack
            ) {
                if (!state.isLoading) {
                    IconButton(onClick = viewModel::toggleAnnotationMode) {
                        PencilIcon(
                            contentDescription = AppStrings.ANNOTATE,
                            tint = if (state.isAnnotating)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                            size = 24.dp
                        )
                    }
                    TextButton(onClick = { showJumpDialog = true }) {
                        Text(
                            "${state.currentPage} / ${state.totalPages}",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        },
        bottomBar = {
            if (!state.isLoading && state.document != null) {
                PageNavigationBar(
                    canGoPrevious = state.canGoPrevious,
                    canGoNext = state.canGoNext,
                    progress = state.progress,
                    onPrevious = viewModel::previousPage,
                    onNext = viewModel::nextPage
                )
            }
        },
        modifier = modifier
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (state.isAnnotating) {
                AnnotationToolbar(
                    penColor = state.penColor,
                    penWidth = state.penWidth,
                    canUndo = state.pageStrokes.isNotEmpty(),
                    onColorSelect = viewModel::setPenColor,
                    onWidthSelect = viewModel::setPenWidth,
                    onUndo = viewModel::undoLastStroke,
                    onClear = viewModel::clearPageAnnotations,
                    onDone = viewModel::toggleAnnotationMode
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color(0xFF2C2C2C))
            ) {
                when {
                    state.isLoading -> AppLoadingIndicator(modifier = Modifier.align(Alignment.Center))
                    state.errorMessage != null -> {
                        Text(
                            state.errorMessage!!,
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    state.document != null -> {
                        PdfPageView(
                            document = state.document!!,
                            pageIndex = state.currentPageIndex,
                            repository = repository,
                            scale = scale,
                            offsetX = offsetX,
                            offsetY = offsetY,
                            isAnnotating = state.isAnnotating,
                            strokes = state.pageStrokes,
                            penColor = state.penColor,
                            penWidth = state.penWidth,
                            onTransform = { scaleChange, panX, panY ->
                                scale = (scale * scaleChange).coerceIn(1f, 5f)
                                offsetX += panX
                                offsetY += panY
                            },
                            onStrokeComplete = viewModel::addStroke,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }

    if (showJumpDialog) {
        JumpToPageDialog(
            currentPage = state.currentPage,
            totalPages = state.totalPages,
            onDismiss = { showJumpDialog = false },
            onJump = { page ->
                viewModel.jumpToPage(page - 1)
                showJumpDialog = false
            }
        )
    }
}

@Composable
private fun AnnotationToolbar(
    penColor: String,
    penWidth: Float,
    canUndo: Boolean,
    onColorSelect: (String) -> Unit,
    onWidthSelect: (Float) -> Unit,
    onUndo: () -> Unit,
    onClear: () -> Unit,
    onDone: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(MaterialTheme.colorScheme.surface),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Scrollable: colors + width selectors
        Row(
            modifier = Modifier
                .weight(1f)
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = AppSpacing.SM.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacing.XS.dp)
        ) {
            PEN_COLORS.forEach { hex ->
                val selected = hex == penColor
                Box(
                    modifier = Modifier
                        .size(if (selected) 28.dp else 24.dp)
                        .clip(CircleShape)
                        .background(parseAnnotationColor(hex))
                        .then(
                            if (selected) Modifier.border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                            else Modifier
                        )
                        .clickable { onColorSelect(hex) }
                )
            }
            Spacer(Modifier.width(AppSpacing.SM.dp))
            PEN_WIDTHS.forEach { w ->
                val selected = w == penWidth
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(
                            if (selected) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent
                        )
                        .clickable { onWidthSelect(w) },
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .width(18.dp)
                            .height(w.coerceIn(1f, 6f).dp)
                            .clip(RoundedCornerShape(50))
                            .background(MaterialTheme.colorScheme.onSurface)
                    )
                }
            }
        }

        // Fixed: undo, clear, done
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onUndo, enabled = canUndo) {
                UndoIcon(
                    contentDescription = AppStrings.UNDO,
                    tint = if (canUndo) MaterialTheme.colorScheme.onSurface
                           else MaterialTheme.colorScheme.outline,
                    size = 20.dp
                )
            }
            IconButton(onClick = onClear, enabled = canUndo) {
                TrashIcon(
                    contentDescription = AppStrings.CLEAR,
                    tint = if (canUndo) MaterialTheme.colorScheme.error
                           else MaterialTheme.colorScheme.outline,
                    size = 20.dp
                )
            }
            TextButton(onClick = onDone) {
                Text(
                    AppStrings.DONE,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    softWrap = false
                )
            }
        }
    }
}

@Composable
private fun PdfPageView(
    document: com.bookshelf.model.PdfDocument,
    pageIndex: Int,
    repository: PdfRepository,
    scale: Float,
    offsetX: Float,
    offsetY: Float,
    isAnnotating: Boolean,
    strokes: List<AnnotationStroke>,
    penColor: String,
    penWidth: Float,
    onTransform: (scaleChange: Float, panX: Float, panY: Float) -> Unit,
    onStrokeComplete: (AnnotationStroke) -> Unit,
    modifier: Modifier = Modifier
) {
    var pageBytes by remember(pageIndex) { mutableStateOf<ByteArray?>(null) }
    var isLoading by remember(pageIndex) { mutableStateOf(true) }

    LaunchedEffect(pageIndex) {
        isLoading = true
        pageBytes = withContext(Dispatchers.IO) {
            repository.renderPage(document, pageIndex, 1200, 1600)
        }
        isLoading = false
    }

    Box(
        modifier = modifier
            .clipToBounds()
            .then(
                if (!isAnnotating) Modifier.pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        onTransform(zoom, pan.x, pan.y)
                    }
                } else Modifier
            ),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            AppLoadingIndicator()
        } else {
            val bytes = pageBytes
            if (bytes != null) {
                val bitmap = remember(bytes) {
                    BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                }
                if (bitmap != null) {
                    val density = LocalDensity.current
                    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                        val availW = constraints.maxWidth.toFloat()
                        val availH = constraints.maxHeight.toFloat()
                        val imgAspect = bitmap.width.toFloat() / bitmap.height.toFloat()
                        val pdfW: Float
                        val pdfH: Float
                        if (availW / availH <= imgAspect) {
                            pdfW = availW; pdfH = availW / imgAspect
                        } else {
                            pdfH = availH; pdfW = availH * imgAspect
                        }
                        Box(
                            modifier = Modifier
                                .size(
                                    with(density) { pdfW.toDp() },
                                    with(density) { pdfH.toDp() }
                                )
                                .align(Alignment.Center)
                                .graphicsLayer(
                                    scaleX = scale,
                                    scaleY = scale,
                                    translationX = offsetX,
                                    translationY = offsetY
                                )
                        ) {
                            Image(
                                bitmap = bitmap.asImageBitmap(),
                                contentDescription = "Page ${pageIndex + 1}",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                            DrawingCanvas(
                                strokes = strokes,
                                isDrawingEnabled = isAnnotating,
                                penColor = penColor,
                                penWidth = penWidth,
                                onStrokeComplete = onStrokeComplete,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PageNavigationBar(
    canGoPrevious: Boolean,
    canGoNext: Boolean,
    progress: Float,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = AppSpacing.MD.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onPrevious, enabled = canGoPrevious) {
                ChevronLeftIcon(
                    contentDescription = "Previous page",
                    tint = if (canGoPrevious) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                    size = 24.dp
                )
            }
            BookProgressBar(
                progress = progress,
                modifier = Modifier.weight(1f).padding(horizontal = AppSpacing.SM.dp)
            )
            IconButton(onClick = onNext, enabled = canGoNext) {
                ChevronRightIcon(
                    contentDescription = "Next page",
                    tint = if (canGoNext) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                    size = 24.dp
                )
            }
        }
    }
}

@Composable
private fun BookProgressBar(
    progress: Float,
    modifier: Modifier = Modifier
) {
    val trackColor = MaterialTheme.colorScheme.surfaceVariant
    val fillColor = MaterialTheme.colorScheme.primary

    Canvas(modifier = modifier.height(4.dp)) {
        val radius = size.height / 2
        drawRoundRect(color = trackColor, cornerRadius = androidx.compose.ui.geometry.CornerRadius(radius))
        val fillWidth = (size.width * progress).coerceAtLeast(size.height)
        drawRoundRect(color = fillColor, size = size.copy(width = fillWidth), cornerRadius = androidx.compose.ui.geometry.CornerRadius(radius))
    }
}

@Composable
private fun JumpToPageDialog(
    currentPage: Int,
    totalPages: Int,
    onDismiss: () -> Unit,
    onJump: (Int) -> Unit
) {
    var inputText by remember { mutableStateOf(currentPage.toString()) }
    val pageNumber = inputText.toIntOrNull()
    val isValid = pageNumber != null && pageNumber in 1..totalPages

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(AppStrings.JUMP_TO_PAGE) },
        text = {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it.filter { c -> c.isDigit() } },
                label = { Text("1 – $totalPages") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Go
                ),
                keyboardActions = KeyboardActions(
                    onGo = { if (isValid) onJump(pageNumber!!) }
                ),
                isError = !isValid && inputText.isNotEmpty(),
                singleLine = true
            )
        },
        confirmButton = {
            TextButton(
                onClick = { if (isValid) onJump(pageNumber!!) },
                enabled = isValid
            ) {
                Text(AppStrings.GO)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text(AppStrings.CANCEL) }
        }
    )
}
