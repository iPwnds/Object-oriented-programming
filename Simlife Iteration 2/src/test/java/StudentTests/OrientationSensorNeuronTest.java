package StudentTests;

import org.junit.jupiter.api.Test;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.behaviors.Behavior;
import sim.neuralnet.OrientationSensorNeuron;
import util.Orientation;
import util.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationSensorNeuronTest {

    @Test
    void testNorth() {
        OrientationSensorNeuron neuron = new OrientationSensorNeuron() {
            @Override
            public int north() {
                return 100;
            }

            // Implement other abstract methods with dummy values for testing
            @Override
            public int northEast() {
                return 0;
            }

            @Override
            public int east() {
                return 0;
            }

            @Override
            public int southEast() {
                return 0;
            }

            @Override
            public int south() {
                return 0;
            }

            @Override
            public int southWest() {
                return 0;
            }

            @Override
            public int west() {
                return 0;
            }

            @Override
            public int northWest() {
                return 0;
            }
        };
        
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Creature creature = new Creature(behavior, new Point(0, 0), Orientation.north());
        int expectedOutput = 100;
        int actualOutput = neuron.computeOutput(new World(10, 10, new Creature[0]), creature);
        assertEquals(expectedOutput, actualOutput);
    }

    // Helper class for testing
    private static class TestBehavior extends Behavior {
        public TestBehavior(Chromosome chromosome) {
            super(chromosome);
        }

        @Override
        public void applyBehavior(World world, Creature creature) {

        }

        @Override
        public util.Color getColor() {
            // Dummy implementation
            return null;
        }

        @Override
        public Behavior copyWithChromosome(Chromosome chromosome) {
            // Dummy implementation
            return null;
        }
    }
}
