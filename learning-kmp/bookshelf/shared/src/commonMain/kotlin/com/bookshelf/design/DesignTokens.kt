package com.bookshelf.design

/**
 * Single source of truth for the Bookshelf design system.
 * Android (Compose) and iOS (SwiftUI) both derive their theme from these values.
 */
object AppColors {
    // Light theme — ARGB hex longs
    const val PRIMARY = 0xFF1A237EL
    const val PRIMARY_CONTAINER = 0xFF3949ABL
    const val SECONDARY = 0xFFE65100L
    const val SECONDARY_CONTAINER = 0xFFFF6D00L
    const val BACKGROUND = 0xFFF8F7F4L
    const val SURFACE = 0xFFFFFFFFL
    const val SURFACE_VARIANT = 0xFFF1EFE9L
    const val ON_PRIMARY = 0xFFFFFFFFL
    const val ON_SECONDARY = 0xFFFFFFFFL
    const val ON_BACKGROUND = 0xFF1C1B1FL
    const val ON_SURFACE = 0xFF1C1B1FL
    const val ON_SURFACE_VARIANT = 0xFF49454FL
    const val ERROR = 0xFFB3261EL
    const val OUTLINE = 0xFF79747EL
    const val OUTLINE_VARIANT = 0xFFCAC4D0L
}

object AppColorsDark {
    // Dark theme — ARGB hex longs
    const val PRIMARY = 0xFF9FA8DAL
    const val PRIMARY_CONTAINER = 0xFF3949ABL
    const val SECONDARY = 0xFFFFB74DL
    const val SECONDARY_CONTAINER = 0xFFE65100L
    const val BACKGROUND = 0xFF121212L
    const val SURFACE = 0xFF1E1E1EL
    const val SURFACE_VARIANT = 0xFF2D2D2DL
    const val ON_PRIMARY = 0xFF1A237EL
    const val ON_SECONDARY = 0xFF3E1C00L
    const val ON_BACKGROUND = 0xFFE6E1E5L
    const val ON_SURFACE = 0xFFE6E1E5L
    const val ON_SURFACE_VARIANT = 0xFFCAC4D0L
    const val ERROR = 0xFFF2B8B0L
    const val OUTLINE = 0xFF938F99L
    const val OUTLINE_VARIANT = 0xFF49454FL
}

object AppSpacing {
    const val XS = 4f
    const val SM = 8f
    const val MD = 16f
    const val LG = 24f
    const val XL = 32f
    const val XXL = 48f
}

object AppRadius {
    const val SM = 8f
    const val MD = 12f
    const val LG = 16f
    const val XL = 24f
}

object AppElevation {
    const val CARD = 2f
    const val FAB = 6f
    const val TOP_BAR = 4f
    const val BOTTOM_BAR = 8f
}

object AppTypography {
    const val DISPLAY_LARGE = 57f
    const val DISPLAY_MEDIUM = 45f
    const val DISPLAY_SMALL = 36f
    const val HEADLINE_LARGE = 32f
    const val HEADLINE_MEDIUM = 28f
    const val HEADLINE_SMALL = 24f
    const val TITLE_LARGE = 22f
    const val TITLE_MEDIUM = 16f
    const val TITLE_SMALL = 14f
    const val BODY_LARGE = 16f
    const val BODY_MEDIUM = 14f
    const val BODY_SMALL = 12f
    const val LABEL_LARGE = 14f
    const val LABEL_MEDIUM = 12f
    const val LABEL_SMALL = 11f
}

object AppStrings {
    const val APP_NAME = "Bookshelf"
    const val EMPTY_LIBRARY_TITLE = "Your shelf is empty"
    const val EMPTY_LIBRARY_SUBTITLE = "Tap + to add your first PDF book"
    const val ADD_PDF = "Add PDF"
    const val DELETE = "Delete"
    const val CANCEL = "Cancel"
    const val CONFIRM_DELETE_TITLE = "Remove book?"
    const val CONFIRM_DELETE_MESSAGE = "This will remove the book from your library. The original file will not be deleted."
    const val PAGE_COUNTER = "Page %d of %d"
    const val JUMP_TO_PAGE = "Jump to page"
    const val GO = "Go"
    const val PAGES = "pages"
    const val ANNOTATE = "Annotate"
    const val DONE = "Done"
    const val UNDO = "Undo"
    const val CLEAR = "Clear"
}
