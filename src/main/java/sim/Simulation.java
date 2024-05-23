package sim;

import java.util.ArrayList;
import sim.entities.Entity;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.entities.World;
import util.Orientation;
import util.Point;
import util.RandomUtil;

/**
 * Represents a simulation environment where entities interact and evolve over generations.
 * The simulation includes shelters, preys, and hunters.
 * @mutable
 * @invar | getWorld() != null
 */
public class Simulation
{
	private final int inhabitantsPerShelter;
	
	/**
	 * not a representation object for performance
	 * @invar | getWorld() != null 
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
     * @throws IllegalArgumentException | worldSize <= 0
     * @throws IllegalArgumentException | shelterCount <= 0
     * @throws IllegalArgumentException | inhabitantsPerShelter <= 0
     * @throws IllegalArgumentException | huntersPerShelter < 0
     * @post | getWorldSize() == worldSize
     * @post | getShelterCount() == shelterCount
     * @post | getPreyCount() == inhabitantsPerShelter * shelterCount
     * @post | getInhabitantsPerShelter() == inhabitantsPerShelter
     * @post | getHuntersPerShelter() == huntersPerShelter
     */
    public Simulation(int worldSize, int shelterCount, int inhabitantsPerShelter, int huntersPerShelter) 
    {
    	if(worldSize <= 0 && shelterCount <= 0 && inhabitantsPerShelter <= 0 &&  huntersPerShelter < 0) {
    		throw new IllegalArgumentException();
    	}
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
     //* @post | result.getPreys().size() == chromosomes.size()
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
	    int i = 0;

	    for (i = 0; i < shelterCount; i++) {
	        Shelter newShelter = world.createShelter(positions.get(i), Orientation.createRandom());
	     
	        shelters.add(newShelter);
	    }


	    for (Shelter shelter : shelters) {
	    	int preysInShelter = 0;
	    	int huntersInShelter = 0;
	        while(preyCount > 0 && preysInShelter < Constants.INHABITANTS_PER_SHELTER) {
	        	Point position = positions.get(i++);
	            world.createPrey(shelter, chromosomes.get(--preyCount), position, Orientation.createRandom());
	            preysInShelter++;
	        	}
	        while(huntersRemaining > 0 && huntersInShelter < Constants.HUNTERS_PER_SHELTER) {
	        	Point point = positions.get(i++);
	        	huntersRemaining--;
	            world.createHunter(shelter, point, Orientation.createRandom());
	            huntersInShelter++;
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
    	
    	for (Entity entity : world.getEntities()) {
            if (entity instanceof Prey prey && prey.isDead() == false) {
                res.add(prey.getChromosome());
            }
        }
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