package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import sim.naturalselection.Disjunction;
import sim.naturalselection.NaturalSelection;
import sim.Creature;
import sim.World;
import util.Point;

public class DisjunctionTest {
    private Disjunction disjunction;

    @BeforeEach
    public void setUp() {
        // Create two mock natural selection areas for testing
        NaturalSelection area1 = new NaturalSelection() {
            @Override
            public boolean survives(World world, Point position) {
                // Mock survival condition for area 1
                return position.getX() < 5;
            }
        };

        NaturalSelection area2 = new NaturalSelection() {
            @Override
            public boolean survives(World world, Point position) {
                // Mock survival condition for area 2
                return position.getY() > 5;
            }
        };

        disjunction = new Disjunction(area1, area2);
    }

    @Test
    public void testSurvivesInArea1() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        Point position = new Point(3, 3); // Inside area 1
        assertTrue(disjunction.survives(world, position));
    }

    @Test
    public void testSurvivesInArea2() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        Point position = new Point(7, 7); // Inside area 2
        assertTrue(disjunction.survives(world, position));
    }

    @Test
    public void testSurvivesInBothAreas() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        Point position = new Point(3, 7); // Inside both areas
        assertTrue(disjunction.survives(world, position));
    }

    @Test
    public void testSurvivesInNeitherArea() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        Point position = new Point(6, 4); // Outside both areas
        assertFalse(disjunction.survives(world, position));
    }

    @Test
    public void testNullWorld() {
        Point position = new Point(3, 3); // Inside area 1
        assertThrows(NullPointerException.class, () -> {
            disjunction.survives(null, position);
        });
    }

    @Test
    public void testNullPosition() {
        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
        assertThrows(NullPointerException.class, () -> {
            disjunction.survives(world, null);
        });
    }
}

