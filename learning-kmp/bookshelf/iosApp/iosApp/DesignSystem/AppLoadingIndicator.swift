import SwiftUI

struct AppLoadingIndicator: View {
    var tint: Color? = nil

    var body: some View {
        if let tint {
            ProgressView().tint(tint)
        } else {
            ProgressView()
        }
    }
}
