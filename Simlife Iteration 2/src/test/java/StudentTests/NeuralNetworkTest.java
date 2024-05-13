package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.neuralnet.*;

import static org.junit.jupiter.api.Assertions.*;

public class NeuralNetworkTest {

    @Test
    void testGetInputNeurons() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        SensorNeuron[] inputNeurons = neuralNetwork.getInputNeurons();
        assertEquals(7, inputNeurons.length);
    }

    @Test
    void testGetOutputNeurons() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        ActivationFunctionNeuron[] outputNeurons = neuralNetwork.getOutputNeurons();
        assertEquals(3, outputNeurons.length);
    }

    @Test
    void testFromChromosome() {
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        NeuralNetwork neuralNetwork = NeuralNetwork.fromChromosome(chromosome);
        assertNotNull(neuralNetwork);
    }

    @Test
    void testFromChromosomeNull() {
        assertThrows(IllegalArgumentException.class, () -> NeuralNetwork.fromChromosome(null));
    }
}
