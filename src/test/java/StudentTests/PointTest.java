package StudentTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Point;
import util.Vector;


class PointTest 
{
	@Test
    public void createRandom() 
	{
        int maxX = 10;
        int maxY = 10;
        Point randomPoint = Point.createRandom(maxX, maxY);
        assertTrue(randomPoint.getX() >= 0 && randomPoint.getX() < maxX);
        assertTrue(randomPoint.getY() >= 0 && randomPoint.getY() < maxY);
    }

    @Test
    public void getX() 
    {
        Point point = new Point(3, 4);
        assertEquals(3, point.getX());
    }

    @Test
    public void getY() 
    {
        Point point = new Point(3, 4);
        assertEquals(4, point.getY());
    }

    @Test
    public void move() 
    {
        Point point = new Point(3, 4);
        Vector displacement = new Vector(2, 3);
        Point movedPoint = point.move(displacement);
        assertEquals(new Point(5, 7), movedPoint);
    }

    @Test
    public void distanceSquared() 
    {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(6, 8);
        assertEquals(25, point1.distanceSquared(point2));
    }

    @Test
    public void equals() 
    {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        assertTrue(point1.equals(point2));
    }

    @Test
    public void toStringT() 
    {
        Point point = new Point(3, 4);
        assertEquals("(3, 4)", point.toString());
    }

    @Test
    public void isWithin() 
    {
        Point point1 = new Point(3, 4);
        assertTrue(Point.isWithin(point1, 5, 5));
        assertFalse(Point.isWithin(point1, 2, 2));
    }
}
