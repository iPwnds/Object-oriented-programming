package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Color;
import util.Orientation;
import util.Point;
import sim.behaviors.Behavior;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BehaviorTest {

    @Test
    void testConstructorAndGetters() {
        // Test constructor and getters
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Behavior behavior = new MockBehavior(chromosome);
        assertNotNull(behavior.getChromosome());
        assertEquals(chromosome, behavior.getChromosome());
    }

    @Test
    void testApplyBehavior() {
        // Test applyBehavior method
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Behavior behavior = new MockBehavior(chromosome);
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.north();
        World world = new World(10, 10, new Creature[0]);
        Creature creature = new Creature(behavior, position, orientation);
        behavior.applyBehavior(world, creature); // No assertion, just ensure no exception is thrown
    }

    @Test
    void testGetColor() {
        // Test getColor method
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Behavior behavior = new MockBehavior(chromosome);
        assertNotNull(behavior.getColor());
    }

    @Test
    void testCopyWithChromosome() {
        // Test copyWithChromosome method
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Behavior behavior = new MockBehavior(chromosome);
        Chromosome newChromosome = new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48});
        Behavior newBehavior = behavior.copyWithChromosome(newChromosome);
        assertNotNull(newBehavior);
        assertEquals(newChromosome, newBehavior.getChromosome());
    }

    // MockBehavior class for testing
    static class MockBehavior extends Behavior {

        public MockBehavior(Chromosome chromosome) {
            super(chromosome);
        }

        @Override
        public void applyBehavior(World world, Creature creature) {
            // Mock implementation for testing
        }

        @Override
        public Color getColor() {
            // Mock implementation for testing
            return Color.RED;
        }

        @Override
        public Behavior copyWithChromosome(Chromosome chromosome) {
            // Mock implementation for testing
            return new MockBehavior(chromosome);
        }
    }
}
