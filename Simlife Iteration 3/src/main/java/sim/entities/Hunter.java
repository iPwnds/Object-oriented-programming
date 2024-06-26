package sim.entities;

import java.util.ArrayList;
import sim.Constants;
import util.Color;
import util.Orientation;
import util.Point;
import util.RandomUtil;

/**
 * Represents a hunter entity in the simulation.
 * @mutable
 * @invar | getAppetite() >= 0
 * @invar | getShelter() != null
 */
public class Hunter extends Entity
{
	/**
	 *  * @invar | appetite >= 0
	 */
	private int appetite;
	
	public void setAppetite(int appetite) {
		this.appetite = appetite;
	}

	/**
	 * The shelter associated with the hunter.
	 * 
	 * @peerObject
	 * @invar | shelter != null
	 */
	final Shelter shelter;

	/**
     * Finds the closest prey among the given list of preys.
     * 
     * @pre | preys != null
     * @post | result == null || preys.contains(result)
     */
	private Prey findClosestPrey(ArrayList<Prey> preys)
	{
		Prey closestPrey = null;
		int closestDistanceSquared = Integer.MAX_VALUE;
	
		for (var prey : preys)
		{
			var distanceSquared = this.getPosition().distanceSquared(prey.getPosition());
	
			if (distanceSquared < closestDistanceSquared && this.shelter.getInhabitants().contains(prey))
			{
				closestPrey = prey;
				closestDistanceSquared = distanceSquared;
			}
		}
	
		return closestPrey;
	}
	
	/**
     * Initializes a new hunter with the specified world, shelter, position, and orientation,
     * and the default initial appetite.
     * 
     * @throws IllegalArgumentException | shelter == null
     * @post | getPosition().equals(position)
     * @post | getOrientation().equals(orientation)
     * @post | getAppetite() == 0
     */
	Hunter(World world, Shelter shelter, Point position, Orientation orientation)
	{
		
		this(world, shelter, position, orientation, 0);
	}
	
	/**
     * Initializes a new hunter with the specified world, shelter, position, orientation,
     * and appetite.
     * 
     * @throws IllegalArgumentException | shelter == null
     * @throws IllegalArgumentException | appetite < 0
     * @post | getPosition().equals(position)
     * @post | getOrientation().equals(orientation)
     * @post | getAppetite() == appetite
     */
	Hunter(World world, Shelter shelter, Point position, Orientation orientation, int appetite)
	
	{

		super(world, position, orientation, Constants.HUNTER_MOVE_PROBABILITY);
		this.shelter = shelter;
		this.appetite = appetite;
	}
	/**
	 * 
	 * @post | result != null
	 */
	public Shelter getShelter() {
		return shelter;
	}

	/**
     * Returns true indicating that this entity is not a prey.
     * 
     * @post | result == false
     */
	@Override
	boolean isPreyPkg()
	{
		return false;
	}

	/**
     * Returns true indicating that this entity is a hunter.
     * 
     * @post | result == true
     */
	@Override
	boolean isHunterPkg()
	{
		return true;
	}

	/**
     * Returns false indicating that this entity is not a shelter.
     * 
     * @post | result == false
     */
	@Override
	boolean isShelterPkg()
	{
		return false;
	}

	/**
     * Returns the color representation of the hunter.
     * 
     * @post | result != null
     */
	@Override
	public Color getColor()
	{
		return Color.RED;
	}

	/**
     * Returns a string representation of the hunter.
     * 
     * @post | result != null
     */
	@Override
	public String toString()
	{
		return String.format("Hunter(position=%s)", this.getPosition());
	}

	/**
	 * Performs the action of the hunter, which is to orient towards the closest prey.
	 * 
	 * @post (closestPrey == null) or getOrientation().equals(Orientation.fromVector(getPosition().vectorTo(closestPrey.getPosition())))
	 */
	@Override
	public void performAction()
	{
		if(getAppetite() == Constants.HUNTER_INITIAL_APPETITE) {
			return;
		}
		var preys = this.shelter.getInhabitants();
        var closestPrey = findClosestPrey(preys);
        if (closestPrey != null) 
        {
            var targetDirection = this.getPosition().vectorTo(closestPrey.getPosition());
            var newOrientation = Orientation.fromVector(targetDirection);
            setOrientation(newOrientation);
        }
        if (RandomUtil.unfairBool(this.getMoveProbability())) 
    	{
        	if (closestPrey != null) {
	        	Point newposition = this.destination();
	        	if(newposition.equals(closestPrey.getPosition())){
	        		closestPrey.diePkg();
	        		this.setAppetite(getAppetite() + 1);
	        	}
        	}
            moveForward();
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
	
	/**
     * Returns the appetite of the hunter.
     * Used for documentation ONLY
     * 
     * Should not be representation exposure,
     * because object is a primitive int type
     * 
     * @post | result >= 0
     */
    public int getAppetite() 
    {
        return this.appetite;
    }
}
