package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Creature;
import sim.World;
import sim.neuralnet.ActivationFunctionNeuron;
import sim.neuralnet.Neuron;
import util.Pair;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ActivationFunctionNeuronTest {

    @Test
    void testSetAndGetDependencies() {
        // Test setting and getting dependencies

        // Create a neuron
        ActivationFunctionNeuron neuron = new ActivationFunctionNeuron() {
            @Override
            public int computeOutput(World world, Creature creature) {
                return 0;
            }

            @Override
            public int applyActivationFunction(int input) {
                return 0;
            }
        };

        // Create dependencies
        ArrayList<Pair<Neuron, Integer>> dependencies = new ArrayList<>();
        Neuron dependency1 = new DummyNeuron();
        Neuron dependency2 = new DummyNeuron();
        dependencies.add(new Pair<>(dependency1, 2));
        dependencies.add(new Pair<>(dependency2, 3));

        // Set dependencies
        neuron.setDependencies(dependencies);

        // Test getting dependencies
        assertEquals(dependencies, neuron.getDependencies());
    }

    @Test
    void testConnect() {
        // Test connecting dependencies

        // Create a neuron
        ActivationFunctionNeuron neuron = new ActivationFunctionNeuron() {
            @Override
            public int computeOutput(World world, Creature creature) {
                return 0;
            }

            @Override
            public int applyActivationFunction(int input) {
                return 0;
            }
        };

        // Create dependencies
        Neuron dependency1 = new DummyNeuron();
        Neuron dependency2 = new DummyNeuron();

        // Connect dependencies
        assertTrue(neuron.connect(dependency1, 2));
        assertTrue(neuron.connect(dependency2, 3));

        // Test maximum number of dependencies (should replace the oldest one)
        for (int i = 0; i < 10; i++) {
            assertTrue(neuron.connect(new DummyNeuron(), 1));
        }
        assertEquals(7, neuron.getDependencies().size());
    }

    @Test
    void testSetAndGetBias() {
        // Test setting and getting bias

        // Create a neuron
        ActivationFunctionNeuron neuron = new ActivationFunctionNeuron() {
            @Override
            public int computeOutput(World world, Creature creature) {
                return 0;
            }

            @Override
            public int applyActivationFunction(int input) {
                return 0;
            }
        };

        // Set bias
        neuron.setBias(5);

        // Test getting bias
        assertEquals(5, neuron.getBias());
    }

    // DummyNeuron class for testing purposes
    private static class DummyNeuron implements Neuron {
        @Override
        public int computeOutput(World world, Creature creature) {
            return 0;
        }
    }
}
