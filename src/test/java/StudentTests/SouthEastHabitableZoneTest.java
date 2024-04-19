package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim.naturalselection.SouthEastHabitableZone;
import sim.Creature;
import sim.World;
import util.Point;

public class SouthEastHabitableZoneTest {

    @Test
    public void testSurvives_OnBoundary() {
        // Create a world with dimensions 10x10
        World world = new World(10, 10, new Creature[0]);
        
        // Test a point exactly on the boundary (bottom-right corner)
        Point boundaryPoint = new Point(7, 7);
        assertTrue(new SouthEastHabitableZone().survives(world, boundaryPoint));
    }

    @Test
    public void testSurvives_InsideRegion() {
        // Create a world with dimensions 10x10
        World world = new World(10, 10, new Creature[0]);
        
        // Test a point inside the south-east region
        Point insidePoint = new Point(8, 8);
        assertTrue(new SouthEastHabitableZone().survives(world, insidePoint));
    }

    @Test
    public void testSurvives_OutsideRegion() {
        // Create a world with dimensions 10x10
        World world = new World(10, 10, new Creature[0]);
        
        // Test a point outside the south-east region
        Point outsidePoint = new Point(4, 4);
        assertFalse(new SouthEastHabitableZone().survives(world, outsidePoint));
    }

    @Test
    public void testSurvives_NullWorld() {
        // Test with null world
        Point position = new Point(8, 8);
        assertThrows(NullPointerException.class, () -> {
            new SouthEastHabitableZone().survives(null, position);
        });
    }

    @Test
    public void testSurvives_NullPosition() {
        // Create a world with dimensions 10x10
        World world = new World(10, 10, new Creature[0]);
        
        // Test with null position
        assertThrows(NullPointerException.class, () -> {
            new SouthEastHabitableZone().survives(world, null);
        });
    }
}
