package simpleui;

import sim.Constants;
import sim.Simulation;
import util.RandomUtil;


/**
 * LEGIT
 * 
 * 
 * Make sure to test your program with different parameters.
 * Don't forget to restore the present class before submitting.
 * 
 * See *Info about other classes and general remarks.* in the assignment.
 */
public class MainSim
{
    public static void main(String[] args)
    {
    	RandomUtil.seed(1234);
    	
    	Simulation sim = new Simulation(
    			Constants.WORLD_SIZE,
    			Constants.SHELTER_COUNT,
    			Constants.INHABITANTS_PER_SHELTER,
    			Constants.HUNTERS_PER_SHELTER);
    	
    	SimLifeWindow.create("Iteration 3", Constants.WORLD_SIZE, Constants.WORLD_SIZE, sim);
    }
}
