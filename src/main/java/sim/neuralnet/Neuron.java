package sim.neuralnet;

import sim.Creature;
import sim.World;

/**
 * Represents a neuron in a neural network.
 */
public interface Neuron {

    /**
     * Computes the output of the neuron based on the state of the world and the creature.
     * 
     * @param world The world in which the creature exists.
     * @param creature The creature whose state influences the neuron's output.
     * @return The output value of the neuron.
     * @pre | world != null
     * @pre | creature != null
     */
    int computeOutput(World world, Creature creature);
}
