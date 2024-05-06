package sim.entities;

import util.Logic;
import util.Orientation;
import util.Point;

/**
 * A MortalEntity is an Entity that can die.
 * Upon death, the entity removes itself from the world.
 */
public abstract class MortalEntity extends Entity
{
    private boolean dead;
    
    /**
     * Initializes a new MortalEntity with the given parameters.
     *
     * @param world The world in which the entity exists.
     * @param position The initial position of the entity.
     * @param orientation The initial orientation of the entity.
     * @param moveProbability The move probability of the entity.
     * 
     * @pre | world != null
     * @pre | position != null
     * @pre | orientation != null
     * @pre | moveProbability >= 0 && moveProbability <= 100
     * 
     * @post | getWorld() == world
     * @post | getPosition() == position
     * @post | getOrientation() == orientation
     * @post | getMoveProbability() == moveProbability
     * @post | !isDead()
     */
    MortalEntity(World world, Point position, Orientation orientation, int moveProbability)
    {
        super(world, position, orientation, moveProbability);
        
        this.dead = false;
    }
    
    /**
     * Checks if the entity is alive.
     *
     * @return true if the entity is alive, false otherwise.
     * 
     * @post | result == !isDead()
     */
    @Override
	boolean isAlivePkg() 
    { 
    	return !dead; 
    }

    /**
     * Marks the entity as dead.
     * 
     * @post | isDead()
     */
	void diePkg() 
	{
	    this.dead = true;
	}

	/**
	 * LEGIT
	 */
	public void performAction()
    {
        if (!this.dead)
        {
            performActionIfAlive();
        }
    }
    
    /**
     * LEGIT
     */
    public void moveForward()
    {
        if (!this.dead)
        {
            super.moveForward();
        }
    }
    
    /**
     * Performs the action of the entity if it's alive.
     */
    public abstract void performActionIfAlive();
    
    /**
     * Checks if the entity is dead.
     *
     * @return true if the entity is dead, false otherwise.
     * 
     * @post | result == isDead()
     */
    public boolean isDead()
    {
        return dead;
    }
    
    /**
     * LEGIT
     */
    public void die()
    {
    	diePkg();
    }
}
