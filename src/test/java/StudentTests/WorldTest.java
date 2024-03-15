package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim1.*;
import util.Orientation;
import util.Point;

class WorldTest {

    @Test
    void getWidth() {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertEquals(10, world.getWidth());
    }

    @Test
    void getHeight() {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertEquals(20, world.getHeight());
    }

    @Test
    void getPopulationA() {
        CreatureA[] populationA = {new CreatureA(new BehaviorA(), new Point(0, 0), Orientation.east(), new Chromosome(new int[]{1, 2, 3}))};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertArrayEquals(populationA, world.getPopulationA());
    }

    @Test
    void getPopulationB() {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {new CreatureB(new BehaviorB(), new Point(0, 0), Orientation.east())};
        World world = new World(10, 20, populationA, populationB);

        assertArrayEquals(populationB, world.getPopulationB());
    }

    @Test
    void isInside() {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertTrue(world.isInside(new Point(5, 5)));
        assertFalse(world.isInside(new Point(15, 25)));
    }

    @Test
    void isLimPos() {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertTrue(world.isLimPos(new Point(8, 8)));
        assertFalse(world.isLimPos(new Point(5, 5)));
    }

    @Test
    void isFree() {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertTrue(world.isFree(new Point(5, 5)));

        CreatureA creatureA = new CreatureA(new BehaviorA(), new Point(5, 5), Orientation.east(), new Chromosome(new int[]{1, 2, 3}));
        world = new World(10, 20, new CreatureA[]{creatureA}, populationB);

        assertFalse(world.isFree(new Point(5, 5)));
    }

}