import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Main {
    static Graphics graphics;

    public static void main(String[] args) {
        // write your code here
        Window window = new Window();
        window.paint(graphics);
    }
}

class Window extends JFrame {
    public Window() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(100, 200, 80, 60));
        shapes.add(new Circle(40, 100, 60));
        shapes.add(new Triangle(150, 200, 50, 50));

        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}

enum ShapeType {
    RECTANGLE, CIRCLE, TRIANGLE, POLYGON
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

abstract class Shape {
    int x;
    int y;
    int width;
    int height;
    ShapeType type;

    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    abstract void draw(Graphics g);

    abstract double getArea();

    abstract double getCircumference();

    abstract Point getCenter();

    abstract boolean containsPoint(Point point);

    double distanceTo(Shape shape) {
        return this.y - shape.y;

        //return this.getCenter() math.sqrt() shape.getCenter(); // Euclidean distance from this circles center to other shapes center.

    }
}

class Triangle extends Shape {
    public Triangle(int x, int y, int width, int height) {
        super(x, y, width, height);
        type = ShapeType.TRIANGLE;
    }

    @Override
    void draw(Graphics g) {
        g.drawPolygon(new int[]{150, 200, 250}, new int[]{100, 50, 100}, 3);

    }

    @Override
    double getArea() {
        return 1 / 2 * height * width;
    }

    @Override
    double getCircumference() {
        return 100 + 50 + 50;
    }

    @Override
    Point getCenter() {
        return null;
    }

    @Override
    boolean containsPoint(Point point) {
        return false;
    }

}

class Circle extends Shape {
    public Circle(int x, int y, int radius) {
        super(x, y, radius, radius);
        type = ShapeType.CIRCLE;
    }

    @Override
    void draw(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(width, 2);
    }

    @Override
    double getCircumference() {
        return 2 * Math.PI * width;
    }

    @Override
    Point getCenter() {
        return new Point(x, y);
    }

    @Override
    boolean containsPoint(Point point) {
        return true; // Euclidean distance from circle center to point < circles radius
    }

}

class Rectangle extends Shape {
    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
        type = ShapeType.RECTANGLE;
    }

    @Override
    void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    @Override
    double getArea() {

        return width * height;
    }

    @Override
    double getCircumference() {
        return width + width + height + height;
    }

    @Override
    Point getCenter() {
        return null;
    }

    @Override
    boolean containsPoint(Point point) {
        return false;
    }

}
