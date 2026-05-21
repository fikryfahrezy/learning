import SwiftUI
import shared

struct ContentView: View {

    private let repository: any PdfRepository
    private let annotationRepository: any AnnotationRepository

    init() {
        let documentsDir = FileManager.default
            .urls(for: .documentDirectory, in: .userDomainMask)
            .first!
            .path
        self.repository = SharedPdfRepository(storageDirectory: documentsDir)
        self.annotationRepository = SharedAnnotationRepository(storageDirectory: documentsDir)
    }

    var body: some View {
        PdfListView(repository: repository, annotationRepository: annotationRepository)
    }
}
