package com.bookshelf.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bookshelf.android.ui.PdfListScreen
import com.bookshelf.android.ui.PdfReaderScreen
import com.bookshelf.android.ui.theme.BookshelfTheme
import com.bookshelf.repository.SharedAnnotationRepository
import com.bookshelf.repository.SharedPdfRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BookshelfTheme {
                val repository = remember {
                    SharedPdfRepository(filesDir.absolutePath)
                }
                val annotationRepository = remember {
                    SharedAnnotationRepository(filesDir.absolutePath)
                }
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "pdf_list"
                ) {
                    composable("pdf_list") {
                        PdfListScreen(
                            repository = repository,
                            annotationRepository = annotationRepository,
                            onDocumentClick = { doc ->
                                navController.navigate("pdf_reader/${doc.id}")
                            },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    composable(
                        route = "pdf_reader/{documentId}",
                        arguments = listOf(navArgument("documentId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val documentId = backStackEntry.arguments?.getString("documentId") ?: return@composable
                        PdfReaderScreen(
                            documentId = documentId,
                            repository = repository,
                            annotationRepository = annotationRepository,
                            onNavigateBack = { navController.popBackStack() },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}
