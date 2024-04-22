package sim.entities;

import java.util.ArrayList;

import sim.Constants;
import util.Color;
import util.Logic;
import util.Orientation;
import util.Point;
import util.RandomUtil;

public class Hunter extends Entity
{
	private int appetite;

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
	 * 
	 * @peerObject
	 */
	final Shelter shelter;
	


	
	
	Hunter(World world, Shelter shelter, Point position, Orientation orientation)
	{
		super(world, position, orientation, Constants.HUNTER_MOVE_PROBABILITY);
		this.shelter = shelter;
		this.appetite = Constants.HUNTER_INITIAL_APPETITE;
	}

	@Override
	boolean isPreyPkg()
	{
		return false;
	}

	@Override
	boolean isHunterPkg()
	{
		return true;
	}

	@Override
	boolean isShelterPkg()
	{
		return false;
	}

	@Override
	public Color getColor()
	{
		return null;
	}

	@Override
	public String toString()
	{
		return String.format("Hunter(position=%s)", this.getPosition());
	}

	@Override
	public void performAction()
	{
		
		//		//to face the found prey
		//		var targetDirection = this.getPosition().vectorTo(target.getPosition()); 
		//		var newOrientation = Orientation.fromVector(targetDirection);
		//		setOrientation(newOrientation);
		//		
		//		
		//		//if one is 100% sure that thing is a Prey one may use subcasting
		//		var prey = (Prey) thing;

	}
	
	@Override
	/**
	 * LEGIT
	 */
	public Hunter giveCopy() {
		return new Hunter(super.world, shelter, getPosition(), getOrientation());
	}
}
