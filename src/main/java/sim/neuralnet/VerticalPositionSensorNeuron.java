package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Point;

/**
 * @immutable
 */
public class VerticalPositionSensorNeuron extends SensorNeuron
{
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
