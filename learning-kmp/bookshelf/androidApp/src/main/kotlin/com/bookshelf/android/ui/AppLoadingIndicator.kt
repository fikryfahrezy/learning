package com.bookshelf.android.ui

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppLoadingIndicator(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)
}
