package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Creature;
import sim.World;
import sim.neuralnet.Neuron;
import static org.junit.jupiter.api.Assertions.*;

public abstract class NeuronTest {

    protected abstract Neuron createNeuron();

    @Test
    void testComputeOutput() {
        // Create a world
        World world = new World(10, 10, new Creature[0]);

        // Create a creature
        Creature creature = new Creature(null, null, null);

        // Create the neuron to be tested
        Neuron neuron = createNeuron();

        // Test the computeOutput method
        int output = neuron.computeOutput(world, creature);

        // Ensure that the output value is within expected bounds
        assertTrue(output >= 0 && output <= 255);
    }
}
