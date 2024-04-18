package sim.neuralnet;

/**
 * Represents a sensor neuron that detects orientation in the horizontal direction.
 */
public class HorizontalOrientationSensorNeuron extends OrientationSensorNeuron {

    /**
     * Returns the activation value corresponding to the north orientation.
     * 
     * @return The activation value for the north orientation (always 0).
     * @post | result == 0
     */
    @Override
    public int north() {
        return 0;
    }

    /**
     * Returns the activation value corresponding to the northeast orientation.
     * 
     * @return The activation value for the northeast orientation (500).
     * @post | result == 500
     */
    @Override
    public int northEast() {
        return 500;
    }

    /**
     * Returns the activation value corresponding to the east orientation.
     * 
     * @return The activation value for the east orientation (1000).
     * @post | result == 1000
     */
    @Override
    public int east() {
        return 1000;
    }

    /**
     * Returns the activation value corresponding to the southeast orientation.
     * 
     * @return The activation value for the southeast orientation (500).
     * @post | result == 500
     */
    @Override
    public int southEast() {
        return 500;
    }

    /**
     * Returns the activation value corresponding to the south orientation.
     * 
     * @return The activation value for the south orientation (always 0).
     * @post | result == 0
     */
    @Override
    public int south() {
        return 0;
    }

    /**
     * Returns the activation value corresponding to the southwest orientation.
     * 
     * @return The activation value for the southwest orientation (-500).
     * @post | result == -500
     */
    @Override
    public int southWest() {
        return -500;
    }

    /**
     * Returns the activation value corresponding to the west orientation.
     * 
     * @return The activation value for the west orientation (-1000).
     * @post | result == -1000
     */
    @Override
    public int west() {
        return -1000;
    }

    /**
     * Returns the activation value corresponding to the northwest orientation.
     * 
     * @return The activation value for the northwest orientation (-500).
     * @post | result == -500
     */
    @Override
    public int northWest() {
        return -500;
    }
}
