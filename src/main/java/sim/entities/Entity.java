package sim.entities;

import util.Color;
import util.Orientation;
import util.Point;
import util.RandomUtil;

/**
 * Supertype for all entities.
 * 
 * An entity resides in a world, has a position, an orientation and a move probability.
 * @mutable
 * @invar | 0 <= getMoveProbability() && getMoveProbability() <= 100
 * @invar | getPosition() != null
 * @invar | getOrientation() != null
 * @invar | getWorld() != null
 */
public abstract class Entity
{
	/**
	 * @invar | position != null
	 */
    private Point position;
    /**
     * @invar | orientation != null
     */
    private Orientation orientation;
    
    /**
     * @invar | 0 <= moveProbability && moveProbability <= 100
     */
    private final int moveProbability;

    /**
	 * @peerObject
	 * @invar | world != null
	 */
	World world;

	/**
     * Constructs an entity with the specified world, position, orientation, and move probability.
     * 
     * @param world The world in which the entity resides.
     * @param position The initial position of the entity.
     * @param orientation The initial orientation of the entity.
     * @param moveProbability The probability (0 to 100) that the entity moves at each step.
     * 
     * @throws IllegalArgumentException | 0 >= moveProbability && moveProbability <= 100
     * @throws IllegalArgumentException | world == null 
     * @throws IllegalArgumentException | position == null
     * @throws IllegalArgumentException | orientation == null
     * 
     * @post | getPosition().equals(position)
     * @post | getOrientation().equals(orientation)
     * @post | getMoveProbability() == moveProbability
     */
	Entity(World world, Point position, Orientation orientation, int moveProbability) 
	{
		if(0 >= moveProbability && moveProbability <= 100) {
			throw new IllegalArgumentException(); 
		}
		if(world == null) {
			throw new IllegalArgumentException(); 
		}
		if(position == null) {
			throw new IllegalArgumentException(); 
		}
		if(orientation == null) {
			throw new IllegalArgumentException(); 
		}
        this.world = world;
        this.position = position;
        this.orientation = orientation;
        this.moveProbability = moveProbability;
    }
    
	/**
     * Returns true if the entity is alive.
     * 
     * @return true if the entity is alive, false otherwise.
     */
    boolean isAlivePkg() 
    { 
    	return true; 
    }

	/**
     * Returns the world which this entity inhabits.
     * 
     * @return The world object.
     * 
     */
    public World getWorld()
    {    	
    	return world;
    }
    
    /**
     * Current position of this entity in the world.
     * 
     * @return The current position as a Point object.
     * 
     */
    public Point getPosition() 
    {
    	return position;
    }
    
    /**
     * Current orientation of this entity.
     * 
     * @return The current orientation as an Orientation object.
     * 
     */
    public Orientation getOrientation() 
    {
    	return orientation;
    }

    /**
     * Probability (integer between 0 and 100) that the entity moves at each step.
     * 
     * @return The move probability (0 to 100).
     */
    public int getMoveProbability() 
    {
    	return moveProbability;
    }
    
    /**
     * Changes the orientation of the entity.
     * 
     * @param orientation The new orientation for the entity.
     * 
     * @post | getOrientation().equals(orientation)
     */
    public void setOrientation(Orientation orientation) 
    {
    	this.orientation = orientation;
    }
    
    /**
     * Turns the entity clockwise by 90 degrees.
     * 
     * @post | getOrientation().equals(old(getOrientation()).turnClockwise(1))
     */
	public void turnClockwise()
	{
	    this.orientation = this.orientation.turnClockwise(1);
	}

	/**
     * Turns the entity counterclockwise by 90 degrees.
     * 
     * @post | getOrientation().equals(old(getOrientation()).turnCounterclockwise(1))
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
     * @return The destination position as a Point object.
     * 
     * @post | result != null

     */
    public Point destination()
    {
        return position.move(orientation.toVector());
    }
    
    /**
     * The current position is set (if there is room) to current pos + current orientation.
     * Note: this method is not probabilistic
     * 
     */
    public void moveForward()
    {
        Point newPosition = destination();
        Point oldPosition = getPosition();
    	if(world.isFree(newPosition) && world.isInside(newPosition)) {
    		this.setPosition(newPosition);
    		world.removeEntityAt(oldPosition);
    	}
    }
    
    /**
     * Samples using moveProbability and attempts to move if the latter result is true
     * See RandomUtil.unfairBool
     * 
     * @post the entity moves forward with a probability of this.moveProbability
     */
    public void moveForwardWithProbability()
    {
    	if (RandomUtil.unfairBool(moveProbability)) 
    	{
            moveForward();
        }
    }
    
    /**
     * Checks whether this entity is a prey.
     * 
     * @return true if the entity is a prey, false otherwise.
     * 
     */
    public boolean isPrey()
    {
        return isPreyPkg();
    }
    
    /**
     * Checks whether this entity is a hunter.
     * 
     * @return true if the entity is a hunter, false otherwise.
     * 
     */
    public boolean isHunter()
    {
        return isHunterPkg();
    }
    
    /**
     * Checks whether this entity is a shelter.
     * 
     * @return true if the entity is a shelter, false otherwise.
     * 
     */
    public boolean isShelter()
    {
        return isShelterPkg();
    }
    
    /**
     * Checks whether the entity is a hunter.
     * 
     * @return true if the entity is a hunter, false otherwise.
     */
	abstract boolean isHunterPkg();

	/**
     * Checks whether the entity is a prey.
     * 
     * @return true if the entity is a prey, false otherwise.
     */
	abstract boolean isPreyPkg();

	/**
     * Checks whether the entity is a shelter.
     * 
     * @return true if the entity is a shelter, false otherwise.
     */
	abstract boolean isShelterPkg();
    
    /**
     * Performs an action specific to the entity.
     */
    public abstract void performAction();

	/**
     * Returns the color of the entity.
     * 
     * @return The color of the entity as a Color object.
     * 
     * @post | result != null
     */
    public abstract Color getColor();
    
    /**
     * Hint: only flawed methods use this method (or its children).
     * In our implementation this method is never used.
     * 
     * @return A copy of the entity as an Entity object.
     * 
     * @post | result != null
     */
    public abstract Entity giveCopy();
    
    /**
	 * LEGIT
	 */
	Point getPositionPkg() 
	{
		return position;
	}
	
	/**
	 * Sets the position of the prey to the specified new position.
	 * 
	 * @param newPosition The new position to set for the prey.
	 * 
	 * @throws NullPointerException if newPosition is null.
	 * 
	 * @pre | newPosition != null
	 * @post | this.getPosition().equals(newPosition)
	 */
	public void setPosition(Point newPosition) 
	{
	    this.position = newPosition;
	    world.entityGrid.setAt(newPosition, this);
	}
}
