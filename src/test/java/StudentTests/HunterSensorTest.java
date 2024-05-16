package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim.neuralnet.*;

class NeuralNetworkTest {
    
    @Test
    void testGetInputNeurons() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        SensorNeuron[] inputNeurons = neuralNetwork.getInputNeurons();
        
        assertNotNull(inputNeurons);
        assertEquals(5, inputNeurons.length);
        for (SensorNeuron neuron : inputNeurons) {
            assertNotNull(neuron);
        }
    }
    
    @Test
    void testGetOutputNeurons() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        ActivationFunctionNeuron[] outputNeurons = neuralNetwork.getOutputNeurons();
        
        assertNotNull(outputNeurons);
        assertEquals(2, outputNeurons.length);
        assertNotNull(outputNeurons[0]);
        assertNotNull(outputNeurons[1]);
    }
    
    @Test
    void testGetMoveForwardNeuron() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        ActivationFunctionNeuron moveForwardNeuron = neuralNetwork.getMoveForwardNeuron();
        
        assertNotNull(moveForwardNeuron);
    }
    
    @Test
    void testGetTurnNeuron() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        ActivationFunctionNeuron turnNeuron = neuralNetwork.getTurnNeuron();
        
        assertNotNull(turnNeuron);
    }
    
}
