package week2;

class Shape {
    protected double area;

    public void calculateArea() {
        System.out.println("Area calculation is not defined for generic shapes.");
    }

    public void displayArea() {
        System.out.println("Area: " + area);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        area = length * width;
    }
}

public class ShapeInherit {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        circle.calculateArea();
        System.out.print("Circle: ");
        circle.displayArea();

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        rectangle.calculateArea();
        System.out.print("Rectangle: ");
        rectangle.displayArea();
    }
}


