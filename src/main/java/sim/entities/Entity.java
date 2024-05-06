package sim.entities;

import util.Color;
import util.Logic;
import util.Orientation;
import util.Point;
import util.RandomUtil;
import util.Vector;
import static util.Logic.*;

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
	
	/**
     * Initializes an entity with the specified parameters.
     * 
     * @param world The world in which the entity resides.
     * @param position The initial position of the entity.
     * @param orientation The initial orientation of the entity.
     * @param moveProbability The probability (0 to 100) that the entity moves at each step.
     * 
     * @pre | world != null
     * @pre | position != null
     * @pre | orientation != null
     * @pre | 0 <= moveProbability && moveProbability <= 100
     * @post | this.getWorld() == world
     * @post | this.getPosition() == position
     * @post | this.getOrientation() == orientation
     * @post | this.getMoveProbability() == moveProbability
     */
	Entity(World world, Point position, Orientation orientation, int moveProbability)
    {
    	this.world = world;
    	this.position = position;
    	this.orientation = orientation;
    	this.moveProbability = 0;
    }
    
    boolean isAlivePkg() { return true; }

	abstract boolean isHunterPkg();

	abstract boolean isPreyPkg();

	abstract boolean isShelterPkg();

	/**
	 * LEGIT
	 */
	Point getPositionPkg() 
	{
		return position;
	}

	/**
     * Returns the world which this entity inhabits.
     *
     * @return The world object.
     * 
     * @post | result == this.getWorld()
     */
    public World getWorld()
    {
    	return world;
    }
    
    /**
     * Current position of this entity in the world.
     * 
     * @return The position of the entity.
     * 
     * @post | result == this.getPosition()
     */
    public Point getPosition() 
    {
    	return position;
    }
    
    /**
     * Current orientation of this entity.
     * 
     * @return The orientation of the entity.
     * 
     * @post | result == this.getOrientation()
     */
    public Orientation getOrientation() 
    {
    	return orientation;
    }

    /**
     * Probability (integer between 0 and 100) that the entity moves at each step.
     * 
     * @return The move probability of the entity.
     * 
     * @post | result == this.getMoveProbability()
     */
    public int getMoveProbability() 
    {
    	return moveProbability;
    }
    
    /**
     * Changes the orientation of the entity.
     * 
     * @param orientation The new orientation of the entity.
     * 
     * @post | this.getOrientation() == orientation
     */
    public void setOrientation(Orientation orientation) 
    {
    	this.orientation = orientation;
    }
    
    /**
     * Turns the entity clockwise by 90 degrees.
     * 
     * @post | this.getOrientation() == old(this.getOrientation()).turnClockwise(1)
     */
	public void turnClockwise()
	{
	    this.orientation = this.orientation.turnClockwise(1);
	}
	
	/**
	 * Turns the entity counterclockwise by 90 degrees.
	 * 
	 * @post | this.getOrientation() == old(this.getOrientation()).turnCounterclockwise(1)
	 */
	public void turnCounterclockwise()
	{
	    this.orientation = this.orientation.turnCounterclockwise(1);
	}

	/**
	 * Computes the position where the entity would arrive if it were to move one step
	 * forward in its current orientation. This does not take into account whether
	 * this position is free or not.
	 * 
	 * @return The new position after moving one step forward.
	 * 
	 * @post | result != null
	 * @post | result.getX() == this.getPosition().getX() + this.getOrientation().toVector().getX()
	 * @post | result.getY() == this.getPosition().getY() + this.getOrientation().toVector().getY()
	 */
	public Point destination()
	{
	    Point currentPosition = getPosition();
	    Orientation currentOrientation = getOrientation();
	    Vector movementVector = currentOrientation.toVector();
	    Point newPosition = new Point(currentPosition.getX() + movementVector.getX(), currentPosition.getY() + movementVector.getY());

	    return newPosition;
	}

    /**
     * The current position is set (if there is room) to current pos + current orientation.
     * Note: this method is not probabilistic
     * 
     * Moves the entity one step forward in its current orientation if the new position is free.
     * 
     * This method calculates the new position of the entity based on its current position and orientation.
     * If the new position is within the bounds of the world and is not occupied by another entity,
     * the entity moves to the new position. If the new position is occupied, the entity remains in its
     * current position.
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
     * 
     * This method uses RandomUtil.unfairBool to sample the moveProbability of the entity. If the sampled
     * result is true, indicating that the entity should move, the moveForward method is called to move
     * the entity one step forward in its current orientation.
     * 
     * @pre | getMoveProbability() >= 0 && getMoveProbability() <= 100     
     */
    public void moveForwardWithProbability()
    {
    	if (RandomUtil.unfairBool(moveProbability)) 
    	{
            moveForward();
        }
    }
    
    /**
     * Performs the action associated with the entity.
     */
    public abstract void performAction();

	/**
     * Returns the color of the entity.
     * 
     * @return The color of the entity.
     */
    public abstract Color getColor();
    
    /**
     * Checks whether this entity is a prey.
     * 
     * @return True if the entity is a prey, false otherwise.
     */
    public boolean isPrey()
    {
        return isPreyPkg();
    }
    
    /**
     * Checks whether this entity is a hunter.
     * 
     * @return True if the entity is a hunter, false otherwise.
     */
    public boolean isHunter()
    {
        return isHunterPkg();
    }
    
    /**
     * Checks whether this entity is a shelter.
     * 
     * @return True if the entity is a shelter, false otherwise.
     */
    public boolean isShelter()
    {
        return isShelterPkg();
    }
    
    /**
     * Hint: only flawed methods use this method (or its children).
     * In our implementation this method is never used.
     * 
     * @return A copy of the entity.
     */
    public abstract Entity giveCopy();
}
