package StudentTests;

import org.junit.jupiter.api.Test;

import StudentTests.BehaviorTest.TestBehavior;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Orientation;
import util.Point;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {

    @Test
    public void testConstructorAndGetters() {
        Creature[] population = new Creature[3];
        population[0] = new Creature(new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}), null), new Point(1, 1), Orientation.north());
        population[1] = new Creature(new TestBehavior(new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48}), null), new Point(2, 2), Orientation.east());
        population[2] = new Creature(new TestBehavior(new Chromosome(new int[]{49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72}), null), new Point(3, 3), Orientation.south());

        World world = new World(10, 10, population);

        assertEquals(10, world.getWidth());
        assertEquals(10, world.getHeight());
        //assertArrayEquals(population, world.getPopulation());
    }

    @Test
    public void testIsInside() {
        World world = new World(5, 5, new Creature[0]);

        assertTrue(world.isInside(new Point(0, 0)));
        assertTrue(world.isInside(new Point(4, 4)));
        assertFalse(world.isInside(new Point(-1, 0)));
        assertFalse(world.isInside(new Point(0, -1)));
        assertFalse(world.isInside(new Point(5, 0)));
        assertFalse(world.isInside(new Point(0, 5)));
    }

    @Test
    public void testIsLimPos() {
        World world = new World(5, 5, new Creature[0]);

        assertTrue(world.isLimPos(new Point(0, 0)));
        assertTrue(world.isLimPos(new Point(4, 0)));
        assertTrue(world.isLimPos(new Point(0, 4)));
        assertTrue(world.isLimPos(new Point(4, 4)));
        assertFalse(world.isLimPos(new Point(1, 1)));
        assertFalse(world.isLimPos(new Point(2, 2)));
        assertFalse(world.isLimPos(new Point(3, 3)));
    }

    @Test
    public void testAreEqualCreatureArrays() {
        Creature[] array1 = new Creature[3];
        array1[0] = new Creature(new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}), null), new Point(1, 1), Orientation.north());
        array1[1] = new Creature(new TestBehavior(new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48}), null), new Point(2, 2), Orientation.east());
        array1[2] = new Creature(new TestBehavior(new Chromosome(new int[]{49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72}), null), new Point(3, 3), Orientation.south());

        Creature[] array2 = new Creature[3];
        array2[0] = new Creature(new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}), null), new Point(1, 1), Orientation.north());
        array2[1] = new Creature(new TestBehavior(new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48}), null), new Point(2, 2), Orientation.east());
        array2[2] = new Creature(new TestBehavior(new Chromosome(new int[]{49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72}), null), new Point(3, 3), Orientation.south());

        Creature[] array3 = new Creature[3];
        array3[0] = new Creature(new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}), null), new Point(1, 1), Orientation.north());
        array3[1] = new Creature(new TestBehavior(new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48}), null), new Point(2, 2), Orientation.east());
        array3[2] = new Creature(new TestBehavior(new Chromosome(new int[]{49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72}), null), new Point(3, 3), Orientation.south());

        assertTrue(World.areEqualCreatureArrays(array1, array2));
        assertTrue(World.areEqualCreatureArrays(array1, array3));
        assertTrue(World.areEqualCreatureArrays(array2, array3));

        // Changing one position in array3 should make the arrays unequal
        array3[1] = new Creature(new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}), null), new Point(2, 2), Orientation.east());
        assertFalse(World.areEqualCreatureArrays(array1, array3));
    }

    @Test
    public void testIsFree() {
        Creature[] population = new Creature[3];
        population[0] = new Creature(new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}), null), new Point(1, 1), Orientation.north());
        population[1] = new Creature(new TestBehavior(new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48}), null), new Point(2, 2), Orientation.east());
        population[2] = new Creature(new TestBehavior(new Chromosome(new int[]{49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72}), null), new Point(3, 3), Orientation.south());

        World world = new World(5, 5, population);

        assertTrue(world.isFree(new Point(0, 0)));
        assertFalse(world.isFree(new Point(5, 5)));
        assertFalse(world.isFree(new Point(6, 6)));
        assertFalse(world.isFree(new Point(7, 7)));
        assertTrue(world.isFree(new Point(4, 4)));
    }

}
