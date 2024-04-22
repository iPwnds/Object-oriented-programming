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
    
    

    MortalEntity(World world, Point position, Orientation orientation, int moveProbability)
    {
        super(world, position, orientation, moveProbability);
        
        this.dead = false;
    }
    
    @Override
	boolean isAlivePkg() { return !dead; }

	void diePkg() {
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
    
    public abstract void performActionIfAlive();
    
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
