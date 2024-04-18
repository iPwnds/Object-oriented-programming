package sim.neuralnet;

/**
 * Represents a sensor neuron that detects vertical orientation.
 * @immutable
 */
public class VerticalOrientationSensorNeuron extends OrientationSensorNeuron
{
    /**
     * Computes the output value of the neuron when the creature's orientation is north.
     * 
     * @return The output value corresponding to the north orientation.
     */
    @Override
    public int north()
    {
        return -1000;
    }

    /**
     * Computes the output value of the neuron when the creature's orientation is northeast.
     * 
     * @return The output value corresponding to the northeast orientation.
     */
    @Override
    public int northEast()
    {
        return -500;
    }

    /**
     * Computes the output value of the neuron when the creature's orientation is east.
     * 
     * @return The output value corresponding to the east orientation.
     */
    @Override
    public int east()
    {
        return 0;
    }

    /**
     * Computes the output value of the neuron when the creature's orientation is southeast.
     * 
     * @return The output value corresponding to the southeast orientation.
     */
    @Override
    public int southEast()
    {
        return 500;
    }

    /**
     * Computes the output value of the neuron when the creature's orientation is south.
     * 
     * @return The output value corresponding to the south orientation.
     */
    @Override
    public int south()
    {
        return 1000;
    }

    /**
     * Computes the output value of the neuron when the creature's orientation is southwest.
     * 
     * @return The output value corresponding to the southwest orientation.
     */
    @Override
    public int southWest()
    {
        return 500;
    }

    /**
     * Computes the output value of the neuron when the creature's orientation is west.
     * 
     * @return The output value corresponding to the west orientation.
     */
    @Override
    public int west()
    {
        return 0;
    }

    /**
     * Computes the output value of the neuron when the creature's orientation is northwest.
     * 
     * @return The output value corresponding to the northwest orientation.
     */
    @Override
    public int northWest()
    {
        return -500;
    }
}
