package StudentTests;

import org.junit.jupiter.api.Test;

import StudentTests.VerticalOrientationSensorNeuronTest.MockBehavior;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.behaviors.Behavior;
import sim.neuralnet.VerticalPositionSensorNeuron;
import util.Color;
import util.Orientation;
import util.Point;

import static org.junit.jupiter.api.Assertions.*;

public class VerticalPositionSensorNeuronTest {

    @Test
    void testComputeOutput_Top() {
        // Create a world
        World world = new World(10, 10, new Creature[0]);

        // Create a creature at the top of the world
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Creature creature = new Creature(new MockBehavior(chromosome), new Point(5, 0), Orientation.north());

        // Create a VerticalPositionSensorNeuron
        VerticalPositionSensorNeuron neuron = new VerticalPositionSensorNeuron();

        // Test the output
        assertEquals(1000, neuron.computeOutput(world, creature));
    }

    @Test
    void testComputeOutput_Bottom() {
        // Create a world
        World world = new World(10, 10, new Creature[0]);

        // Create a creature at the bottom of the world
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Creature creature = new Creature(new MockBehavior(chromosome), new Point(5, 9), Orientation.north());

        // Create a VerticalPositionSensorNeuron
        VerticalPositionSensorNeuron neuron = new VerticalPositionSensorNeuron();

        // Test the output
        assertEquals(-1000, neuron.computeOutput(world, creature));
    }

    @Test
    void testComputeOutput_Middle() {
        // Create a world
        World world = new World(10, 10, new Creature[0]);

        // Create a creature in the middle of the world
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Creature creature = new Creature(new MockBehavior(chromosome), new Point(5, 5), Orientation.north());

        // Create a VerticalPositionSensorNeuron
        VerticalPositionSensorNeuron neuron = new VerticalPositionSensorNeuron();

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
