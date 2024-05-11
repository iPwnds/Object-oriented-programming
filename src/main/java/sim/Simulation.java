package sim;

import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.IntStream;
import sim.entities.Shelter;
import sim.entities.World;
import util.Orientation;
import util.Point;
import util.RandomUtil;

/**
 * Represents a simulation environment where entities interact and evolve over generations.
 * The simulation includes shelters, preys, and hunters.
 */
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
     * Constructs a Simulation object with the specified parameters.
     *
     * @param worldSize            The size of the simulation world.
     * @param shelterCount         The number of shelters in the simulation.
     * @param inhabitantsPerShelter The number of inhabitants per shelter.
     * @param huntersPerShelter    The number of hunters per shelter.
     * @pre | worldSize > 0
     * @pre | shelterCount > 0
     * @pre | inhabitantsPerShelter > 0
     * @pre | huntersPerShelter >= 0
     * @post | getWorldSize() == worldSize
     * @post | getShelterCount() == shelterCount
     * @post | getPreyCount() == inhabitantsPerShelter * shelterCount
     * @post | getInhabitantsPerShelter() == inhabitantsPerShelter
     * @post | getHuntersPerShelter() == huntersPerShelter
     */
    public Simulation(int worldSize, int shelterCount, int inhabitantsPerShelter, int huntersPerShelter) 
    {
        this.worldSize = worldSize;
        this.shelterCount = shelterCount;
        this.preyCount = inhabitantsPerShelter * shelterCount;
        this.inhabitantsPerShelter = inhabitantsPerShelter;
        this.huntersPerShelter = huntersPerShelter;
        this.world = this.createRandomWorld(getPreyCount());
    }
    
    /**
     * Retrieves the simulation world.
     *
     * @return The simulation world.
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
	 * @param chromosomes A list of chromosomes representing the genetic makeup of preys.
     * @return The created world.
     * @post | result != null
     * @post | result.getPreys().size() == chromosomes.size()
	 */
	private World createRandomWorldWith(ArrayList<Chromosome> chromosomes) 
	{
	    World world = new World(worldSize, worldSize);

	    ArrayList<Point> positions = new ArrayList<>(world.givePositionStream().toList());
	    RandomUtil.shuffle(positions);
	    ArrayList<Shelter> shelters = new ArrayList<>(this.shelterCount);

	    int preyCount = this.preyCount;
	    int huntersRemaining = huntersPerShelter * shelterCount;
	    int shelterCount = this.shelterCount;

	    // Create the first Shelter before the loop
	    Shelter newShelter = world.createShelter(positions.get(0), Orientation.createRandom());
	    shelters.add(newShelter);
	    shelterCount--;

	    // Start the loop from the second position
	    for (int i = 1; i < positions.size(); i++) 
	    {
	        Point position = positions.get(i);
	        if (shelterCount > 0 && RandomUtil.unfairBool(33)) 
	        {
	            newShelter = world.createShelter(position, Orientation.createRandom());
	            shelters.add(newShelter);
	            shelterCount--;
	        }
	        else if (preyCount > 0 && RandomUtil.unfairBool(33)) 
	        {
	            world.createPrey(shelters.get(RandomUtil.integer(shelters.size())), chromosomes.get(--preyCount), position, Orientation.createRandom());
	        } 
	        else if (huntersRemaining > 0 && RandomUtil.unfairBool(100)) 
	        {
	            world.createHunter(shelters.get(RandomUtil.integer(shelters.size())), position, Orientation.createRandom());
	            huntersRemaining--;
	        }
	    }

	    return world;
	}

    /**
     * Compute the list of surviving chromosomes, the list of offspring chromosomes,
     * and creates a new world based on that latter list.
     * 
     * @post | getWorld() != null
     */
    public void nextGeneration()
    {
    	var survivingChromosomes = getSurvivingChromosomes();
    	var offspringChromosomes = computeOffspring(survivingChromosomes);
    	
    	world = createRandomWorldWith(new ArrayList<>(offspringChromosomes));
    }
    
    /**
     * Computes the list of surviving chromosomes for the next generation.
     *
     * @return The list of surviving chromosomes.
     * @post | result != null
     * @post | result.size() >= 0
     */
    private ArrayList<Chromosome> getSurvivingChromosomes()
    {
    	ArrayList<Chromosome> res = new ArrayList<>();
    	
    	//will display how many preys survive at each generation
    	System.out.println(String.format("%d preys survived", res.size()));
    	
    	return res;
    }
    
    /**
     * If parentGeneration is empty, returns a random list of chromosomes of size preyCount.
     * 
     * @param parentGeneration The list of parent chromosomes.
     * @return The list of offspring chromosomes.
     * @post | result != null
     * @post | result.size() >= 0
     */
    private ArrayList<Chromosome> computeOffspring(ArrayList<Chromosome> parentGeneration) {
        ArrayList<Chromosome> offspring = new ArrayList<>();
        
        if (parentGeneration.isEmpty()) 
        {
            offspring = Chromosome.createRandom(preyCount);
        } 
        else 
        {
            int parentCount = parentGeneration.size();
            for (int i = 0; i < preyCount; i++) 
            {
                int index1 = RandomUtil.integer(parentCount);
                int index2 = RandomUtil.integer(parentCount);
                Chromosome parent1 = parentGeneration.get(index1);
                Chromosome parent2 = parentGeneration.get(index2);
                Chromosome child = computeOffspring(parent1, parent2);
                offspring.add(child);
            }
        }
        
        return offspring;
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
    
    /**
     * Returns the size of the simulation world.
     * Used for documentation ONLY
     * 
     * Should not have representation exposure,
     * because object is a primitive int type & fields are final
     *
     * @return The size of the simulation world.
     */
    public int getWorldSize() 
    {
        return this.worldSize;
    }

    /**
     * Returns the number of shelters in the simulation.
     * Used for documentation ONLY
     * 
     * Should not have representation exposure,
     * because object is a primitive int type & fields are final
     *
     * @return The number of shelters in the simulation.
     */
    public int getShelterCount() 
    {
        return this.shelterCount;
    }

    /**
     * Returns the number of preys a new world should be inhabited with.
     * Used for documentation ONLY
     * 
     * Should not have representation exposure,
     * because object is a primitive int type & fields are final
     *
     * @return The number of preys a new world should be inhabited with.
     */
    public int getPreyCount() 
    {
        return this.preyCount;
    }

    /**
     * Returns the number of inhabitants per shelter.
     * Used for documentation ONLY
     * 
     * Should not have representation exposure,
     * because object is a primitive int type & fields are final
     *
     * @return The number of inhabitants per shelter.
     */
    public int getInhabitantsPerShelter() 
    {
        return this.inhabitantsPerShelter;
    }

    /**
     * Returns the number of hunters per shelter.
     * Used for documentation ONLY
     * 
     * Should not have representation exposure,
     * because object is a primitive int type & fields are final
     *
     * @return The number of hunters per shelter.
     */
    public int getHuntersPerShelter() 
    {
        return this.huntersPerShelter;
    }
}
