package sim.naturalselection;

import sim.World;
import util.Point;

public class BorderHabitableZone implements NaturalSelection
{

    private final int borderSize;

    public BorderHabitableZone(int borderSize)
    {
    	
        this.borderSize = borderSize;
    }

    @Override
    public boolean survives(World world, Point position)
    {
        return false;

    }
}
