package com.bookshelf.android.ui

import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bookshelf.android.viewmodel.PdfListAndroidViewModel
import com.bookshelf.design.AppSpacing
import com.bookshelf.design.AppStrings
import com.bookshelf.model.PdfDocument
import com.bookshelf.repository.AnnotationRepository
import com.bookshelf.repository.PdfRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun PdfListScreen(
    repository: PdfRepository,
    annotationRepository: AnnotationRepository,
    onDocumentClick: (PdfDocument) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val viewModel: PdfListAndroidViewModel = viewModel(
        factory = PdfListAndroidViewModel.Factory(repository, annotationRepository, context.cacheDir)
    )
    val state by viewModel.state.collectAsStateWithLifecycle()

    var showDeleteDialog by remember { mutableStateOf<PdfDocument?>(null) }

    val pdfPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri ?: return@rememberLauncherForActivityResult
        val displayName = context.contentResolver
            .query(uri, arrayOf(android.provider.OpenableColumns.DISPLAY_NAME), null, null, null)
            ?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val col = cursor.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                    if (col >= 0) cursor.getString(col) else null
                } else null
            }
            ?.removeSuffix(".pdf")
            ?: "Untitled"
        viewModel.importPdfFromUri(context, uri, displayName)
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            AppTopBar(title = AppStrings.APP_NAME)
        },
        floatingActionButton = {
            AppFab(onClick = { pdfPickerLauncher.launch("application/pdf") }) {
                PlusIcon(
                    contentDescription = AppStrings.ADD_PDF,
                    tint = MaterialTheme.colorScheme.onSecondary,
                    size = 24.dp
                )
            }
        },
        modifier = modifier
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when {
                state.isLoading -> {
                    AppLoadingIndicator(modifier = Modifier.align(Alignment.Center))
                }
                state.documents.isEmpty() -> {
                    EmptyLibraryPlaceholder(modifier = Modifier.align(Alignment.Center))
                }
                else -> {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 160.dp),
                        contentPadding = PaddingValues(AppSpacing.MD.dp),
                        horizontalArrangement = Arrangement.spacedBy(AppSpacing.MD.dp),
                        verticalArrangement = Arrangement.spacedBy(AppSpacing.MD.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(state.documents, key = { it.id }) { doc ->
                            PdfBookCard(
                                document = doc,
                                repository = repository,
                                onClick = { onDocumentClick(doc) },
                                onDelete = { showDeleteDialog = doc }
                            )
                        }
                    }
                }
            }
        }
    }

    showDeleteDialog?.let { doc ->
        AppDialog(
            title = AppStrings.CONFIRM_DELETE_TITLE,
            message = AppStrings.CONFIRM_DELETE_MESSAGE,
            confirmLabel = AppStrings.DELETE,
            onConfirm = {
                viewModel.deleteDocument(doc.id)
                showDeleteDialog = null
            },
            onDismiss = { showDeleteDialog = null },
            confirmIsDestructive = true
        )
    }
}

@Composable
private fun PdfBookCard(
    document: PdfDocument,
    repository: PdfRepository,
    onClick: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    var thumbnailBytes by remember { mutableStateOf<ByteArray?>(null) }

    LaunchedEffect(document.id) {
        thumbnailBytes = withContext(Dispatchers.IO) {
            repository.renderThumbnail(document, 320, 440)
        }
    }

    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                val bytes = thumbnailBytes
                if (bytes != null) {
                    val bitmap = remember(bytes) {
                        BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                    }
                    if (bitmap != null) {
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                } else {
                    BookIcon(
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        size = 64.dp
                    )
                }
            }

            Column(modifier = Modifier.padding(AppSpacing.SM.dp)) {
                Text(
                    text = document.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${document.pageCount} ${AppStrings.PAGES} · ${document.formattedSize}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = AppSpacing.SM.dp, end = AppSpacing.SM.dp, bottom = AppSpacing.SM.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onDelete, modifier = Modifier.size(32.dp)) {
                    TrashIcon(
                        contentDescription = AppStrings.DELETE,
                        tint = MaterialTheme.colorScheme.error,
                        size = 18.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyLibraryPlaceholder(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(AppSpacing.XL.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(AppSpacing.MD.dp)
    ) {
        BooksStackIcon(
            tint = MaterialTheme.colorScheme.outline,
            size = 80.dp
        )
        Text(
            text = AppStrings.EMPTY_LIBRARY_TITLE,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = AppStrings.EMPTY_LIBRARY_SUBTITLE,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
