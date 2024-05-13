package sim.neuralnet;

import sim.Creature;
import sim.World;

/**
 * Represents a binary sensor neuron that detects a certain condition in the world.
 * Subclasses of this class implement specific detection logic.
 */
public abstract class BinarySensorNeuron extends SensorNeuron {

    /**
     * Computes the output of the binary sensor neuron based on the detection result.
     * 
     * @param world The world in which the creature exists.
     * @param creature The creature whose state influences the detection.
     * @return The output value of the neuron. Returns 750 if the condition is detected, -750 otherwise.
     * @pre | world != null
     * @pre | creature != null
     * @post | result == 750 || result == -750
     */
    @Override
    public int computeOutput(World world, Creature creature) {
        if (detect(world, creature)) {
            return 750;
        } else {
            return -750;
        }
    }

    /**
     * Detects a specific condition in the world.
     * 
     * @param world The world in which the condition is detected.
     * @param creature The creature whose state is observed for detection.
     * @return true if the condition is detected, false otherwise.
     * @pre | world != null
     * @pre | creature != null
     */
    public abstract boolean detect(World world, Creature creature);
}
