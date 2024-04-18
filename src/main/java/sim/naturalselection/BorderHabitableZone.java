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
    int x = position.getX();
    int y = position.getY();
    int width = world.getWidth();
    int height = world.getHeight();

    return x < borderSize || y < borderSize || x >= width - borderSize || y >= height - borderSize;
    }
    
}
