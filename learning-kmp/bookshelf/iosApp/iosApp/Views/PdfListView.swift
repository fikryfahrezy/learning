import SwiftUI
import UniformTypeIdentifiers
import shared

struct PdfListView: View {

    @StateObject private var viewModel: PdfListObservableViewModel
    @State private var isPickerPresented = false
    @State private var documentToDelete: PdfDocument? = nil
    private let repository: any PdfRepository
    private let annotationRepository: any AnnotationRepository

    init(repository: any PdfRepository, annotationRepository: any AnnotationRepository) {
        self.repository = repository
        self.annotationRepository = annotationRepository
        _viewModel = StateObject(wrappedValue: PdfListObservableViewModel(
            repository: repository,
            annotationRepository: annotationRepository
        ))
    }

    var body: some View {
        NavigationStack {
            VStack(spacing: 0) {
                AppTopBar(title: AppStrings.appName)

                ZStack(alignment: .bottomTrailing) {
                    AppColor.background.ignoresSafeArea()

                    if viewModel.isLoading {
                        AppLoadingIndicator()
                            .frame(maxWidth: .infinity, maxHeight: .infinity)
                    } else if viewModel.documents.isEmpty {
                        EmptyLibraryView()
                            .frame(maxWidth: .infinity, maxHeight: .infinity)
                    } else {
                        ScrollView {
                            LazyVGrid(
                                columns: [GridItem(.adaptive(minimum: 160), spacing: AppSpacing.md)],
                                spacing: AppSpacing.md
                            ) {
                                ForEach(viewModel.documents, id: \.id) { doc in
                                    NavigationLink(destination: PdfReaderView(
                                        documentId: doc.id,
                                        repository: repository,
                                        annotationRepository: annotationRepository
                                    )) {
                                        PdfBookCard(
                                            document: doc,
                                            repository: repository,
                                            onDelete: { documentToDelete = doc }
                                        )
                                    }
                                    .buttonStyle(.plain)
                                }
                            }
                            .padding(AppSpacing.md)
                            .padding(.bottom, 80)
                        }
                    }

                    AppFab(action: { isPickerPresented = true }) {
                        PlusIcon(color: .white, size: 24)
                    }
                    .padding(AppSpacing.md)
                }
                .frame(maxWidth: .infinity, maxHeight: .infinity)
            }
            .toolbar(.hidden, for: .navigationBar)
            .fileImporter(
                isPresented: $isPickerPresented,
                allowedContentTypes: [UTType.pdf],
                allowsMultipleSelection: false
            ) { result in
                handlePickedFile(result: result)
            }
        }
        .overlay {
            if let doc = documentToDelete {
                AppDialog(
                    title: AppStrings.removeBook,
                    message: AppStrings.removeBookMessage,
                    confirmLabel: AppStrings.delete,
                    onConfirm: {
                        viewModel.deleteDocument(id: doc.id)
                        documentToDelete = nil
                    },
                    onDismiss: { documentToDelete = nil },
                    confirmIsDestructive: true
                )
            }
        }
    }

    private func handlePickedFile(result: Result<[URL], Error>) {
        guard case .success(let urls) = result, let url = urls.first else { return }
        guard url.startAccessingSecurityScopedResource() else { return }
        defer { url.stopAccessingSecurityScopedResource() }

        let displayName = url.deletingPathExtension().lastPathComponent
        let tempURL = FileManager.default.temporaryDirectory
            .appendingPathComponent(UUID().uuidString + ".pdf")

        do {
            try FileManager.default.copyItem(at: url, to: tempURL)
            Task {
                try? await repository.addDocument(
                    localFilePath: tempURL.path,
                    displayName: displayName
                )
            }
        } catch {
            print("Failed to copy PDF: \(error)")
        }
    }
}

struct PdfBookCard: View {

    let document: PdfDocument
    let repository: any PdfRepository
    let onDelete: () -> Void

    @State private var thumbnail: UIImage? = nil

    var body: some View {
        VStack(alignment: .leading, spacing: 0) {
            ZStack {
                AppColor.surfaceVariant
                    .frame(maxWidth: .infinity)
                    .frame(height: 200)

                if let img = thumbnail {
                    Image(uiImage: img)
                        .resizable()
                        .scaledToFit()
                        .frame(maxWidth: .infinity)
                        .frame(height: 200)
                } else {
                    BookIcon(color: AppColor.onSurfaceVariant, size: 52)
                }
            }

            VStack(alignment: .leading, spacing: 2) {
                Text(document.title)
                    .font(.system(size: AppFontSize.titleSmall, weight: .medium))
                    .foregroundColor(AppColor.onSurface)
                    .lineLimit(1)

                Text("\(document.pageCount) \(AppStrings.pages) · \(document.formattedSize)")
                    .font(.system(size: AppFontSize.labelSmall))
                    .foregroundColor(AppColor.onSurfaceVariant)
            }
            .padding(.horizontal, AppSpacing.sm)
            .padding(.top, AppSpacing.sm)

            HStack {
                Spacer()
                Button(action: onDelete) {
                    TrashIcon(color: AppColor.error, size: 18)
                        .frame(width: 32, height: 32)
                }
                .padding([.bottom, .trailing], AppSpacing.sm)
            }
        }
        .background(AppColor.surface)
        .clipShape(RoundedRectangle(cornerRadius: AppRadius.md))
        .shadow(color: .black.opacity(0.08), radius: 4, x: 0, y: 2)
        .task {
            await loadThumbnail()
        }
    }

    private func loadThumbnail() async {
        let bytes = try? await repository.renderThumbnail(
            document: document,
            targetWidth: 320,
            targetHeight: 440
        )
        if let bytes, let data = bytes.toData() {
            thumbnail = UIImage(data: data)
        }
    }
}

struct EmptyLibraryView: View {
    var body: some View {
        VStack(spacing: AppSpacing.md) {
            BooksStackIcon(color: AppColor.outline, size: 72)

            Text(AppStrings.emptyTitle)
                .font(.system(size: AppFontSize.titleMedium, weight: .medium))
                .foregroundColor(AppColor.onSurface)

            Text(AppStrings.emptySubtitle)
                .font(.system(size: AppFontSize.bodyMedium))
                .foregroundColor(AppColor.onSurfaceVariant)
                .multilineTextAlignment(.center)
        }
        .padding(AppSpacing.xl)
    }
}

extension KotlinByteArray {
    func toData() -> Data? {
        var bytes = [UInt8](repeating: 0, count: Int(self.size))
        for i in 0..<Int(self.size) {
            bytes[i] = UInt8(bitPattern: self.get(index: Int32(i)))
        }
        return Data(bytes)
    }
}
