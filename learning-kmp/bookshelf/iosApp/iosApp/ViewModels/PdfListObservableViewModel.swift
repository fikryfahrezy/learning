import Foundation
import shared

@MainActor
final class PdfListObservableViewModel: ObservableObject {

    @Published private(set) var documents: [PdfDocument] = []
    @Published private(set) var isLoading: Bool = true
    @Published var errorMessage: String? = nil

    private let sharedViewModel: PdfListViewModel
    private var cancellationToken: CancellationToken?

    init(repository: any PdfRepository, annotationRepository: any AnnotationRepository) {
        self.sharedViewModel = PdfListViewModel(repository: repository, annotationRepository: annotationRepository)
        let initial = sharedViewModel.state.value as! PdfListState
        self.documents = initial.documents as! [PdfDocument]
        self.isLoading = initial.isLoading

        cancellationToken = FlowUtilKt.observe(sharedViewModel.state) { [weak self] rawState in
            guard let self else { return }
            let state = rawState as! PdfListState
            Task { @MainActor in
                self.documents = state.documents as! [PdfDocument]
                self.isLoading = state.isLoading
                self.errorMessage = state.errorMessage
            }
        }
    }

    func deleteDocument(id: String) { sharedViewModel.deleteDocument(documentId: id) }
    func clearError() { sharedViewModel.clearError() }

    deinit {
        cancellationToken?.cancel()
        sharedViewModel.onDestroy()
    }
}
