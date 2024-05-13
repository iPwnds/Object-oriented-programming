package StudentTests;

import org.junit.jupiter.api.Test;

import StudentTests.BehaviorTest.MockBehavior;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.behaviors.Behavior;
import sim.neuralnet.HorizontalPositionSensorNeuron;
import util.Color;
import util.Orientation;
import util.Point;

import static org.junit.jupiter.api.Assertions.*;

public class HorizontalPositionSensorNeuronTest {

    @Test
    void testComputeOutput_LeftBoundary() {
        // Create a world with width 10
        World world = new World(10, 5, new Creature[0]);

        // Create a creature at the far left
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Creature creature = new Creature(new MockBehavior(chromosome), new Point(0, 2), Orientation.north());

        // Create a HorizontalPositionSensorNeuron
        HorizontalPositionSensorNeuron neuron = new HorizontalPositionSensorNeuron();

        // Test the output
        assertEquals(-1000, neuron.computeOutput(world, creature));
    }

    @Test
    void testComputeOutput_RightBoundary() {
        // Create a world with width 10
        World world = new World(10, 5, new Creature[0]);

        // Create a creature at the far right
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Creature creature = new Creature(new MockBehavior(chromosome), new Point(9, 2), Orientation.north());

        // Create a HorizontalPositionSensorNeuron
        HorizontalPositionSensorNeuron neuron = new HorizontalPositionSensorNeuron();

        // Test the output
        assertEquals(1000, neuron.computeOutput(world, creature));
    }

    @Test
    void testComputeOutput_Middle() {
        // Create a world with width 10
        World world = new World(10, 5, new Creature[0]);

        // Create a creature in the middle
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Creature creature = new Creature(new MockBehavior(chromosome), new Point(5, 2), Orientation.north());

        // Create a HorizontalPositionSensorNeuron
        HorizontalPositionSensorNeuron neuron = new HorizontalPositionSensorNeuron();

        // Test the output
        assertEquals(0, neuron.computeOutput(world, creature));
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
