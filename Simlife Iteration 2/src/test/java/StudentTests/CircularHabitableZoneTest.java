package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import sim.naturalselection.CircularHabitableZone;
import sim.Creature;
import sim.World;
import util.Point;

public class CircularHabitableZoneTest {
    private CircularHabitableZone habitationZone;

    @BeforeEach
    public void setUp() {
        Point center = new Point(5, 5); // Set the center point of the circular habitation zone
        habitationZone = new CircularHabitableZone(center, 3); // Set the radius of the circular habitation zone
    }

    @Test
    public void testSurvivesInsideZone() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        Point position = new Point(6, 6); // Inside the circular habitation zone
        assertTrue(habitationZone.survives(world, position));
    }

    @Test
    public void testSurvivesOnBoundary() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        Point position = new Point(5, 8); // On the boundary of the circular habitation zone
        assertTrue(habitationZone.survives(world, position));
    }

    @Test
    public void testSurvivesOutsideZone() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        Point position = new Point(8, 8); // Outside the circular habitation zone
        assertFalse(habitationZone.survives(world, position));
    }

    @Test
    public void testNullWorld() {
        Point position = new Point(6, 6); // Inside the circular habitation zone
        assertThrows(NullPointerException.class, () -> {
            habitationZone.survives(null, position);
        });
    }

    @Test
    public void testNullPosition() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        assertThrows(NullPointerException.class, () -> {
            habitationZone.survives(world, null);
        });
    }
}
