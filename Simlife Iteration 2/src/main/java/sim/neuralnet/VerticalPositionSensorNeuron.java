package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Point;

/**
 * Represents a sensor neuron that detects the vertical position of a creature.
 * @immutable
 */
public class VerticalPositionSensorNeuron extends SensorNeuron
{
    /**
     * Computes the output value of the neuron based on the vertical position of the creature.
     * 
     * @param world The world in which the creature exists.
     * @param creature The creature whose vertical position is observed.
     * @return The output value of the sensor neuron.
     * @pre | world != null
     * @pre | creature != null
     * @post
     * - The return value is equal to 1000 if the creature's vertical position is at the top of the world.
     * - The return value is equal to -1000 if the creature's vertical position is at the bottom of the world.
     * - The return value is equal to 0 if the creature's vertical position is not at the extreme ends of the world.
     */
    @Override
    public int computeOutput(World world, Creature creature)
    {
        Point position = creature.getPosition();
        int y = position.getY();
        if (y == 0) 
            return 1000;
        else if (y == world.getHeight() - 1) 
           return -1000;
        else
            return 0;
    }
}
