package sim.entities;

import java.util.ArrayList;

import sim.Chromosome;
import sim.Constants;
import sim.neuralnet.NeuralNetwork;
import util.Color;
import util.Logic;
import util.Orientation;
import util.Point;
import static util.Logic.*;


public class Prey extends MortalEntity
{
	

	private final Chromosome chromosome;

	/**
	 * @representationObject
	 * @invar | neuralNetwork != null
	 */
	private final NeuralNetwork neuralNetwork;

	private int score;

	/**
	 * LEGIT
	 */
	private void updateScore()
	{
		if ( distanceSquaredToShelter() < Constants.SHELTER_SURVIVAL_DISTANCE * Constants.SHELTER_SURVIVAL_DISTANCE )
		{
			score += 1;
		}
		else
		{
			score -= 1;
		}
	}

	private void performTurn()
	{

	}

	private void performMove()
	{

	}
	


	/**
	 * @peerObjects
	 * @representationObject
	 */
    final ArrayList<Prey> siblings;

    /**
     * @peerObject
     */
    Shelter shelter;
    

    

    

    @Override
	boolean isPreyPkg()
	{
	    return true;
	}

	Prey(World world, Shelter shelter, Chromosome chromosome, Point position, Orientation orientation)
    {
        super(world, position, orientation, Constants.PREY_MOVE_PROBABILITY);


        if ( chromosome == null || world == null || shelter == null || position == null
        		|| orientation == null )
        {
            throw new IllegalArgumentException();
        }
        
        this.shelter = shelter;
        this.chromosome = chromosome;
        this.neuralNetwork = NeuralNetwork.fromChromosome(chromosome);
        this.siblings = this.shelter.getInhabitants();
        this.score = 0;

        //todo: link with siblings and shelter
    }

    @Override
	boolean isHunterPkg()
	{
	    return false;
	}

	@Override
	boolean isShelterPkg()
	{
	    return false;
	}

	@Override
	void diePkg()
	{

	}

	public Chromosome getChromosome()
    {
        return this.chromosome;
    }

    public Color getColor()
    {
        return Color.GREEN;
    }
    
    public Shelter getShelter()
    {
    	return this.shelter;
    }


    @Override
    public void performActionIfAlive()
    {
        performTurn();
        performMove();
        updateScore();
    }
    
    /**
     * LEGIT
     * 
     * true iff same position and orient and chromosome and behavior type The
     * getClass method can be used to retrieve the runtime type of an object.
     * 
     * @inspects | other
     */
    public boolean isEqual(Prey other)
    {
        return (other != null) && (this.getPosition().equals(other.getPosition()))
                && (this.getOrientation().isEqual(other.getOrientation()))
                && (this.getChromosome().isEqual(other.getChromosome()));
    }


    public boolean survives()
    {
    	return false;
    }

    public int distanceSquaredToShelter()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return String.format("Prey(position=%s)", this.getPosition());
    }
    
    @Override
    /**
     * LEGIT
     */
    public Prey giveCopy() {
    	return new Prey(super.world, shelter, chromosome, getPosition(), getOrientation());
    }
}
