package plopik.lms365.sandbox;

public class Functions {
    public static void main(String[] args){
        hello("Hello");
        hello("World2");
        hello("World3");

//        int a = 5;
        System.out.println(area(5));
        System.out.println(area(5, 6));


    }

    public static void hello(String letter) {
        System.out.println(letter);
    }

    public static double area(Integer a) {
        return (a * a);
    }

    public static double area (Integer a, Integer b) { //used the same title of function because different parameters are used in each function
        return (a * b);
    }

}
