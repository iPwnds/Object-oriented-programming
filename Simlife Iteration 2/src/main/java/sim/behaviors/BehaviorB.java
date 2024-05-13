package sim.behaviors;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Color;
import util.RandomUtil;
import util.Vector;
import static util.Logic.*;

/**
 * This class represents a specific behavior exhibited by creatures in the simulation.
 *
 * @immutable
 * @invar | getColor().equals(Color.BLUE)
 */
public class BehaviorB extends Behavior
{
    /**
     * Initializes a BehaviorB object with the given chromosome.
     *
     * @param chromosome The chromosome defining the behavior.
     */
    public BehaviorB(Chromosome chromosome)
    {
        super(chromosome);
    }

    /**
     * Retrieves the color associated with this behavior, which is always blue.
     *
     * @return The color associated with this behavior.
     *
     * @post | result.equals(Color.BLUE)
     */
    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    /**
     * Applies the BehaviorB to the given creature in the specified world.
     *
     * @param world The world in which the creature exists.
     * @param creature The creature to which the behavior is applied.
     *
     * @mutates | creature
     * @inspects | world
     * @pre | world != null
     * @pre | creature != null
     * @post If the creature is located at the edge of the world, it does not change its position.
     *       | implies(world.isLimPos(old(creature.getPosition())), old(creature.getPosition()).equals(creature.getPosition()))
     * @post If the creature is located at the edge of the world, it does not change its orientation.
     *       | implies(world.isLimPos(old(creature.getPosition())), old(creature.getOrientation()).equals(creature.getOrientation()))
     * @post If the creature is not located at the edge of the world, it either moves or it turns.
     *       | implies(!world.isLimPos(old(creature.getPosition())), iff(old(creature.getPosition()).equals(creature.getPosition()), !old(creature.getOrientation()).equals(creature.getOrientation())))
     */
    @Override
    public void applyBehavior(World world, Creature creature)
    {
        var position = creature.getPosition();
        
        // Creatures that are not touching a wall are not done.
        if (!world.isLimPos(position)) {
            creature.moveForward(world, new Vector(0, 0));
            // If it has not moved, it turns randomly.
            if (creature.getPosition().equals(position)) {
                boolean turnleft = RandomUtil.bool();
                if (turnleft) {
                    creature.turnCounterclockwise();
                } else {
                    creature.turnClockwise();
                }
            }
        }
    }

    /**
     * Creates a copy of this BehaviorB object with the specified chromosome.
     *
     * @param chromosome The chromosome for the copied behavior.
     * @return A new instance of BehaviorB with the specified chromosome.
     *
     * @creates | result
     * @post | result != null
     * @post | result.getChromosome().equals(chromosome)
     */
    @Override
    public BehaviorB copyWithChromosome(Chromosome chromosome)
    {
        return new BehaviorB(chromosome);
    }
}
