package StudentTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Color;


class ColorTest 
{
	@Test
    public void testConstructor() 
	{
        Color color = new Color(100, 150, 200);
        assertEquals(0xFF6496C8, color.asInteger());
    }

    @Test
    public void testIsValidColorComponent() 
    {
        assertTrue(Color.isValidColorComponent(0));
        assertTrue(Color.isValidColorComponent(255));
        assertFalse(Color.isValidColorComponent(-1));
        assertFalse(Color.isValidColorComponent(256));
    }

    @Test
    public void testEquals() 
    {
        Color color1 = new Color(100, 150, 200);
        Color color2 = new Color(100, 150, 200);
        assertTrue(color1.equals(color2));
    }

    @Test
    public void testHashCode() 
    {
        Color color = new Color(100, 150, 200);
        assertEquals(0xFF6496C8, color.hashCode());
    }

    @Test
    public void testConstants() 
    {
        assertEquals(0xFFFFFFFF, Color.WHITE.asInteger());
        assertEquals(0xFFFF0000, Color.RED.asInteger());
        assertEquals(0xFF00FF00, Color.GREEN.asInteger());
        assertEquals(0xFF0000FF, Color.BLUE.asInteger());
        assertEquals(0xFF000000, Color.BLACK.asInteger());
    }
}
