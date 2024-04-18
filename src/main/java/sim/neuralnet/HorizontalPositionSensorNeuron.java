package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Point;

/**
 * Represents a sensor neuron that detects the horizontal position of a creature.
 */
public class HorizontalPositionSensorNeuron extends SensorNeuron {

    /**
     * Computes the output of the horizontal position sensor neuron based on the creature's horizontal position.
     * 
     * @param world The world in which the creature exists.
     * @param creature The creature whose horizontal position is detected.
     * @return The output value of the neuron, indicating the creature's horizontal position.
     *         Returns -1000 if the creature is at the far left, 1000 if the creature is at the far right, or 0 otherwise.
     * @pre | world != null
     * @pre | creature != null
     * @post | result == -1000 || result == 1000 || result == 0
     */
    @Override
    public int computeOutput(World world, Creature creature) {
        Point position = creature.getPosition();
        int x = position.getX();

        if (x == 0) {
            return -1000;
        } else if (x == world.getWidth() - 1) {
            return 1000;
        } else {
            return 0;
        }
    }
}
