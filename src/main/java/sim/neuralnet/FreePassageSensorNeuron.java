package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Orientation;


public class FreePassageSensorNeuron extends BinarySensorNeuron
{
    private final Orientation orientation;

    public FreePassageSensorNeuron(Orientation orientation)
    {
        this.orientation = null;
    }

    @Override
    protected boolean detect(World world, Creature creature)
    {
    	return false;
    }
}
