package sim.naturalselection;

import sim.World;
import util.Point;

/**
 * Represents a natural selection rule where organisms survive if they are in the south-east region of the world.
 */
public class SouthEastHabitableZone implements NaturalSelection {

    /**
     * Determines if an organism survives at the specified position in the world according to the south-east habitation zone.
     * 
     * @param world The world in which the organism exists.
     * @param pos The position of the organism.
     * @return {@code true} if the organism survives in the south-east region, {@code false} otherwise.
     * @pre | world != null
     * @pre | pos != null
     * @post | result == (pos.getX() >= 2 * world.getWidth() / 3) && (pos.getY() >= 2 * world.getHeight() / 3)
     */
	@Override
	public boolean survives(World world, Point pos) {
    	return (pos.getX() >= 2 * world.getWidth() / 3) &&
    			(pos.getY() >= 2 * world.getHeight() / 3);
	}
}
