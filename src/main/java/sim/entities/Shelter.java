package sim.entities;

import java.util.ArrayList;
import sim.Constants;
import util.Color;
import util.Orientation;
import util.Point;
import util.RandomUtil;
import util.Vector;

/**
 * The Shelter class represents a shelter in the simulation, acting as a home for preys.
 * It extends the MortalEntity class.
 */
public class Shelter extends MortalEntity
{
    /**
     * The list of preys inhabiting the shelter.
     * 
	 * @peerObjects
	 * @representationObject
	 * @invar | inhabitants != null
	 * @invar | inhabitants.stream().allMatch(s -> s != null && s.shelter == this)
	 * @invar | inhabitants.size() <= Constants.INHABITANTS_PER_SHELTER*2

     */
    final ArrayList<Prey> inhabitants;

    /**
     * Creates a new Shelter object with the specified parameters.
     * 
     * @param world The world in which the shelter exists.
     * @param position The initial position of the shelter.
     * @param orientation The initial orientation of the shelter.
     * 
     * @throws IllegalArgumentException if any of the parameters are null.
     * 
     * @pre | world != null
     * @pre | position != null
     * @pre | orientation != null
     * 
     * @post | this.getWorld() == world
     * @post | this.getPosition().equals(position)
     * @post | this.getOrientation().equals(orientation)
     * @post | this.getMoveProbability() == Constants.SHELTER_MOVE_PROBABILITY
     * @post | this.getInhabitants() != null && this.getInhabitants().isEmpty()
     */
    Shelter(World world, Point position, Orientation orientation)
    {
        super(world, position, orientation, Constants.SHELTER_MOVE_PROBABILITY);
        this.inhabitants = new ArrayList<>();
    }

    /**
     * Checks whether this entity is of the prey type.
     * 
     * @return false since this entity is not a prey.
     * 
     * @post | result == false
     */
    @Override
	boolean isPreyPkg()
	{
	    return false;
	}

    /**
     * Checks whether this entity is of the shelter type.
     * 
     * @return true since this entity is a shelter.
     * 
     * @post | result == true
     */
	@Override
	boolean isShelterPkg()
	{
	    return true;
	}

	/**
     * Checks whether this entity is of the hunter type.
     * 
     * @return false since this entity is not a hunter.
     * 
     * @post | result == false
     */
	@Override
	boolean isHunterPkg()
	{
	    return false;
	}

	/**
     * Retrieves the list of inhabitants of this shelter.
     * 
     * @return The list of inhabitants.
     * 
     * @post | result != null
     * @post | result.size() <= Constants.INHABITANTS_PER_SHELTER*2
     */
	public ArrayList<Prey> getInhabitants()
    {
        return inhabitants;
    }

	/**
     * Performs actions for the shelter if it is alive. 
     * This includes turning and moving.
     * 
     * @post If the shelter is alive, it may change its orientation and/or position.
     */
    @Override
    public void performActionIfAlive()
    {
    	if(getInhabitants().stream().allMatch(s -> s.isDead())){
    		this.die();
    	}
    		
    		
    	if (!isDead()) 
    	{
            if (RandomUtil.unfairBool(Constants.SHELTER_TURN_PROBABILITY)) 
            {
                if (RandomUtil.bool()) 
                
                    turnClockwise();
                } 
                else 
                {
                    turnCounterclockwise();
                }
            
            
            if (RandomUtil.unfairBool(Constants.SHELTER_MOVE_PROBABILITY)) 
            {
            	this.moveForward();            }
    	}
        }
    

    /**
     * Retrieves the color associated with this shelter entity.
     * 
     * @return The color of this shelter entity (BLACK).
     * 
     * @post | result != null
     */
    @Override
    public Color getColor()
    {
    	return Color.BLACK;
    }

    /**
     * Returns a string representation of this shelter entity, including its position.
     * 
     * @return A string containing the position of this shelter entity.
     * 
     * @post | result != null
     */
    @Override
    public String toString()
    {
        return String.format("Shelter(position=%s)", this.getPosition());
    }
    
    @Override
    /**
     * LEGIT
     */
    public Shelter giveCopy() 
    {
    	return new Shelter(super.world, getPosition(), getOrientation());
    }
    
    /**
     * Adds the specified prey to the list of inhabitants in the shelter.
     * 
     * @param prey The prey to add to the list of inhabitants.
     * 
     * @post | this.getInhabitants().contains(prey)
     */
    public void addInhabitant(Prey prey) 
    {
        inhabitants.add(prey);
    }
}
