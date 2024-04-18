package sim.behaviors;

import util.Color;
import util.Orientation;
import util.RandomUtil;
import static util.Logic.*;

import sim.Chromosome;
import sim.Constants;
import sim.Creature;
import sim.World;

/**
 * This class represents a specific behavior exhibited by creatures in the simulation.
 *
 * @immutable
 * @invar | getColor().equals(Color.RED)
 */
public class BehaviorA extends Behavior
{
    /**
     * Initializes a BehaviorA object with the given chromosome.
     *
     * @param chromosome The chromosome defining the behavior.
     */
    public BehaviorA(Chromosome chromosome)
    {
        super(chromosome);
    }

    /**
     * Retrieves the color associated with this behavior, which is always red.
     *
     * @return The color associated with this behavior.
     *
     * @post | result.equals(Color.RED)
     */
    @Override
    public Color getColor() {
        return Color.RED;
    }

    /**
     * Applies the BehaviorA to the given creature in the specified world.
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
        var drift = computeFavoriteOrientation().toVector();

        if (!world.isLimPos(position)) {
            creature.moveForward(world, drift);
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
     * Computes the favorite orientation of the creature based on its first three genes.
     *
     * @return The computed favorite orientation.
     *
     * @post | result != null
     * @post | Orientation.orientations().contains(result)
     * @post | Orientation.orientations().indexOf(result) >= 0 && Orientation.orientations().indexOf(result) <= 7
     * @post | Orientation.orientations().get((Orientation.orientations().indexOf(result))) == result
     */
    private Orientation computeFavoriteOrientation() {

        int mid = Constants.GENE_MIN + ((Constants.GENE_MAX - Constants.GENE_MIN) / 2);

        int bit0 = (getChromosome().getGene(0) <= mid) ? 0 : 1;
        int bit1 = (getChromosome().getGene(1) <= mid) ? 0 : 1;
        int bit2 = (getChromosome().getGene(2) <= mid) ? 0 : 1;

        int res = (bit2 << 2) | (bit1 << 1) | bit0;
        if (!(0 <= res && res <= 7)) {
            throw new ArithmeticException("Average abs. gene value not in the expected range");
        }

        return Orientation.orientations().get(res);
    }

    /**
     * Creates a copy of this BehaviorA object with the specified chromosome.
     *
     * @param chromosome The chromosome for the copied behavior.
     * @return A new instance of BehaviorA with the specified chromosome.
     *
     * @creates | result
     * @post | result != null
     * @post | result.getChromosome().equals(chromosome)
     */
    @Override
    public BehaviorA copyWithChromosome(Chromosome chromosome)
    {
        return new BehaviorA(chromosome);
    }
}
