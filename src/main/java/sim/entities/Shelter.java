package sim.entities;

import java.util.ArrayList;

import sim.Constants;
import util.Color;
import util.Logic;
import util.Orientation;
import util.Point;
import util.RandomUtil;

public class Shelter extends MortalEntity
{
    /**
	 * @peerObjects
	 * @representationObject
     */
    final ArrayList<Prey> inhabitants;

    
    Shelter(World world, Point position, Orientation orientation)
    {
        super(world, position, orientation, Constants.SHELTER_MOVE_PROBABILITY);
        this.inhabitants = new ArrayList<>();
    }

    @Override
	boolean isPreyPkg()
	{
	    return false;
	}

	@Override
	boolean isShelterPkg()
	{
	    return false;
	}

	@Override
	boolean isHunterPkg()
	{
	    return false;
	}



	public ArrayList<Prey> getInhabitants()
    {
        return inhabitants;
    }

    @Override
    public void performActionIfAlive()
    {

    }

    @Override
    public Color getColor()
    {
        return null;
    }

    @Override
    public String toString()
    {
        return String.format("Shelter(position=%s)", this.getPosition());
    }
    
    @Override
    /**
     * LEGIT
     */
    public Shelter giveCopy() {
    	return new Shelter(super.world, getPosition(), getOrientation());
    }
}
