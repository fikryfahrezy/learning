import SwiftUI
import shared

private let penColors = ["#FFFF0000", "#FF0000FF", "#FF000000", "#FF00AA00"]
private let penWidths: [CGFloat] = [2, 4, 8]

struct PdfReaderView: View {

    let documentId: String
    let repository: any PdfRepository
    let annotationRepository: any AnnotationRepository

    @StateObject private var viewModel: PdfReaderObservableViewModel
    @State private var showJumpDialog = false
    @State private var jumpPageInput = ""
    @Environment(\.dismiss) private var dismiss

    init(documentId: String, repository: any PdfRepository, annotationRepository: any AnnotationRepository) {
        self.documentId = documentId
        self.repository = repository
        self.annotationRepository = annotationRepository
        _viewModel = StateObject(wrappedValue: PdfReaderObservableViewModel(
            repository: repository,
            annotationRepository: annotationRepository,
            documentId: documentId
        ))
    }

    var body: some View {
        VStack(spacing: 0) {
            AppTopBar(
                title: viewModel.document?.title ?? "",
                onBack: { dismiss() }
            ) {
                if !viewModel.isLoading {
                    Button(action: viewModel.toggleAnnotationMode) {
                        PencilIcon(
                            color: viewModel.isAnnotating ? AppColor.onPrimary : AppColor.onPrimary.opacity(0.5),
                            size: 24
                        )
                        .frame(width: 44, height: 44)
                    }
                    Button("\(viewModel.currentPage) / \(viewModel.totalPages)") {
                        jumpPageInput = "\(viewModel.currentPage)"
                        showJumpDialog = true
                    }
                    .font(.system(size: AppFontSize.bodyMedium))
                    .foregroundColor(AppColor.onPrimary)
                    .padding(.trailing, AppSpacing.sm)
                }
            }

            if viewModel.isAnnotating {
                AnnotationToolbar(
                    penColor: viewModel.penColor,
                    penWidth: viewModel.penWidth,
                    canUndo: !viewModel.pageStrokes.isEmpty,
                    onColorSelect: viewModel.setPenColor,
                    onWidthSelect: viewModel.setPenWidth,
                    onUndo: viewModel.undoLastStroke,
                    onClear: viewModel.clearPageAnnotations,
                    onDone: viewModel.toggleAnnotationMode
                )
            }

            ZStack {
                Color(white: 0.17).ignoresSafeArea()

                if viewModel.isLoading {
                    AppLoadingIndicator(tint: .white)
                } else if let error = viewModel.errorMessage {
                    Text(error).foregroundColor(AppColor.error)
                } else if let document = viewModel.document {
                    PdfPageView(
                        document: document,
                        pageIndex: viewModel.currentPageIndex,
                        repository: repository,
                        isAnnotating: viewModel.isAnnotating,
                        strokes: viewModel.pageStrokes,
                        penColor: viewModel.penColor,
                        penWidth: viewModel.penWidth,
                        onStrokeComplete: viewModel.addStroke
                    )
                }
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
        }
        .toolbar(.hidden, for: .navigationBar)
        .safeAreaInset(edge: .bottom) {
            if !viewModel.isLoading && viewModel.document != nil {
                PageNavigationBar(
                    canGoPrevious: viewModel.canGoPrevious,
                    canGoNext: viewModel.canGoNext,
                    progress: viewModel.progress,
                    onPrevious: viewModel.previousPage,
                    onNext: viewModel.nextPage
                )
            }
        }
        .alert(AppStrings.jumpToPage, isPresented: $showJumpDialog) {
            TextField("1 – \(viewModel.totalPages)", text: $jumpPageInput)
                .keyboardType(.numberPad)
            Button(AppStrings.go) {
                if let page = Int(jumpPageInput), page >= 1, page <= viewModel.totalPages {
                    viewModel.jumpToPage(page - 1)
                }
            }
            Button(AppStrings.cancel, role: .cancel) {}
        }
    }
}

struct AnnotationToolbar: View {
    let penColor: String
    let penWidth: CGFloat
    let canUndo: Bool
    let onColorSelect: (String) -> Void
    let onWidthSelect: (CGFloat) -> Void
    let onUndo: () -> Void
    let onClear: () -> Void
    let onDone: () -> Void

    var body: some View {
        ScrollView(.horizontal, showsIndicators: false) {
            HStack(spacing: AppSpacing.xs) {
                ForEach(penColors, id: \.self) { hex in
                    let selected = hex == penColor
                    Circle()
                        .fill(parseAnnotationColor(hex))
                        .frame(width: selected ? 28 : 24, height: selected ? 28 : 24)
                        .overlay(Circle().stroke(AppColor.primary, lineWidth: selected ? 2 : 0))
                        .onTapGesture { onColorSelect(hex) }
                }

                Divider().frame(height: 24).padding(.horizontal, AppSpacing.xs)

                ForEach(penWidths, id: \.self) { w in
                    let selected = abs(w - penWidth) < 0.1
                    ZStack {
                        Circle()
                            .fill(selected ? AppColor.surfaceVariant : Color.clear)
                            .frame(width: 32, height: 32)
                        Capsule()
                            .fill(AppColor.onSurface)
                            .frame(width: 18, height: w.clamped(to: 1...6))
                    }
                    .onTapGesture { onWidthSelect(w) }
                }

                Divider().frame(height: 24).padding(.horizontal, AppSpacing.xs)

                Button(action: onUndo) {
                    UndoIcon(color: canUndo ? AppColor.onSurface : AppColor.outline, size: 20)
                        .frame(width: 36, height: 36)
                }
                .disabled(!canUndo)

                Button(action: onClear) {
                    TrashIcon(color: canUndo ? AppColor.error : AppColor.outline, size: 20)
                        .frame(width: 36, height: 36)
                }
                .disabled(!canUndo)

                Spacer().frame(width: AppSpacing.sm)

                Button(AppStrings.done) { onDone() }
                    .font(.system(size: AppFontSize.bodyMedium, weight: .medium))
                    .foregroundColor(AppColor.primary)
                    .padding(.trailing, AppSpacing.sm)
            }
            .padding(.horizontal, AppSpacing.md)
            .padding(.vertical, AppSpacing.xs)
        }
        .frame(height: 48)
        .background(AppColor.surface)
    }
}

struct PdfPageView: View {

    let document: PdfDocument
    let pageIndex: Int
    let repository: any PdfRepository
    let isAnnotating: Bool
    let strokes: [AnnotationStroke]
    let penColor: String
    let penWidth: CGFloat
    let onStrokeComplete: (AnnotationStroke) -> Void

    @State private var pageImage: UIImage? = nil
    @State private var isPageLoading = true
    @State private var scale: CGFloat = 1.0
    @State private var lastScale: CGFloat = 1.0
    @State private var offset: CGSize = .zero
    @State private var lastOffset: CGSize = .zero

    var body: some View {
        GeometryReader { geo in
            ZStack {
                if isPageLoading {
                    AppLoadingIndicator(tint: .white)
                } else if let img = pageImage {
                    // Compute the exact area the PDF image occupies after scaledToFit + padding,
                    // so DrawingCanvas is constrained to the PDF page and not the dark surround.
                    let sm = CGFloat(AppSpacing.sm)
                    let availW = geo.size.width - 2 * sm
                    let availH = geo.size.height - 2 * sm
                    let imgAspect = img.size.width / img.size.height
                    let pdfW: CGFloat = availW / availH <= imgAspect ? availW : availH * imgAspect
                    let pdfH: CGFloat = availW / availH <= imgAspect ? availW / imgAspect : availH
                    ZStack {
                        Image(uiImage: img)
                            .resizable()
                            .scaledToFit()
                            .frame(maxWidth: .infinity, maxHeight: .infinity)
                            .padding(sm)
                        DrawingCanvas(
                            strokes: strokes,
                            isDrawingEnabled: isAnnotating,
                            penColor: penColor,
                            penWidth: penWidth,
                            onStrokeComplete: onStrokeComplete
                        )
                        .frame(width: pdfW, height: pdfH)
                    }
                    .scaleEffect(scale)
                    .offset(offset)
                    .gesture(
                        isAnnotating ? nil :
                        MagnificationGesture()
                            .onChanged { value in
                                scale = (lastScale * value).clamped(to: 1.0...5.0)
                            }
                            .onEnded { _ in lastScale = scale }
                            .simultaneously(with:
                                DragGesture()
                                    .onChanged { value in
                                        offset = CGSize(
                                            width: lastOffset.width + value.translation.width,
                                            height: lastOffset.height + value.translation.height
                                        )
                                    }
                                    .onEnded { _ in lastOffset = offset }
                            )
                    )
                    .onTapGesture(count: 2) {
                        guard !isAnnotating else { return }
                        withAnimation(.spring()) {
                            scale = 1.0; lastScale = 1.0
                            offset = .zero; lastOffset = .zero
                        }
                    }
                }
            }
            .frame(width: geo.size.width, height: geo.size.height)
            .clipped()
        }
        .task(id: pageIndex) { await loadPage() }
        .onChange(of: pageIndex) { _ in
            withAnimation(.none) {
                scale = 1.0; lastScale = 1.0
                offset = .zero; lastOffset = .zero
            }
        }
    }

    private func loadPage() async {
        isPageLoading = true
        pageImage = nil
        let bytes = try? await repository.renderPage(
            document: document,
            pageIndex: Int32(pageIndex),
            targetWidth: 1200,
            targetHeight: 1600
        )
        if let bytes, let data = bytes.toData() {
            pageImage = UIImage(data: data)
        }
        isPageLoading = false
    }
}

struct PageNavigationBar: View {

    let canGoPrevious: Bool
    let canGoNext: Bool
    let progress: Double
    let onPrevious: () -> Void
    let onNext: () -> Void

    var body: some View {
        HStack(spacing: AppSpacing.md) {
            Button(action: onPrevious) {
                ChevronLeftIcon(
                    color: canGoPrevious ? AppColor.primary : AppColor.outline,
                    size: 24
                )
                .frame(width: 44, height: 44)
            }
            .disabled(!canGoPrevious)

            GeometryReader { geo in
                ZStack(alignment: .leading) {
                    Capsule().fill(AppColor.surfaceVariant).frame(height: 4)
                    Capsule()
                        .fill(AppColor.primary)
                        .frame(width: max(4, geo.size.width * CGFloat(progress)), height: 4)
                }
            }
            .frame(maxWidth: .infinity, maxHeight: 4)

            Button(action: onNext) {
                ChevronRightIcon(
                    color: canGoNext ? AppColor.primary : AppColor.outline,
                    size: 24
                )
                .frame(width: 44, height: 44)
            }
            .disabled(!canGoNext)
        }
        .padding(.horizontal, AppSpacing.md)
        .padding(.vertical, AppSpacing.sm)
        .background(AppColor.surface)
        .shadow(color: .black.opacity(0.08), radius: 4, y: -2)
    }
}

private extension Comparable {
    func clamped(to range: ClosedRange<Self>) -> Self {
        min(max(self, range.lowerBound), range.upperBound)
    }
}

