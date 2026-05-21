import SwiftUI

enum AppColor {
    static let primary        = Color.adaptive(light: 0x1A237E, dark: 0x9FA8DA)
    static let primaryVariant = Color.adaptive(light: 0x3949AB, dark: 0x7986CB)
    static let secondary      = Color.adaptive(light: 0xE65100, dark: 0xFFB74D)
    static let background     = Color.adaptive(light: 0xF8F7F4, dark: 0x121212)
    static let surface        = Color.adaptive(light: 0xFFFFFF, dark: 0x1E1E1E)
    static let surfaceVariant = Color.adaptive(light: 0xF1EFE9, dark: 0x2D2D2D)
    static let onPrimary      = Color.adaptive(light: 0xFFFFFF, dark: 0x1A237E)
    static let onBackground   = Color.adaptive(light: 0x1C1B1F, dark: 0xE6E1E5)
    static let onSurface      = Color.adaptive(light: 0x1C1B1F, dark: 0xE6E1E5)
    static let onSurfaceVariant = Color.adaptive(light: 0x49454F, dark: 0xCAC4D0)
    static let error          = Color.adaptive(light: 0xB3261E, dark: 0xF2B8B0)
    static let outline        = Color.adaptive(light: 0x79747E, dark: 0x938F99)
    static let outlineVariant = Color.adaptive(light: 0xCAC4D0, dark: 0x49454F)
}

enum AppSpacing {
    static let xs: CGFloat = 4
    static let sm: CGFloat = 8
    static let md: CGFloat = 16
    static let lg: CGFloat = 24
    static let xl: CGFloat = 32
    static let xxl: CGFloat = 48
}

enum AppRadius {
    static let sm: CGFloat = 8
    static let md: CGFloat = 12
    static let lg: CGFloat = 16
    static let xl: CGFloat = 24
}

enum AppFontSize {
    static let headlineLarge: CGFloat = 32
    static let headlineMedium: CGFloat = 28
    static let headlineSmall: CGFloat = 24
    static let titleLarge: CGFloat = 22
    static let titleMedium: CGFloat = 16
    static let titleSmall: CGFloat = 14
    static let bodyLarge: CGFloat = 16
    static let bodyMedium: CGFloat = 14
    static let bodySmall: CGFloat = 12
    static let labelMedium: CGFloat = 12
    static let labelSmall: CGFloat = 11
}

enum AppStrings {
    static let appName = "Bookshelf"
    static let emptyTitle = "Your shelf is empty"
    static let emptySubtitle = "Tap + to add your first PDF book"
    static let addPdf = "Add PDF"
    static let delete = "Delete"
    static let cancel = "Cancel"
    static let removeBook = "Remove book?"
    static let removeBookMessage = "This will remove the book from your library. The original file will not be deleted."
    static let jumpToPage = "Jump to page"
    static let go = "Go"
    static let pages = "pages"
    static let annotate = "Annotate"
    static let done = "Done"
    static let undo = "Undo"
    static let clear = "Clear"
}

extension Color {
    static func adaptive(light: UInt, dark: UInt) -> Color {
        Color(UIColor { tc in
            tc.userInterfaceStyle == .dark ? UIColor(hex: dark) : UIColor(hex: light)
        })
    }
}

extension UIColor {
    convenience init(hex: UInt, alpha: CGFloat = 1) {
        self.init(
            red:   CGFloat((hex >> 16) & 0xFF) / 255,
            green: CGFloat((hex >> 8)  & 0xFF) / 255,
            blue:  CGFloat( hex        & 0xFF) / 255,
            alpha: alpha
        )
    }
}
