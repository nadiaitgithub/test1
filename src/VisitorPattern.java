import java.util.ArrayList;
import java.util.List;

interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Square square);
    void visit(Triangle triangle);
}

interface Shape {
    void accept(ShapeVisitor visitor);
}

class Circle implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Square implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Triangle implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Visitor
class AreaCalculator implements ShapeVisitor {
    private double totalArea = 0;
    double radiusOfCircle = 5;
    double sideOfSquare = 4;
    double baseOfTriangle = 3;
    double heightOfTriangle = 6;

    @Override
    public void visit(Circle circle) {
        // Calculate area of circle and update totalArea
        totalArea += Math.PI * Math.pow(radiusOfCircle, 2);
    }

    @Override
    public void visit(Square square) {
        // Calculate area of square and update totalArea
        totalArea += Math.pow(sideOfSquare, 2);
    }

    @Override
    public void visit(Triangle triangle) {
        // Calculate area of triangle and update totalArea
        totalArea += (baseOfTriangle * heightOfTriangle) / 2;
    }

    public double getTotalArea() {
        return totalArea;
    }
}

// Main class
public class VisitorPattern {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Square());
        shapes.add(new Triangle());

        AreaCalculator areaCalculator = new AreaCalculator();
        for (Shape shape : shapes) {
            shape.accept(areaCalculator);
        }

        System.out.println("Total area: " + areaCalculator.getTotalArea());
    }
}
