package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Point;


public class HorizontalPositionSensorNeuron extends SensorNeuron
{
    @Override
    public int computeOutput(World world, Creature creature)
    {
    	Point position = creature.getPosition();
    	int x = position.getX();
    	if (x == 0) 
    		return -1000;
    	
    	else if (x == world.getWidth() - 1) 
    	   return 1000;
    	
    	else
    		return 0; 
    }
}