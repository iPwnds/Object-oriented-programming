package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Orientation;


public class FreePassageSensorNeuron extends BinarySensorNeuron
{
    private final Orientation orientation;

    public FreePassageSensorNeuron(Orientation orientation)
    {
        this.orientation = orientation;
        
    }

    @Override
    public boolean detect(World world, Creature creature)
    {
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
