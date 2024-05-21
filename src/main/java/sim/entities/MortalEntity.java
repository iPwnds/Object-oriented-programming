package sim.entities;

//import util.Logic;
import util.Orientation;
import util.Point;

/**
 * A MortalEntity is an Entity that can die.
 * Upon death, the entity removes itself from the world.
 */
public abstract class MortalEntity extends Entity
{
	/**
     * Represents whether the entity is dead or alive.
     */
    private boolean dead;
    
    /**
     * Constructs a MortalEntity with the specified parameters.
     *
     * @param world The world in which the entity resides.
     * @param position The initial position of the entity.
     * @param orientation The initial orientation of the entity.
     * @param moveProbability The probability (0 to 100) that the entity moves at each step.
     *
     * @pre | 0 <= moveProbability && moveProbability <= 100
     * @post | getPosition().equals(position)
     * @post | getOrientation().equals(orientation)
     * @post | getMoveProbability() == moveProbability
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
     * @post | isDead() == true
     */
	void diePkg() 
	{
	    this.dead = true;
	}

	/**
     * Checks if the entity is dead.
     *
     * @return true if the entity is dead, false otherwise.
     *
     */
    public boolean isDead()
    {
        return dead;
    }
    
    /**
     * Performs an action specific to the entity if it's alive.
     * Subclasses must implement this method to define the entity's behavior when alive.
     */
    public abstract void performActionIfAlive();

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
     * LEGIT
     */
    public void die()
    {
    	diePkg();
    }
}
