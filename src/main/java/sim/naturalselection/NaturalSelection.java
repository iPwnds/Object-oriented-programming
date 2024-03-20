package sim.naturalselection;


import sim.World;
import util.Point;

/**
 * @immutable
 */
public interface NaturalSelection
{
	/**
	 * @pre | Point.isWithin(position, world.getWidth(), world.getHeight())
	 */
    public boolean survives(World world, Point position);
}
