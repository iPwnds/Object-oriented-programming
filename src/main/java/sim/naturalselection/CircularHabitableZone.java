package sim.naturalselection;

import sim.World;
import util.Point;

/**
 * Represents a natural selection rule where organisms survive if they are within a circular habitation zone centered at a specified point.
 */
public class CircularHabitableZone implements NaturalSelection {

    /** The center point of the circular habitation zone. */
    private final Point center;

    /** The square of the radius of the circular habitation zone. */
    private final int radiusSquared;

    /**
     * Constructs a CircularHabitableZone object with the specified center and radius.
     * 
     * @param center The center point of the circular habitation zone.
     * @param radius The radius of the circular habitation zone. Must be non-negative.
     * @pre | center != null
     * @pre | radius >= 0
     */
    public CircularHabitableZone(Point center, int radius) {
        this.center = center;
        this.radiusSquared = radius * radius;
    }

    /**
     * Determines if an organism survives at the specified position in the world according to the circular habitation zone.
     * 
     * @param world The world in which the organism exists.
     * @param position The position of the organism.
     * @return {@code true} if the organism survives within the circular habitation zone, {@code false} otherwise.
     * @pre | world != null
     * @pre | position != null
     */
    @Override
    public boolean survives(World world, Point position) {
        int dx = position.getX() - center.getX();
        int dy = position.getY() - center.getY();
        int distanceSquared = dx * dx + dy * dy;

        return distanceSquared <= radiusSquared;
    }
}