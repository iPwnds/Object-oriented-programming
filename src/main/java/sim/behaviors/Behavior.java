package sim.behaviors;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Color;

/**
 * This class represents a behavior exhibited by creatures in the simulation.
 * 
 * @immutable
 */
public abstract class Behavior
{

	private Chromosome chromosome;
	
	/**
	 * Initializes a behavior with the given chromosome.
	 * 
	 * @param chromosome The chromosome defining the behavior.
	 */
	public Behavior(Chromosome chromosome)
	{
		this.chromosome = chromosome;
	}
	
	/**
	 * Retrieves the chromosome associated with this behavior.
	 * 
	 * @return The chromosome defining the behavior.
	 */
	public Chromosome getChromosome()
	{
		return chromosome;
	}
		
    /**
     * Applies the behavior to the given creature in the specified world.
     * 
     * @param world The world in which the creature exists.
     * @param creature The creature to which the behavior is applied.
     * 
     * @mutates | creature
     * @inspects | world
     */
    public abstract void applyBehavior(World world, Creature creature);
    
    /**
     * Retrieves the color associated with this behavior.
     * 
     * @return The color associated with this behavior.
     * 
     * @post | result != null
     */
    public abstract Color getColor();
    
    /**
     * Creates a copy of this behavior with the specified chromosome.
     * 
     * @param chromosome The chromosome for the copied behavior.
     * @return A new instance of Behavior with the specified chromosome.
     * 
     * @creates | result
     * @post | result != null
     * @post | result.getChromosome().equals(chromosome)
     */
    public abstract Behavior copyWithChromosome(Chromosome chromosome);
}
