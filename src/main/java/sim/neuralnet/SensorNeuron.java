package sim.neuralnet;

import sim.Creature;
import sim.World;

/**
 * Represents an abstract sensor neuron in a neural network.
 * @immutable
 */
public abstract class SensorNeuron implements Neuron {

    /**
     * Computes the output value of the sensor neuron based on the state of the world and the creature.
     * 
     * @param world The world in which the creature exists.
     * @param creature The creature whose state is observed.
     * @return The output value of the sensor neuron.
     * @pre | world != null
     * @pre | creature != null
     * @post
     * - The return value represents the output of the sensor neuron based on the given world and creature.
     */
	@Override
	public abstract int computeOutput(World world, Creature creature);

}
