package sim.naturalselection;

import sim.World;
import util.Point;

public class CircularHabitableZone implements NaturalSelection
{

    private final Point center;


    private final int radiusSquared;

    public CircularHabitableZone(Point center, int radius)
    {
        this.center = center;
        this.radiusSquared = radius * radius;
    }

    @Override
    public boolean survives(World world, Point position)
    {
    	int dx = position.getX() - center.getX();
        int dy = position.getY() - center.getY();
        int distanceSquared = dx * dx + dy * dy;

        return distanceSquared <= radiusSquared;
    }
}
