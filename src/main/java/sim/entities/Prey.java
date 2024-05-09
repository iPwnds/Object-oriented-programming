package sim.entities;

import java.util.ArrayList;
import sim.Chromosome;
import sim.Constants;
import sim.neuralnet.NeuralNetwork;
import util.Color;
import util.Logic;
import util.Orientation;
import util.Point;
import util.Vector;
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
	 * @peerObjects
	 * @representationObject
	 */
    final ArrayList<Prey> siblings;

    /**
     * @peerObject
     */
    Shelter shelter;

    private void performTurn() 
    {
        int turnOutput = neuralNetwork.getTurnNeuron().fire(neuralNetwork.getInputNeurons());

        Orientation currentOrientation = getOrientation();
        int clockwiseTurns = turnOutput % 4;
        
        for (int i = 0; i < clockwiseTurns; i++) 
        {
            currentOrientation = currentOrientation.turnClockwise(1);
        }

        setOrientation(currentOrientation);
    }

    private void performMove() {
        int moveOutput = neuralNetwork.getMoveForwardNeuron().fire(neuralNetwork.getInputNeurons());
        
        Vector direction = getOrientation().toVector().scaleWith(moveOutput);

        Point newPosition = getPosition().move(direction);

        if (world.isFree(newPosition)) 
        {
            setPosition(newPosition);
        }
    }

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
        
        shelter.addInhabitant(this);

        this.siblings.add(this);
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
		world.removeEntityAt(getPosition());
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
    
    public boolean survives()
    {
    	return distanceSquaredToShelter() > Constants.SHELTER_SURVIVAL_DISTANCE * Constants.SHELTER_SURVIVAL_DISTANCE;
    }

    public int distanceSquaredToShelter()
    {
    	Point shelterPosition = shelter.getPosition();
        return getPosition().distanceSquared(shelterPosition);
    }

    @Override
    public String toString()
    {
        return String.format("Prey(position=%s)", this.getPosition());
    }
    
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
    
    @Override
    /**
     * LEGIT
     */
    public Prey giveCopy() 
    {
    	return new Prey(super.world, shelter, chromosome, getPosition(), getOrientation());
    }
}
