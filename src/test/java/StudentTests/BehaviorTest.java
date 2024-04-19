package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.behaviors.Behavior;
import util.Color;
import static org.junit.jupiter.api.Assertions.*;

class BehaviorTest {

    // Mock implementation of Behavior for testing
    static class TestBehavior extends Behavior {
        private final Color color;

        public TestBehavior(Chromosome chromosome, Color color) {
            super(chromosome);
            this.color = color;
        }

        @Override
        public void applyBehavior(World world, Creature creature) {
            // Dummy implementation
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public Behavior copyWithChromosome(Chromosome chromosome) {
            return new TestBehavior(chromosome, color);
        }
    }

    // Test getChromosome method
    @Test
    void testGetChromosome() {
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Behavior behavior = new TestBehavior(chromosome, Color.RED);
        assertEquals(chromosome, behavior.getChromosome());
    }

    // Test copyWithChromosome method
    @Test
    void testCopyWithChromosome() {
        Chromosome chromosome1 = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Chromosome chromosome2 = new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48});
        Behavior behavior1 = new TestBehavior(chromosome1, Color.RED);
        Behavior copiedBehavior = behavior1.copyWithChromosome(chromosome2);

        assertNotSame(behavior1, copiedBehavior);
        assertEquals(chromosome2, copiedBehavior.getChromosome());
    }
}
