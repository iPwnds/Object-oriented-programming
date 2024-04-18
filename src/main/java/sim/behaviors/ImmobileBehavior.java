package sim.behaviors;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Color;

/**
 * Represents a behavior where the creature remains immobile.
 * 
 * @invar | getColor().equals(Color.WHITE)
 */
public class ImmobileBehavior extends Behavior {
    
    /**
     * Initializes an immobile behavior with the given chromosome.
     * 
     * @param chromosome - The chromosome representing the behavior parameters.
     * @pre | chromosome != null
     */
    public ImmobileBehavior(Chromosome chromosome) {
        super(chromosome);
    }
    
    /**
     * Applies the immobile behavior to the creature in the world.
     * 
     * @param world - The world where the creature resides.
     * @param creature - The creature to apply the behavior to.
     * @pre | world != null
     * @pre | creature != null
     */
    @Override
    public void applyBehavior(World world, Creature creature) {
        // NOP (No Operation) - The creature remains immobile.
    }
    
    /**
     * Creates a copy of the immobile behavior with the given chromosome.
     * 
     * @param chromosome - The chromosome for the copied behavior.
     * @return A new instance of ImmobileBehavior with the specified chromosome.
     * @pre | chromosome != null
     */
    @Override
    public ImmobileBehavior copyWithChromosome(Chromosome chromosome) {
        return new ImmobileBehavior(chromosome);
    }
    
    /**
     * Gets the color of the immobile creature.
     * 
     * @return The color of the immobile creature, which is always white.
     */
    @Override
    public Color getColor() {
        return Color.WHITE;
    }
}