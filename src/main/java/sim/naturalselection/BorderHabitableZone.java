package sim.naturalselection;

import sim.World;
import util.Point;

/**
 * Represents a natural selection rule where organisms survive if they are within a border zone of the world.
 */
public class BorderHabitableZone implements NaturalSelection {

    /** The size of the border zone. */
    private final int borderSize;

    /**
     * Constructs a BorderHabitableZone object with the specified border size.
     * 
     * @param borderSize The size of the border zone. Must be non-negative.
     * @pre | borderSize >= 0
     */
    public BorderHabitableZone(int borderSize) {
        this.borderSize = borderSize;
    }

    /**
     * Determines if an organism survives at the specified position in the world according to the border zone.
     * 
     * @param world The world in which the organism exists.
     * @param position The position of the organism.
     * @return true if the organism survives within the border zone, false otherwise.
     * @pre | world != null
     * @pre | position != null
     */
    @Override
    public boolean survives(World world, Point position) {
        int x = position.getX();
        int y = position.getY();
        int width = world.getWidth();
        int height = world.getHeight();

        return x < borderSize || y < borderSize || x >= width - borderSize || y >= height - borderSize;
    }
    
}
