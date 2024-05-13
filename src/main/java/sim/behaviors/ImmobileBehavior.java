package sim.behaviors;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Color;

/**
 * This class represents an immobile behavior exhibited by creatures in the simulation.
 *
 * @invar | getColor().equals(Color.WHITE)
 */
public class ImmobileBehavior extends Behavior {

    /**
     * Initializes an ImmobileBehavior object with the given chromosome.
     *
     * @param chromosome The chromosome defining the behavior.
     */
    public ImmobileBehavior(Chromosome chromosome) {
        super(chromosome);
    }

    /**
     * Applies the ImmobileBehavior to the given creature in the specified world.
     * This behavior does not cause any changes to the creature.
     *
     * @param world The world in which the creature exists.
     * @param creature The creature to which the behavior is applied.
     */
    @Override
    public void applyBehavior(World world, Creature creature) {
        // No operation (NOP)
    }

    /**
     * Creates a copy of this ImmobileBehavior object with the specified chromosome.
     *
     * @param chromosome The chromosome for the copied behavior.
     * @return A new instance of ImmobileBehavior with the specified chromosome.
     *
     * @creates | result
     * @post | result != null
     * @post | result.getChromosome().equals(chromosome)
     */
    @Override
    public ImmobileBehavior copyWithChromosome(Chromosome chromosome) {
        return new ImmobileBehavior(chromosome);
    }

    /**
     * Retrieves the color associated with this behavior, which is always white.
     *
     * @return The color associated with this behavior.
     *
     * @post | result.equals(Color.WHITE)
     */
    @Override
    public Color getColor() {
        return Color.WHITE;
    }
}
