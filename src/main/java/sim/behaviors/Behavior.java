package sim.behaviors;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Color;

/**
 * @immutable
 * 
 * Represents a behavior that can be applied to a creature in a simulated world.
 */
public abstract class Behavior {

    private Chromosome chromosome;

    /**
     * Initializes a behavior with the specified chromosome.
     * 
     * @param chromosome - The chromosome representing the parameters of the behavior.
     * @pre | chromosome != null
     */
    public Behavior(Chromosome chromosome) {
        this.chromosome = chromosome;
    }

    /**
     * Retrieves the chromosome associated with this behavior.
     * 
     * @return The chromosome representing the parameters of the behavior.
     */
    public Chromosome getChromosome() {
        return chromosome;
    }

    /**
     * Applies the behavior to the specified creature in the given world.
     * 
     * @param world - The world where the creature resides.
     * @param creature - The creature to which the behavior will be applied.
     * @pre | world != null
     * @pre | creature != null
     */
    public abstract void applyBehavior(World world, Creature creature);

    /**
     * LEGIT
     */
    public Color getColor() {
    	return Color.BLACK;
    }

    /**
     * Creates a copy of this behavior with the specified chromosome.
     * 
     * @param chromosome - The chromosome for the copied behavior.
     * @return A new instance of the behavior with the specified chromosome.
     * @pre | chromosome != null
     * @creates | result
     */
    public abstract Behavior copyWithChromosome(Chromosome chromosome);
}
