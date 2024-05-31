package sim.naturalselection;

import sim.World;
import util.Point;

/**
 * Represents a natural selection rule where organisms survive based on certain conditions.
 * This interface defines a method for determining if an organism survives at a given position in the world.
 * @immutable
 */
public interface NaturalSelection {

    /**
     * Determines if an organism survives at the specified position in the world according to the natural selection rule.
     * 
     * @param world The world in which the organism exists.
     * @param position The position of the organism.
     * @return {@code true} if the organism survives according to the natural selection rule, {@code false} otherwise.
     * @pre | world != null
     * @pre | position != null
     * @pre | Point.isWithin(position, world.getWidth(), world.getHeight())
     * @post true
     * 		The method does not change the state of the world or the position of the organism.
     * 		Therefore, there are no additional postconditions beyond the return value.
     */
    public boolean survives(World world, Point position);
}
