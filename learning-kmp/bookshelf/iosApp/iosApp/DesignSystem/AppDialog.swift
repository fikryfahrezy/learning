import SwiftUI

struct AppDialog: View {
    let title: String
    let message: String
    let confirmLabel: String
    let onConfirm: () -> Void
    let onDismiss: () -> Void
    var confirmIsDestructive: Bool = false

    var body: some View {
        ZStack {
            Color.black.opacity(0.4)
                .ignoresSafeArea()
                .onTapGesture { onDismiss() }

            VStack(alignment: .leading, spacing: 12) {
                Text(title)
                    .font(.system(size: AppFontSize.titleMedium, weight: .bold))
                    .foregroundColor(AppColor.onSurface)

                Text(message)
                    .font(.system(size: AppFontSize.bodyMedium))
                    .foregroundColor(AppColor.onSurfaceVariant)

                Spacer().frame(height: 4)

                HStack(spacing: 12) {
                    Button(action: onDismiss) {
                        Text(AppStrings.cancel)
                            .font(.system(size: AppFontSize.bodyMedium, weight: .medium))
                            .foregroundColor(AppColor.onSurface)
                            .frame(maxWidth: .infinity)
                            .padding(.vertical, 14)
                            .background(AppColor.surfaceVariant)
                            .clipShape(Capsule())
                    }

                    Button(action: onConfirm) {
                        Text(confirmLabel)
                            .font(.system(size: AppFontSize.bodyMedium, weight: .medium))
                            .foregroundColor(
                                confirmIsDestructive ? AppColor.error : AppColor.primary
                            )
                            .frame(maxWidth: .infinity)
                            .padding(.vertical, 14)
                            .background(AppColor.surfaceVariant)
                            .clipShape(Capsule())
                    }
                }
            }
            .padding(24)
            .background(AppColor.surface)
            .clipShape(RoundedRectangle(cornerRadius: 16))
            .padding(.horizontal, 24)
        }
    }
}
