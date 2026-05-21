import SwiftUI

struct PencilIcon: View {
    var color: Color = .primary
    var size: CGFloat = 24
    
    var body: some View {
        Canvas { ctx, sz in
            let w = sz.width
            let h = sz.height
            
            // Scale stroke width based on size, with a minimum floor
            let lw = max(1.5, w * 0.08)
            let style = StrokeStyle(lineWidth: lw, lineCap: .round, lineJoin: .round)
            
            var pencil = Path()
            
            // Main Outline
            pencil.move(to: CGPoint(x: w * 0.125, y: h * 0.875)) // Bottom-left tip
            pencil.addLine(to: CGPoint(x: w * 0.250, y: h * 0.625)) // Left tip corner
            pencil.addLine(to: CGPoint(x: w * 0.625, y: h * 0.250)) // Left eraser base
            pencil.addLine(to: CGPoint(x: w * 0.750, y: h * 0.125)) // Top-left eraser
            pencil.addLine(to: CGPoint(x: w * 0.875, y: h * 0.250)) // Top-right eraser
            pencil.addLine(to: CGPoint(x: w * 0.750, y: h * 0.375)) // Right eraser base
            pencil.addLine(to: CGPoint(x: w * 0.375, y: h * 0.750)) // Right tip corner
            pencil.closeSubpath()
            
            // Eraser separator line
            pencil.move(to: CGPoint(x: w * 0.625, y: h * 0.250))
            pencil.addLine(to: CGPoint(x: w * 0.750, y: h * 0.375))
            
            // Tip separator line
            pencil.move(to: CGPoint(x: w * 0.250, y: h * 0.625))
            pencil.addLine(to: CGPoint(x: w * 0.375, y: h * 0.750))
            
            ctx.stroke(pencil, with: .color(color), style: style)
        }
        .frame(width: size, height: size)
    }
}

struct UndoIcon: View {
    var color: Color = .primary
    var size: CGFloat = 24
    var body: some View {
        Canvas { ctx, sz in
            let w = sz.width, h = sz.height
            let lw = max(1.5, w * 0.10)
            let style = StrokeStyle(lineWidth: lw, lineCap: .round, lineJoin: .round)
            var arrow = Path()
            arrow.move(to: CGPoint(x: w*0.35, y: h*0.28))
            arrow.addLine(to: CGPoint(x: w*0.18, y: h*0.44))
            arrow.addLine(to: CGPoint(x: w*0.35, y: h*0.60))
            var arc = Path()
            arc.move(to: CGPoint(x: w*0.18, y: h*0.44))
            arc.addLine(to: CGPoint(x: w*0.68, y: h*0.44))
            arc.addCurve(
                to: CGPoint(x: w*0.68, y: h*0.74),
                control1: CGPoint(x: w*0.85, y: h*0.44),
                control2: CGPoint(x: w*0.85, y: h*0.74)
            )
            arc.addLine(to: CGPoint(x: w*0.40, y: h*0.74))
            ctx.stroke(arrow, with: .color(color), style: style)
            ctx.stroke(arc, with: .color(color), style: style)
        }
        .frame(width: size, height: size)
    }
}

struct BookIcon: View {
    var color: Color = .primary
    var size: CGFloat = 24
    var body: some View {
        Canvas { ctx, sz in
            let w = sz.width, h = sz.height
            let lw = max(1.5, w * 0.065)
            var left = Path()
            left.move(to: CGPoint(x: w*0.5, y: h*0.14))
            left.addLine(to: CGPoint(x: w*0.06, y: h*0.24))
            left.addLine(to: CGPoint(x: w*0.06, y: h*0.84))
            left.addLine(to: CGPoint(x: w*0.5, y: h*0.76))
            left.closeSubpath()
            var right = Path()
            right.move(to: CGPoint(x: w*0.5, y: h*0.14))
            right.addLine(to: CGPoint(x: w*0.94, y: h*0.24))
            right.addLine(to: CGPoint(x: w*0.94, y: h*0.84))
            right.addLine(to: CGPoint(x: w*0.5, y: h*0.76))
            right.closeSubpath()
            var spine = Path()
            spine.move(to: CGPoint(x: w*0.5, y: h*0.14))
            spine.addLine(to: CGPoint(x: w*0.5, y: h*0.76))
            let style = StrokeStyle(lineWidth: lw, lineCap: .round, lineJoin: .round)
            ctx.stroke(left, with: .color(color), style: style)
            ctx.stroke(right, with: .color(color), style: style)
            ctx.stroke(spine, with: .color(color), style: StrokeStyle(lineWidth: lw * 0.6, lineCap: .round))
        }
        .frame(width: size, height: size)
    }
}

struct BooksStackIcon: View {
    var color: Color = .primary
    var size: CGFloat = 24
    var body: some View {
        Canvas { ctx, sz in
            let w = sz.width, h = sz.height
            let lw = max(1.5, w * 0.08)
            let bookW = w * 0.20
            let gap = w * 0.075
            let baseY = h * 0.88
            let configs: [(x: CGFloat, topY: CGFloat)] = [
                (w*0.08, h*0.18),
                (w*0.08 + bookW + gap, h*0.30),
                (w*0.08 + (bookW+gap)*2, h*0.22)
            ]
            for cfg in configs {
                var book = Path()
                book.addRoundedRect(
                    in: CGRect(x: cfg.x, y: cfg.topY, width: bookW, height: baseY - cfg.topY),
                    cornerSize: CGSize(width: 2, height: 2)
                )
                ctx.stroke(book, with: .color(color), style: StrokeStyle(lineWidth: lw, lineCap: .round, lineJoin: .round))
            }
            var base = Path()
            base.move(to: CGPoint(x: w*0.04, y: baseY))
            base.addLine(to: CGPoint(x: w*0.96, y: baseY))
            ctx.stroke(base, with: .color(color), style: StrokeStyle(lineWidth: lw, lineCap: .round))
        }
        .frame(width: size, height: size)
    }
}

struct PlusIcon: View {
    var color: Color = .primary
    var size: CGFloat = 24
    var body: some View {
        Canvas { ctx, sz in
            let w = sz.width, h = sz.height
            let lw = max(2, w * 0.13)
            let style = StrokeStyle(lineWidth: lw, lineCap: .round)
            var h_line = Path()
            h_line.move(to: CGPoint(x: w*0.22, y: h*0.5))
            h_line.addLine(to: CGPoint(x: w*0.78, y: h*0.5))
            var v_line = Path()
            v_line.move(to: CGPoint(x: w*0.5, y: h*0.22))
            v_line.addLine(to: CGPoint(x: w*0.5, y: h*0.78))
            ctx.stroke(h_line, with: .color(color), style: style)
            ctx.stroke(v_line, with: .color(color), style: style)
        }
        .frame(width: size, height: size)
    }
}

struct TrashIcon: View {
    var color: Color = .primary
    var size: CGFloat = 24
    var body: some View {
        Canvas { ctx, sz in
            let w = sz.width, h = sz.height
            let lw = max(1.5, w * 0.09)
            let style = StrokeStyle(lineWidth: lw, lineCap: .round, lineJoin: .round)
            var bin = Path()
            bin.move(to: CGPoint(x: w*0.20, y: h*0.30))
            bin.addLine(to: CGPoint(x: w*0.26, y: h*0.87))
            bin.addLine(to: CGPoint(x: w*0.74, y: h*0.87))
            bin.addLine(to: CGPoint(x: w*0.80, y: h*0.30))
            var lid = Path()
            lid.move(to: CGPoint(x: w*0.11, y: h*0.30))
            lid.addLine(to: CGPoint(x: w*0.89, y: h*0.30))
            var handle = Path()
            handle.move(to: CGPoint(x: w*0.38, y: h*0.30))
            handle.addLine(to: CGPoint(x: w*0.38, y: h*0.17))
            handle.addLine(to: CGPoint(x: w*0.62, y: h*0.17))
            handle.addLine(to: CGPoint(x: w*0.62, y: h*0.30))
            ctx.stroke(bin, with: .color(color), style: style)
            ctx.stroke(lid, with: .color(color), style: StrokeStyle(lineWidth: lw, lineCap: .round))
            ctx.stroke(handle, with: .color(color), style: style)
        }
        .frame(width: size, height: size)
    }
}

struct ChevronLeftIcon: View {
    var color: Color = .primary
    var size: CGFloat = 24
    var body: some View {
        Canvas { ctx, sz in
            let w = sz.width, h = sz.height
            var path = Path()
            path.move(to: CGPoint(x: w*0.63, y: h*0.22))
            path.addLine(to: CGPoint(x: w*0.37, y: h*0.50))
            path.addLine(to: CGPoint(x: w*0.63, y: h*0.78))
            ctx.stroke(path, with: .color(color), style: StrokeStyle(lineWidth: max(2, w*0.11), lineCap: .round, lineJoin: .round))
        }
        .frame(width: size, height: size)
    }
}

struct ChevronRightIcon: View {
    var color: Color = .primary
    var size: CGFloat = 24
    var body: some View {
        Canvas { ctx, sz in
            let w = sz.width, h = sz.height
            var path = Path()
            path.move(to: CGPoint(x: w*0.37, y: h*0.22))
            path.addLine(to: CGPoint(x: w*0.63, y: h*0.50))
            path.addLine(to: CGPoint(x: w*0.37, y: h*0.78))
            ctx.stroke(path, with: .color(color), style: StrokeStyle(lineWidth: max(2, w*0.11), lineCap: .round, lineJoin: .round))
        }
        .frame(width: size, height: size)
    }
}
