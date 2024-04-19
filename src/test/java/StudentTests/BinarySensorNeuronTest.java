package StudentTests;

import org.junit.jupiter.api.Test;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.behaviors.Behavior;
import sim.neuralnet.BinarySensorNeuron;
import util.Orientation;
import util.Point;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySensorNeuronTest {

    @Test
    void testComputeOutput_ConditionDetected() {
        // Test computeOutput method when the condition is detected

        // Create a BinarySensorNeuron subclass for testing
        BinarySensorNeuron neuron = new TestBinarySensorNeuron(true);

        // Create a world and a creature
        World world = new World(10, 10, new Creature[0]);
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.north();
        Creature creature = new Creature(behavior, position, orientation);

        // Test computeOutput method
        assertEquals(750, neuron.computeOutput(world, creature));
    }

    @Test
    void testComputeOutput_ConditionNotDetected() {
        // Test computeOutput method when the condition is not detected

        // Create a BinarySensorNeuron subclass for testing
        BinarySensorNeuron neuron = new TestBinarySensorNeuron(false);

        // Create a world and a creature
        World world = new World(10, 10, new Creature[0]);
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.north();
        Creature creature = new Creature(behavior, position, orientation);

        // Test computeOutput method
        assertEquals(-750, neuron.computeOutput(world, creature));
    }

    // TestBinarySensorNeuron subclass for testing purposes
    private static class TestBinarySensorNeuron extends BinarySensorNeuron {
        private final boolean conditionDetected;

        public TestBinarySensorNeuron(boolean conditionDetected) {
            this.conditionDetected = conditionDetected;
        }

        @Override
        public boolean detect(World world, Creature creature) {
            return conditionDetected;
        }
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
