package plopik.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {
    @Test

    public void testArea() {
        Square s = new Square(5);
        Assert.assertEquals(s.area1(),25.0);
    }

    @Test

    public void testRectangle(){
        Rectangle r = new Rectangle(2,1);
        Assert.assertEquals(r.area1(), 2.0);
    }

    @Test

    public void testDistance(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,1);
        Assert.assertEquals(p1.distance(p2), 1.0);
    }
}
