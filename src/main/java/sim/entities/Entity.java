package sim.entities;

import util.Color;
import util.Logic;
import util.Orientation;
import util.Point;
import util.RandomUtil;
import static util.Logic.*
;


/**
 * Supertype for all entities.
 * 
 * An entity resides in a world, has a position, an orientation and a move probability.
 * 
 */
public abstract class Entity
{


    private Point position;
    
    private Orientation orientation;
    
    /**
     * @invar | 0 <= moveProbability && moveProbability <= 100
     */
    private final int moveProbability;


    /**
	 * @peerObject
	 */
	World world;


	Entity(World world, Point position, Orientation orientation, int moveProbability)
    {

    	this.world = null;
    	this.position = null;
    	this.orientation = null;
    	this.moveProbability = 0;
    }
    
    boolean isAlivePkg() { return true; }

	abstract boolean isHunterPkg();

	abstract boolean isPreyPkg();

	abstract boolean isShelterPkg();

	/**
	 * LEGIT
	 */
	Point getPositionPkg() {
		return position;
	}

	/**
     * Returns the world which this entity inhabits.
     */
    public World getWorld()
    {
    	return null;
    }
    
    /**
     * Current position of this entity in the world.
     */
    public Point getPosition() {
    	return null;
    }
    
    /**
     * Current orientation of this entity.
     */
    public Orientation getOrientation() {
    	return null;
    }

    /**
     * Probability (integer between 0 and 100) that the entity moves at each step.
     */
    public int getMoveProbability() {
    	return 0;
    }
    
    /**
     * Changes the orientation of the entity.
     * 
     */
    public void setOrientation(Orientation orientation) {
    	this.orientation = orientation;
    }
    

	public void turnClockwise()
	{
	    this.orientation = this.orientation.turnClockwise(1);
	}

	public void turnCounterclockwise()
	{
	    this.orientation = this.orientation.turnCounterclockwise(1);
	}

	/**
     * Computes the position where the entity would arrive if it were to move one step
     * forward in its current orientation. This does not take into account whether
     * this position is free or not.
     */
    public Point destination()
    {
    	return null;
    }
    
    /**
     * The current position is set (if there is room) to current pos + current orientation.
     * Note: this method is not probabilistic
     * 
     */
    public void moveForward()
    {
        var oldPosition = this.position;
        var newPosition = destination();

        if ( world.isFree(newPosition) )
        {
            this.position = newPosition;
            
        }
    }
    
    /**
     * Samples using moveProbability and attempts to move if the latter result is true
     * See RandomUtil.unfairBool
     */
    public void moveForwardWithProbability()
    {

    }
    
    public abstract void performAction();

	/**
     * Returns the color of the entity.
     */
    public abstract Color getColor();
    
    /**
     * Checks whether this entity is a prey.
     */
    public boolean isPrey()
    {
        return isPreyPkg();
    }
    
    /**
     * Checks whether this entity is a hunter.
     */
    public boolean isHunter()
    {
        return isHunterPkg();
    }
    
    /**
     * Checks whether this entity is a shelter.
     */
    public boolean isShelter()
    {
        return isShelterPkg();
    }
    
    /**
     * Hint: only flawed methods use this method (or its children).
     * In our implementation this method is never used.
     */
    public abstract Entity giveCopy();
    
}
