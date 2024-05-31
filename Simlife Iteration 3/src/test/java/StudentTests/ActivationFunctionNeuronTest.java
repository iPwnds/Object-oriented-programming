package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sim.neuralnet.ActivationFunctionNeuron;

public class ActivationFunctionNeuronTest {

    private ActivationFunctionNeuron neuron;

    @BeforeEach
    public void setUp() {
        neuron = new ActivationFunctionNeuron() {
            @Override
            public int applyActivationFunction(int input) {
                // Dummy activation function for testing
                return input > 0 ? 1 : 0;
            }
        };
    }

    @Test
    public void testSetAndGetBias() {
        // Test setting and getting bias
        neuron.setBias(5);
        
        assertEquals(5, neuron.getBias());
    }
    
}
