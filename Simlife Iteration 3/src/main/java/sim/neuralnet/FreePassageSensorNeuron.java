package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Orientation;
import util.Point;

/**
 * Represents a binary sensor neuron that detects whether there is free passage in a specific direction.
 */
public class FreePassageSensorNeuron extends BinarySensorNeuron {

    /** The orientation in which the free passage is detected. */
    private final Orientation orientation;

    /**
     * Constructs a FreePassageSensorNeuron with the specified orientation.
     * 
     * @param orientation The orientation in which free passage is detected.
     * @pre | orientation != null
     */
    public FreePassageSensorNeuron(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Detects whether there is free passage in the specified direction.
     * 
     * @param world The world in which the detection is performed.
     * @param creature The creature whose position and orientation are used for detection.
     * @return true if there is free passage in the specified direction, false otherwise.
     * @pre | world != null
     * @pre | creature != null
     */
    @Override
    public boolean detect(World world, Creature creature) {
        int x = creature.getPosition().getX();
        int y = creature.getPosition().getY();

        int xOffset = 0;
        int yOffset = 0;

        if (orientation == Orientation.north() || orientation == Orientation.northWest() || orientation == Orientation.northEast()) {
            yOffset = -1;
        } else if (orientation == Orientation.south() || orientation == Orientation.southWest() || orientation == Orientation.southEast()) {
            yOffset = 1;
        }

        if (orientation == Orientation.west() || orientation == Orientation.northWest() || orientation == Orientation.southWest()) {
            xOffset = -1;
        } else if (orientation == Orientation.east() || orientation == Orientation.northEast() || orientation == Orientation.southEast()) {
            xOffset = 1;
        }

        return world.isFree(new Point(x + xOffset, y + yOffset));
    }
}
