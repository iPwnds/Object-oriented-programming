package StudentTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Vector;


class VectorTest 
{
	@Test
    public void testGetX() 
	{
        Vector vector = new Vector(3, 4);
        assertEquals(3, vector.getX());
    }

    @Test
    public void testGetY() 
    {
        Vector vector = new Vector(3, 4);
        assertEquals(4, vector.getY());
    }

    @Test
    public void testScaleWith() 
    {
        Vector vector = new Vector(3, 4);
        Vector scaledVector = vector.scaleWith(2);
        assertEquals(new Vector(6, 8), scaledVector);
    }

    @Test
    public void testPlus() 
    {
        Vector vector1 = new Vector(3, 4);
        Vector vector2 = new Vector(1, 2);
        Vector sum = vector1.plus(vector2);
        assertEquals(new Vector(4, 6), sum);
    }

    @Test
    public void testEquals() 
    {
        Vector vector1 = new Vector(3, 4);
        Vector vector2 = new Vector(3, 4);
        assertTrue(vector1.equals(vector2));
    }

    @Test
    public void testToString() 
    {
        Vector vector = new Vector(3, 4);
        assertEquals("Vector(3, 4)", vector.toString());
    }
}
