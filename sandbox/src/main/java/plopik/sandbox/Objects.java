package plopik.sandbox;

public class Objects {
    public static void main(String[] args) {
        hello1("Hello");
        hello1("World2");
        hello1("World3");

        Square s = new Square(5);
        System.out.println(area1(s));

        Rectangle r = new Rectangle(5, 6);
        System.out.println(area1(r));

        Point p1 = new Point(5,2);
        Point p2 = new Point(2,2);
        System.out.println(point(p1,p2));


    }

    public static void hello1(String letter) {
        System.out.println(letter);
    }

    public static double area1(Square s) {
        return (s.l * s.l);
    }

    public static double area1(Rectangle r) {
        return (r.a * r.b);
    }

    public static double point(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
    }

}