package StudentTests;

import org.junit.jupiter.api.Test;

import sim.World;
import sim.behaviors.Behavior;
import sim.neuralnet.LinearFunctionNeuron;
import sim.neuralnet.SensorNeuron;
import sim.Chromosome;
import sim.Creature;
import util.Orientation;
import util.Point;
import static org.junit.jupiter.api.Assertions.*;

public class LinearFunctionNeuronTest {

    @Test
    void testComputeOutput() {
        // Create a world
        World world = new World(10, 10, new Creature[0]);

        // Create neurons
        SensorNeuron sensor1 = new SensorNeuron() {
            @Override
            public int computeOutput(World world, Creature creature) {
                return 1;
            }
        };
        SensorNeuron sensor2 = new SensorNeuron() {
            @Override
            public int computeOutput(World world, Creature creature) {
                return 2;
            }
        };

        // Add dependencies
        LinearFunctionNeuron neuron = new LinearFunctionNeuron();
        neuron.connect(sensor1, 1);
        neuron.connect(sensor2, 2);

        // Compute output
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        int output = neuron.computeOutput(world, new Creature(behavior, new Point(0, 0), Orientation.north()));

        // Expected output: 1 * 1 + 2 * 2 = 5
        assertEquals(5, output);
    }

    @Test
    void testDoubleSensor() {
        // Create a neuron
        LinearFunctionNeuron neuron = new LinearFunctionNeuron();

        // Add a sensor dependency
        SensorNeuron sensor = new SensorNeuron() {
            @Override
            public int computeOutput(World world, Creature creature) {
                return 1;
            }
        };
        neuron.connect(sensor, 1);

        // Double the sensor
        neuron.doubleSensor(0);

        // Expected size of dependencies: 2
        assertEquals(2, neuron.getDependencies().size());
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
