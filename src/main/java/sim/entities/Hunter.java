package sim.entities;

import java.util.ArrayList;
import sim.Constants;
import util.Color;
import util.Logic;
import util.Orientation;
import util.Point;
import util.RandomUtil;
import util.Vector;

public class Hunter extends Entity
{
	private int appetite;

	/**
     * Finds the closest prey among the given list of preys.
     *
     * @param preys The list of preys to search from.
     * @return The closest prey, or null if no prey is found.
     * 
     * @pre | preys != null
     */
	private Prey findClosestPrey(ArrayList<Prey> preys)
	{
		Prey closestPrey = null;
		int closestDistanceSquared = Integer.MAX_VALUE;
	
		for (var prey : preys)
		{
			var distanceSquared = this.getPosition().distanceSquared(prey.getPosition());
	
			if (distanceSquared < closestDistanceSquared)
			{
				closestPrey = prey;
				closestDistanceSquared = distanceSquared;
			}
		}
	
		return closestPrey;
	}

	/**
	 * The shelter where the hunter belongs.
	 * @peerObject
	 */
	final Shelter shelter;
	
	/**
     * Initializes a new hunter with the given parameters.
     *
     * @param world The world in which the hunter exists.
     * @param shelter The shelter where the hunter resides.
     * @param position The initial position of the hunter.
     * @param orientation The initial orientation of the hunter.
     * 
     * @pre | world != null
     * @pre | position != null
     * @pre | orientation != null
     * 
     * @post | getWorld() == world
     * @post | getPosition() == position
     * @post | getOrientation() == orientation
     * @post | getMoveProbability() == Constants.HUNTER_MOVE_PROBABILITY
     */
	Hunter(World world, Shelter shelter, Point position, Orientation orientation)
	{
		this(world, shelter, position, orientation, Constants.HUNTER_INITIAL_APPETITE);
	}
	
	/**
     * Initializes a new hunter with the given parameters.
     *
     * @param world The world in which the hunter exists.
     * @param shelter The shelter where the hunter resides.
     * @param position The initial position of the hunter.
     * @param orientation The initial orientation of the hunter.
     * @param appetite The initial appetite of the hunter.
     * 
     * @pre | world != null
     * @pre | position != null
     * @pre | orientation != null
     * @pre | appetite >= 0
     * 
     * @post | getWorld() == world
     * @post | getPosition() == position
     * @post | getOrientation() == orientation
     * @post | getMoveProbability() == Constants.HUNTER_MOVE_PROBABILITY
     */
	Hunter(World world, Shelter shelter, Point position, Orientation orientation, int appetite)
	{
		super(world, position, orientation, Constants.HUNTER_MOVE_PROBABILITY);
		this.shelter = shelter;
		this.appetite = appetite;
	}
	
	/**
     * Indicates whether this entity is considered a prey.
     *
     * @return true if this entity is a prey, false otherwise.
     * 
     * @post | result == false
     */
	@Override
	boolean isPreyPkg()
	{
		return false;
	}

	/**
     * Indicates whether this entity is considered a hunter.
     *
     * @return true if this entity is a hunter, false otherwise.
     * 
     * @post | result == true
     */
	@Override
	boolean isHunterPkg()
	{
		return true;
	}
	
	/**
     * Indicates whether this entity is considered a shelter.
     *
     * @return true if this entity is a shelter, false otherwise.
     * 
     * @post | result == false
     */
	@Override
	boolean isShelterPkg()
	{
		return false;
	}

	/**
     * Retrieves the color associated with this entity.
     *
     * @return The color of this entity.
     * 
     * @post | result == Color.RED
     */
	@Override
	public Color getColor()
	{
		return Color.RED;
	}

	/**
     * Retrieves a string representation of this hunter.
     *
     * @return A string describing the hunter.
     * 
     * @post | result != null
     */
	@Override
	public String toString()
	{
		return String.format("Hunter(position=%s)", this.getPosition());
	}

	/**
	 * Performs the action of the hunter.
	 * If there are preys nearby, the hunter will orient itself towards the closest prey.
	 * 
	 * @post If there are no preys nearby, the orientation remains unchanged.
	 * 
	 * @post If there is a closest prey, the hunter's orientation is updated to face it.
	 */
	@Override
	public void performAction()
	{
	    ArrayList<Prey> preys = this.getWorld().getPreys();
	    Prey closestPrey = findClosestPrey(preys);
	    
	    if (closestPrey != null) 
	    {
	        Vector targetDirection = this.getPosition().vectorTo(closestPrey.getPosition());
	        Orientation newOrientation = targetDirection.toClosestOrientation();
	        setOrientation(newOrientation);
	    }
	}
	
	@Override
	/**
	 * LEGIT
	 */
	public Hunter giveCopy() 
	{
		return new Hunter(super.world, shelter, getPosition(), getOrientation(), this.appetite);
	}
}
