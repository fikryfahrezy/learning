import SwiftUI

struct AppTopBar<Trailing: View>: View {
    let title: String
    var onBack: (() -> Void)? = nil
    let trailing: Trailing

    init(title: String, onBack: (() -> Void)? = nil, @ViewBuilder trailing: () -> Trailing) {
        self.title = title
        self.onBack = onBack
        self.trailing = trailing()
    }

    var body: some View {
        HStack(spacing: 0) {
            if let onBack = onBack {
                Button(action: onBack) {
                    ChevronLeftIcon(color: AppColor.onPrimary, size: 24)
                        .frame(width: 48, height: 48)
                }
            } else {
                Spacer().frame(width: AppSpacing.md)
            }

            Text(title)
                .font(.system(size: AppFontSize.titleMedium, weight: .semibold))
                .foregroundColor(AppColor.onPrimary)
                .lineLimit(1)
                .truncationMode(.tail)
                .frame(maxWidth: .infinity, alignment: .leading)

            trailing
                .padding(.trailing, AppSpacing.sm)
        }
        .frame(height: 56)
        .background(AppColor.primary.ignoresSafeArea(edges: .top))
    }
}

extension AppTopBar where Trailing == EmptyView {
    init(title: String, onBack: (() -> Void)? = nil) {
        self.init(title: title, onBack: onBack) { EmptyView() }
    }
}
