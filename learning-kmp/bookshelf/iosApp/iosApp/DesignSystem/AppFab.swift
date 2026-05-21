import SwiftUI

struct AppFab<Content: View>: View {
    let action: () -> Void
    let content: Content

    init(action: @escaping () -> Void, @ViewBuilder content: () -> Content) {
        self.action = action
        self.content = content()
    }

    var body: some View {
        Button(action: action) {
            content
                .frame(width: 56, height: 56)
                .background(AppColor.secondary)
                .clipShape(RoundedRectangle(cornerRadius: AppRadius.lg))
                .shadow(color: .black.opacity(0.2), radius: 6, x: 0, y: 3)
        }
    }
}
