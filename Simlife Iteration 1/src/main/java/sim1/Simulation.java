package sim1;

import java.util.ArrayList;
import java.util.Arrays;
import util.Orientation;
import util.Point;
import util.RandomUtil;
import util.Vector;


public class Simulation
{
	/**
	 * To remain efficient this reference can freely be accessed by the client
	 */
	private World world;
    private final int populationSize;

    
    /**
     * Creates a simulation having a getWorld() with:
     * - A square simulation field of side `size`
     * - A population size (resp. population A size) equal to `populationSize` (resp. `numA`)
     * - Randomly chosen orientations for all creatures
     * - Random positions for all creatures, within a central square whose points (x,y) are
     *   such that size/4 <= x < size/2 + size/4 (same for y)
     * - Randomly assigned chromosomes for creatures of kind A
     *    
     */
    public Simulation(int size, int populationSize, int numA)
    {
    	this.populationSize = populationSize;
        this.world = createRandWorldWith(size, populationSize, numA, populationSize - numA, Chromosome.createRandom(numA));
    }
    
    public int getPopulationSize() 
    {
    	return populationSize;
    }
    
    /**
     * Creates a World with:
     * - A square simulation field of side `size`
     * - A population size (resp. population A size) equal to `popuSize` (resp. `numA`)
     * - A population B size equal to `numB`
     * - Randomly chosen orientations for all creatures
     * - Random positions for all creatures, within a central square whose points (x,y) are
     *   such that size/4 <= x < size/2 + size/4 (same for y)
     * - Chromosomes for creatures of kind A as in `chromsA`
     * 
     * @pre | size >= 0
     * @pre | popuSize >= 0
     * @pre | numA >= 0
     * @pre | numB >= 0
     * @pre | chromsA != null
     * @pre | chromsA.length == numA
     * @post | result != null
     * @post | result.getWidth() == size
     * @post | result.getHeight() == size
     * @post | result.getPopulationA().length == numA
     * @post | result.getPopulationB().length == numB
     */
    public static World createRandWorldWith(int size, int popuSize, int numA, int numB, Chromosome[] chromsA) 
    {	
    	CreatureA[] populationA = new CreatureA[numA];
        CreatureB[] populationB = new CreatureB[numB];
        
        for (int i = 0; i < numA; i++) 
        {
            populationA[i] = new CreatureA
            (
                new BehaviorA(),
                Point.createRandom(size / 2, size / 2),
                Orientation.createRandom(),
                chromsA[i]
            );
        }
        
        for (int i = 0; i < numB; i++)
        {
            populationB[i] = new CreatureB
            (
                new BehaviorB(),
                Point.createRandom(size / 2, size / 2),
                Orientation.createRandom()
            );
        }
        
        return new World(size, size, populationA, populationB);
    }
    
    /**
     * @return
     * 
     * @post | result != null
 	 * @post | result.getPopulationA() != null
 	 * @post | result.getPopulationB() != null
     */
    public World getWorld() 
    {
    	CreatureA[] popA = world.getPopulationA();
    	CreatureB[] popB = world.getPopulationB();
    	return new World(world.getWidth(), world.getHeight(), popA, popB);
    }

    /**
     * Replaces getWorld() with a new one. The latter is populated according to the same ratio
     * CreatureA/(CreatureA + CreatureB) of creatures of kind A,B that survived.
     * 
     * The DNA of CreatureA's of the new world  is derived from the DNA
     * of CreatureA's that survived. Specifically, Each new chromosome
     * is obtained by crossing over some surviving parent chromosomes and by maybe
     * applying a random mutation.
     * 
     * @pre | Constants.INIT_CREAT_A >= 0
     */
    public void nextGeneration()
    {
    	int survA = countSurvivingCreatureA();
        int survB = countSurvivingCreatureB();

        int nextCountA = 0;
        int nextCountB = 0;

        if (survA + survB == 0) 
        {
            nextCountA = Constants.INIT_CREAT_A;
            nextCountB = populationSize - nextCountA;
        } 
        
        else 
        {
            nextCountA = (int) Math.floor(((double) survA / (survA + survB)) * populationSize);
            nextCountB = populationSize - nextCountA;
        }
    }
    
    /**
     * Returns the number of CreatureB that survive (see this.survives)
     * 
     * @pre | world != null
     * @pre | world.getPopulationA() != null
 	 * @pre | world.getPopulationA().length >= 0
 	 * 
 	 * @return | result >= 0
 	 * @post | result <= world.getPopulationA().length
     */
    private int countSurvivingCreatureB() 
    {
    	int count = 0;
        CreatureA[] populationA = world.getPopulationA();
        
        for (CreatureA creature : populationA) 
        {
            if (survives(creature.getPosition())) 
            {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Returns the number of CreatureA that survive (see this.survives)
     * 
     * @pre | world != null
     * @pre | world.getPopulationB() != null
     * @pre | world.getPopulationB().length >= 0
     * 
     * @return | result >= 0
     * @post | result <= world.getPopulationB().length
     */
    private int countSurvivingCreatureA() 
    {
    	int count = 0;
        CreatureB[] populationB = world.getPopulationB();
        
        for (CreatureB creature : populationB) 
        {
            if (survives(creature.getPosition())) 
            {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * The list of Chromosome's of creatures of kind A that survive (according to this.survives)
     * 
     * @pre | world != null
     * @pre | world.getPopulationA() != null
     * 
     * @return | result != null
     * @return | result.size() >= 0
     */
    private ArrayList<Chromosome> selectSurvivingDNA()
    {
    	ArrayList<Chromosome> result = new ArrayList<Chromosome>();
    	
        for (CreatureA creature : world.getPopulationA()) 
        {
            if (survives(creature.getPosition())) 
            {
            	result.add(creature.getChromosome());
            }
        }
        
        return result;
    }
    
    /**
     * Returns an array of `count` Chromosomes.
     * 
     * Each such "offpsring" chromosome is obtained as a (1) random crossover (see Chromosome.crossover)
     * of 2 chromosomes called "parents" randomly picked in the input list.
     * and (2) some offpsring chromosomes are further subject to a mutation
     * 
     * if parentGeneration is empty, the result array consists of `count` random chromosomes. 
     * 
     * @param parentGeneration
     * @param count
     * @return
     * 
     * @pre | parentGeneration != null
     * @pre | count >= 0
     * 
     * @post | result != null
     * @post | result.length == count
     * @post | Arrays.stream(result).allMatch(c -> c != null)
     */
    private Chromosome[] computeOffspring(ArrayList<Chromosome> parentGeneration, int count)
    {
    	Chromosome[] offspring = new Chromosome[count];
    	
        for (int i = 0; i < count; i++) {
            Chromosome parent1 = parentGeneration.get(RandomUtil.integer(parentGeneration.size()));
            Chromosome parent2 = parentGeneration.get(RandomUtil.integer(parentGeneration.size()));
            offspring[i] = parent1.crossover(parent2, Constants.CHROM_SIZE / 2);
            
            if (RandomUtil.integer(100) < Constants.MUT_RATE) 
            {
                offspring[i].randomlyMutate();
            }
        }
        
        return offspring;
    }
    
    /**
     * LEGIT
     * 
     * @pre | pos != null
     * Survive zone = Lower right ninth of the field 
     */
    public boolean survives(Point pos) {
    	return isInSouthEastZone(pos);
    }
    
    /**
     * LEGIT 
     * 
     * @param pos
     * @return
     */
    private boolean isInSouthEastZone(Point pos) {
    	return (pos.getX() >= 2 * world.getWidth() / 3) &&
    			(pos.getY() >= 2* world.getHeight() / 3);
    } 
}
