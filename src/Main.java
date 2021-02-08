
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static ArrayList<Shape> shapeList = new ArrayList<Shape>();
    static Graphics graphics;

    public static void addToList(ArrayList shapeList, Object fig)
    {

        shapeList.add(fig);

        System.out.println(shapeList);

    }

    public static void drawFigures(ArrayList<Shape> list)
    {
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i).type) {
                case "CIRCLE":
                    graphics.drawOval(list.get(i).x, list.get(i).y, list.get(i).width, list.get(i).height);
                    break;
                case "RECT":
                    graphics.drawRect(list.get(i).x, list.get(i).y, list.get(i).width, list.get(i).height);
                    break;
                case "TRIANGLE":

                    break;

            }

        }
    }

    public static void main(String[] args) {
        // write your code here
        new Window();
        addToList(shapeList, new Circle(10,10,40,40, "CIRCLE"));
        addToList(shapeList, new Rect(10,10,40,40, "RECT"));
        // addToList(shapeList, new Triangle(10,10,40,40,"TRIANGLE"));
        drawFigures(shapeList);

        System.out.println("");

    }
}

class Window extends JFrame{
    public Window(){setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }
    public void paint (Graphics g){
          g.drawRect(100,200,80,60);
           g.drawOval(40, 100, 60, 60);
           g.drawPolygon(new int[] {150, 200, 250}, new int[] {100, 50, 100}, 3);


    }



}


class Shape {
    int x;
    int y;
    int width;
    int height;
    String type;


    public Shape(int x, int y, int width, int height, String type) {
        x = x;
        y = y;
        width = width;
        height = height;
        type = type;
    }




}

class Triangle extends Shape {
    public Triangle(int x, int y, int width, int height, String type) {
        super(x, y, width, height, type);
    }

}

class Circle extends Shape {
    public Circle(int x, int y, int width, int height, String type) {
        super(x, y, width, height, type);
    }

}

class Rect extends Shape {
    public Rect(int x, int y, int width, int height, String type) {
        super(x, y, width, height, type);
    }

}
