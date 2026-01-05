package week3;

class Point {
    private int xInt;
    private int yInt;
    private double xDouble;
    private double yDouble;

    // Constructor with int parameters
    public Point(int x, int y) {
        this.xInt = x;
        this.yInt = y;
        System.out.println("Point (x, y): (" + xInt + ", " + yInt + ")");
    }

    // Constructor with double parameters
    public Point(double x, double y) {
        this.xDouble = x;
        this.yDouble = y;
        System.out.println("Point (x, y): (" + (int)xDouble + ", " + (int)yDouble + ")");
    }

    public static void main(String[] args) {
        Point intPoint = new Point(4, 5); // Calls the constructor with int parameters
        Point doublePoint = new Point(4.0, 5.0); // Calls the constructor with double parameters
    }
}

