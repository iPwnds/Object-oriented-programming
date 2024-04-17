package sim.behaviors;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Color;

/**
 * @immutable
 * This class represents the behavior of a creature in the simulation.
 */
public abstract class Behavior
{
	public Chromosome chromosome;
	
    /**
     * Constructs a new Behavior with the specified chromosome.
     * @param chromosome The chromosome associated with this behavior.
     * @pre | chromosome != null
     * @post | this.chromosome == null
     */
	public Behavior(Chromosome chromosome)
	{
		this.chromosome = null;
	}
	
    /**
     * Returns the chromosome associated with this behavior.
     * @return | The chromosome associated with this behavior.
     * @post | result == this.chromosome
     */
    public Chromosome getChromosome()
    {
        return chromosome;
    }
	
    /**
     * Applies this behavior to the specified creature in the specified world.
     * @param world The world in which the creature exists.
     * @param creature The creature to which this behavior is applied.
     * @pre | world != null && creature != null
     */
    public abstract void applyBehavior(World world, Creature creature);
    
    /**
     * LEGIT
     */
    public Color getColor() {
    	return Color.BLACK;
    }
    
    /**
     * Returns a copy of this behavior with the specified chromosome.
     * @param chromosome The chromosome for the copied behavior.
     * @return A copy of this behavior with the specified chromosome.
     * @pre | chromosome != null
     * @post | result != null && result.getChromosome() == chromosome
     */
    public Behavior copyWithChromosome(Chromosome chromosome) {
        // Create a new instance of the behavior class
        Behavior copy = null;
        try {
            copy = getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        // Set the chromosome of the copy
        copy.chromosome = chromosome;
        
        return copy;
    }
}