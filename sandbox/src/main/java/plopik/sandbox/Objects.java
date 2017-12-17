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

}