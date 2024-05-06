package sim;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import sim.entities.World;
import util.Orientation;
import util.Point;
import util.RandomUtil;

public class Simulation
{
	private final int inhabitantsPerShelter;
	
	/**
	 * not a representation object for performance
	 */
	private World world;
	
	private final int worldSize;

    private final int preyCount; // Number of preys a new world should be inhabited with
    
    private final int huntersPerShelter;
    
    private final int shelterCount;
    
    /**
     * Initializes a new simulation with the specified parameters.
     * 
     * @param worldSize The length of side of the square world.
     * @param shelterCount The number of shelters in the world.
     * @param inhabitantsPerShelter The number of inhabitants per shelter.
     * @param huntersPerShelter The number of hunters per shelter.
     * 
     * @pre | worldSize > 0
     * @pre | shelterCount > 0
     * @pre | inhabitantsPerShelter > 0
     * @pre | huntersPerShelter >= 0
     */
    public Simulation(int worldSize, int shelterCount, int inhabitantsPerShelter, int huntersPerShelter)
    {
    	this.worldSize = worldSize;
    	this.shelterCount = shelterCount;
    	this.preyCount = 0;
    	this.inhabitantsPerShelter = inhabitantsPerShelter;
    	this.huntersPerShelter = huntersPerShelter;
    	this.world = null;
    }
    
    /**
     * Gets the current world in the simulation.
     * 
     * @return The current world in the simulation.
     */
	public World getWorld() 
	{
        return world;
	}
	
	/**
	 * Returns a World with the appropriate number of shelters/preys/hunters.
	 * The number of inhabitants and hunters per shelter match the above private fields.
	 * Their positions/orientations etc are picked randomly.
	 * No 2 entities have the same position.
	 * 
	 * Creates a new world with randomly placed shelters, preys, and hunters.
	 * 
	 * @param chromosomes The list of chromosomes representing the genetic makeup of the entities.
	 * @return The newly created world.
	 * 
	 * @pre | chromosomes != null
	 * @post | result != null
	 * @post | result.getPreys().size() == shelterCount * inhabitantsPerShelter
	 * @post | result.getHunters().size() == shelterCount * huntersPerShelter
	 */
	private World createRandomWorldWith(ArrayList<Chromosome> chromosomes)
	{
		var world = new World(worldSize, worldSize);
		
		ArrayList<Point> positions = new ArrayList<Point>(world.givePositionStream().toList());
		RandomUtil.shuffle(positions);
		return world;
	}
    
	/**
	 * LEGIT
	 */
    private World createRandomWorld(int preyCount)
    {
    	var chromosomes = Chromosome.createRandom(preyCount);
    	return createRandomWorldWith(chromosomes);
    }
    
    /**
     * Compute the list of surviving chromosomes, the list of offspring chromosomes,
     * and returns a new world based on that latter list.
     * 
     * @post | this.getWorld() != null
     */
    public void nextGeneration()
    {
    	var survivingChromosomes = getSurvivingChromosomes();
    	var offspringChromosomes = computeOffspring(survivingChromosomes);
    	
    	createRandomWorldWith(new ArrayList<>(offspringChromosomes));
    }
    
    /**
     * Computes the list of surviving chromosomes based on the current state of the world.
     * 
     * @return The list of surviving chromosomes.
     * 
     * @post | result != null
     */
    private ArrayList<Chromosome> getSurvivingChromosomes()
    {
    	ArrayList<Chromosome> res = null; //todo
    	
    	//will display how many preys survive at each generation
    	System.out.println(String.format("%d preys survived", res.size()));
    	
    	return res;
    }
    
    /**
     * If parentGeneration is empty, returns a random list of chromosomes of size preyCount.
     *  
     * @param parentGeneration The list of surviving chromosomes.
     * @return The list of offspring chromosomes.
     * 
     * @pre | parentGeneration != null
     * @post | result != null
     */
    private ArrayList<Chromosome> computeOffspring(ArrayList<Chromosome> parentGeneration)
    {
    	//can use method below
    	return null;
    }
    
    /**
     * LEGIT
     */
    private Chromosome computeOffspring(Chromosome parent1, Chromosome parent2)
    {
    	var offspring = parent1.crossover2(parent2);
    	
    	if ( RandomUtil.integer(100) < Constants.MUT_RATE )
        {
            offspring = offspring.randomlyMutate();
        }
    	
    	return offspring;
    }
}
