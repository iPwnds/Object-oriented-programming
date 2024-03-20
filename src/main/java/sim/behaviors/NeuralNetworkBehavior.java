package sim.behaviors;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.neuralnet.NeuralNetwork;
import util.Color;
import util.Vector;


/**
 * @invar | getColor() .equals( Color.GREEN )
 */
public class NeuralNetworkBehavior extends Behavior	{
	/**
	 * @representationObject
	 * neuralNetwork != null
	 */
    private final NeuralNetwork neuralNetwork;

    public NeuralNetworkBehavior(Chromosome chromosome)
    {
    	super(chromosome);
        this.neuralNetwork = null;
    }

    @Override
    public void applyBehavior(World world, Creature creature)
    {
        processForwardMovement(world, creature);
        processTurning(world, creature);
    }

    private void processForwardMovement(World world, Creature creature)
    {
    	
        
    }

    /**
     * LEGIT
     */
    private void processTurning(World world, Creature creature)
    {

    	int clockVal = neuralNetwork.getTurnClockwiseNeuron().computeOutput(world, creature);
    	int counterVal = neuralNetwork.getTurnCounterclockwiseNeuron().computeOutput(world, creature);
    	
    	if ((Math.abs(clockVal - counterVal) > 150)) { //if the 2 values are substantially different
    		if (clockVal > counterVal) {creature.turnClockwise();}
    		else {creature.turnCounterclockwise();}
    	}

    }
	



	@Override
	public NeuralNetworkBehavior copyWithChromosome(Chromosome chromosome)
	{
		return new NeuralNetworkBehavior(chromosome);
	}
}
