package week3;

abstract class GeometricShape {
    abstract double area();
    abstract double perimeter();
}

class Triangle extends GeometricShape {
    private double base, height, side1, side2, side3;

    public Triangle(double base, double height, double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    @Override
    double perimeter() {
        return side1 + side2 + side3;
    }
}

class Square extends GeometricShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    double perimeter() {
        return 4 * side;
    }
}

class Circle extends GeometricShape {
    private double radius;
    private static final double PI = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * PI * radius;
    }
}

public class GeometricShapeTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(10, 5, 6, 8, 10);
        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());

        Square square = new Square(4);
        System.out.println("\nSquare Area: " + square.area());
        System.out.println("Square Perimeter: " + square.perimeter());

        Circle circle = new Circle(7);
        System.out.println("\nCircle Area: " + circle.area());
        System.out.println("Circle Perimeter (Circumference): " + circle.perimeter());
    }
}

