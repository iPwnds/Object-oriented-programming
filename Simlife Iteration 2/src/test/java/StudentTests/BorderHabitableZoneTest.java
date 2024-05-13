package StudentTests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sim.Creature;
import sim.World;
import sim.naturalselection.BorderHabitableZone;
import util.Point;

class BorderHabitableZoneTest {

    @Test
    void testConstructorAndGetters() {
        // Test constructor and getters
        int borderSize = 5;
        BorderHabitableZone selection = new BorderHabitableZone(borderSize);
        assertEquals(borderSize, selection.getBorderSize());
    }

    @Test
    void testSurvives() {
        // Test survives method
        
        // Create a world with a specific size
        int width = 10;
        int height = 10;
        World world = new World(width, height, new Creature[0]);
        
        // Create a border size
        int borderSize = 2;
        BorderHabitableZone selection = new BorderHabitableZone(borderSize);
        
        // Test survival within the border zone
        assertTrue(selection.survives(world, new Point(1, 1)));
        assertTrue(selection.survives(world, new Point(1, 8)));
        assertTrue(selection.survives(world, new Point(8, 1)));
        assertTrue(selection.survives(world, new Point(8, 8)));
        
        // Test survival outside the border zone
        //assertFalse(selection.survives(world, new Point(0, 0)));
        assertFalse(selection.survives(world, new Point(5, 5)));
        //assertFalse(selection.survives(world, new Point(9, 9)));
    }

}
