package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Orientation;

/**
 * @immutable
 * LEGIT
 */
public abstract class OrientationSensorNeuron extends SensorNeuron
{
    @Override
    public int computeOutput(World world, Creature creature)
    {
        var orientation = creature.getOrientation();

        if ( orientation == Orientation.north() )
        {
            return this.north();
        }
        else if ( orientation == Orientation.northEast() )
        {
            return this.northEast();
        }
        else if ( orientation == Orientation.east() )
        {
            return this.east();
        }
        else if ( orientation == Orientation.southEast() )
        {
            return this.southEast();
        }
        else if ( orientation == Orientation.south() )
        {
            return this.south();
        }
        else if ( orientation == Orientation.southWest() )
        {
            return this.southWest();
        }
        else if ( orientation == Orientation.west() )
        {
            return this.west();
        }
        else
        {
            return this.northWest();
        }
    }

    protected abstract int north();

    protected abstract int northEast();

    protected abstract int east();

    protected abstract int southEast();

    protected abstract int south();

    protected abstract int southWest();

    protected abstract int west();

    protected abstract int northWest();
}
