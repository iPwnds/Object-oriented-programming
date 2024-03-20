package sim.neuralnet;

import sim.Creature;
import sim.World;

/**
 * @immutable
 */
public class VerticalPositionSensorNeuron extends SensorNeuron
{
    @Override
    public int computeOutput(World world, Creature creature)
    {
        return 0;
    }
}
