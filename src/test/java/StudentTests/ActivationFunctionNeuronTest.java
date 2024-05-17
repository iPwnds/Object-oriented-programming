package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sim.entities.Prey;
import sim.neuralnet.ActivationFunctionNeuron;
import sim.neuralnet.Neuron;
import util.Pair;

class ActivationFunctionNeuronTest {

    private ActivationFunctionNeuron neuron;

    @BeforeEach
    void setUp() {
        neuron = new ActivationFunctionNeuron() {
            @Override
            public int applyActivationFunction(int input) {
                // Dummy activation function for testing
                return input > 0 ? 1 : 0;
            }
        };
    }

    @Test
    void testSetAndGetDependencies() {
        // Test setting and getting dependencies
        ArrayList<Pair<Neuron, Integer>> dependencies = new ArrayList<>();
        DummyNeuron dummy1 = new DummyNeuron();
        DummyNeuron dummy2 = new DummyNeuron();
        dependencies.add(new Pair<>(dummy1, 1));
        dependencies.add(new Pair<>(dummy2, -1));
        neuron.setDependencies(dependencies);
        List<Pair<Neuron, Integer>> retrievedDependencies = neuron.getDependencies();
        assertEquals(dependencies.size(), retrievedDependencies.size());
        for (int i = 0; i < dependencies.size(); i++) {
            assertEquals(dependencies.get(i).getFirst(), retrievedDependencies.get(i).getFirst());
            assertEquals(dependencies.get(i).getSecond(), retrievedDependencies.get(i).getSecond());
        }
    }

    @Test
    void testConnect() {
        // Test connecting a dependency
        assertTrue(neuron.connect(new DummyNeuron(), 1));
        assertEquals(1, neuron.getDependencies().size());
        // Test reaching maximum number of dependencies
        for (int i = 0; i < 6; i++) {
            assertTrue(neuron.connect(new DummyNeuron(), 1));
        }
        assertFalse(neuron.connect(new DummyNeuron(), 1));
        
    }

    @Test
    void testSetAndGetBias() {
        // Test setting and getting bias
        neuron.setBias(5);
        assertEquals(5, neuron.getBias());
    }

    private static class DummyNeuron implements Neuron {
        @Override
        public int computeOutput(Prey prey) {
            return 1; // Dummy output for testing
        }
    }
}
