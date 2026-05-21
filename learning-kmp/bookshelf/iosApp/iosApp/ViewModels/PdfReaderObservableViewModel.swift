import Foundation
import shared

@MainActor
final class PdfReaderObservableViewModel: ObservableObject {

    @Published private(set) var document: PdfDocument? = nil
    @Published private(set) var currentPageIndex: Int = 0
    @Published private(set) var isLoading: Bool = true
    @Published var errorMessage: String? = nil
    @Published private(set) var pageStrokes: [AnnotationStroke] = []
    @Published private(set) var isAnnotating: Bool = false
    @Published private(set) var penColor: String = "#FFFF0000"
    @Published private(set) var penWidth: CGFloat = 4

    var currentPage: Int { currentPageIndex + 1 }
    var totalPages: Int { Int(document?.pageCount ?? 0) }
    var canGoPrevious: Bool { currentPageIndex > 0 }
    var canGoNext: Bool { currentPageIndex < totalPages - 1 }
    var progress: Double {
        guard totalPages > 0 else { return 0 }
        return Double(currentPage) / Double(totalPages)
    }

    private let sharedViewModel: PdfReaderViewModel
    private var cancellationToken: CancellationToken?

    init(repository: any PdfRepository, annotationRepository: any AnnotationRepository, documentId: String) {
        self.sharedViewModel = PdfReaderViewModel(
            repository: repository,
            annotationRepository: annotationRepository,
            documentId: documentId
        )
        let initialState = sharedViewModel.state.value as! PdfReaderState
        self.document = initialState.document
        self.currentPageIndex = Int(initialState.currentPageIndex)
        self.isLoading = initialState.isLoading
        self.isAnnotating = initialState.isAnnotating
        self.penColor = initialState.penColor
        self.penWidth = CGFloat(initialState.penWidth)

        cancellationToken = FlowUtilKt.observe(sharedViewModel.state) { [weak self] rawState in
            guard let self else { return }
            let state = rawState as! PdfReaderState
            Task { @MainActor in
                self.document = state.document
                self.currentPageIndex = Int(state.currentPageIndex)
                self.isLoading = state.isLoading
                self.errorMessage = state.errorMessage
                self.pageStrokes = state.pageStrokes as! [AnnotationStroke]
                self.isAnnotating = state.isAnnotating
                self.penColor = state.penColor
                self.penWidth = CGFloat(state.penWidth)
            }
        }
    }

    func jumpToPage(_ pageIndex: Int) { sharedViewModel.jumpToPage(pageIndex: Int32(pageIndex)) }
    func nextPage() { sharedViewModel.nextPage() }
    func previousPage() { sharedViewModel.previousPage() }
    func toggleAnnotationMode() { sharedViewModel.toggleAnnotationMode() }
    func setPenColor(_ colorHex: String) { sharedViewModel.setPenColor(colorHex: colorHex) }
    func setPenWidth(_ width: CGFloat) { sharedViewModel.setPenWidth(width: Float(width)) }
    func addStroke(_ stroke: AnnotationStroke) { sharedViewModel.addStroke(stroke: stroke) }
    func undoLastStroke() { sharedViewModel.undoLastStroke() }
    func clearPageAnnotations() { sharedViewModel.clearPageAnnotations() }

    deinit {
        cancellationToken?.cancel()
        sharedViewModel.onDestroy()
    }
}
