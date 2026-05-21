import SwiftUI
import shared

struct DrawingCanvas: View {
    let strokes: [AnnotationStroke]
    let isDrawingEnabled: Bool
    var penColor: String = "#FFFF0000"
    var penWidth: CGFloat = 4
    var onStrokeComplete: (AnnotationStroke) -> Void = { _ in }

    // Normalized (0-1) points for the stroke currently being drawn
    @State private var currentPoints: [(x: Float, y: Float)] = []

    var body: some View {
        GeometryReader { geo in
            Canvas { ctx, size in
                drawStrokes(ctx: ctx, size: size, strokes: strokes)
                if currentPoints.count >= 2 {
                    drawCurrentStroke(ctx: ctx, size: size)
                }
            }
            .gesture(
                DragGesture(minimumDistance: 0)
                    .onChanged { value in
                        guard isDrawingEnabled else { return }
                        currentPoints.append((
                            x: Float(value.location.x / geo.size.width),
                            y: Float(value.location.y / geo.size.height)
                        ))
                    }
                    .onEnded { _ in
                        defer { currentPoints = [] }
                        guard isDrawingEnabled, currentPoints.count >= 2 else { return }
                        let builder = AnnotationStrokeBuilder()
                        for p in currentPoints { builder.addPoint(x: p.x, y: p.y) }
                        if let stroke = builder.build(colorHex: penColor, strokeWidth: Float(penWidth)) {
                            onStrokeComplete(stroke)
                        }
                    }
            )
        }
        .allowsHitTesting(isDrawingEnabled)
    }

    private func drawStrokes(ctx: GraphicsContext, size: CGSize, strokes: [AnnotationStroke]) {
        for stroke in strokes {
            let points = stroke.points as! [AnnotationPoint]
            guard points.count >= 2 else { continue }
            var path = Path()
            path.move(to: CGPoint(x: CGFloat(points[0].x) * size.width, y: CGFloat(points[0].y) * size.height))
            for point in points.dropFirst() {
                path.addLine(to: CGPoint(x: CGFloat(point.x) * size.width, y: CGFloat(point.y) * size.height))
            }
            ctx.stroke(path, with: .color(parseAnnotationColor(stroke.colorHex)), style: StrokeStyle(
                lineWidth: CGFloat(stroke.strokeWidth), lineCap: .round, lineJoin: .round
            ))
        }
    }

    private func drawCurrentStroke(ctx: GraphicsContext, size: CGSize) {
        var path = Path()
        path.move(to: CGPoint(x: CGFloat(currentPoints[0].x) * size.width, y: CGFloat(currentPoints[0].y) * size.height))
        for p in currentPoints.dropFirst() {
            path.addLine(to: CGPoint(x: CGFloat(p.x) * size.width, y: CGFloat(p.y) * size.height))
        }
        ctx.stroke(path, with: .color(parseAnnotationColor(penColor)), style: StrokeStyle(
            lineWidth: penWidth, lineCap: .round, lineJoin: .round
        ))
    }
}

func parseAnnotationColor(_ hex: String) -> Color {
    let clean = hex.trimmingCharacters(in: CharacterSet(charactersIn: "#"))
    let full = clean.count == 6 ? "FF" + clean : clean
    guard full.count == 8, let value = UInt64(full, radix: 16) else { return .red }
    let a = Double((value >> 24) & 0xFF) / 255.0
    let r = Double((value >> 16) & 0xFF) / 255.0
    let g = Double((value >> 8) & 0xFF) / 255.0
    let b = Double(value & 0xFF) / 255.0
    return Color(red: r, green: g, blue: b, opacity: a)
}
