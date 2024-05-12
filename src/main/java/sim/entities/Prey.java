package sim.entities;

import java.util.ArrayList;
import sim.Chromosome;
import sim.Constants;
import sim.neuralnet.NeuralNetwork;
import util.Color;
//import util.Logic;
import util.Orientation;
import util.Point;
import util.Vector;
//import static util.Logic.*;

/**
 * Prey class represents an entity in the simulation that exhibits prey-like behavior.
 * It extends the MortalEntity class.
 */ 
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
	 * @invar | siblings != null
	 * @invar | siblings.stream().allMatch(s -> s != null && s.getSiblings().contains(this))
	 */
    final ArrayList<Prey> siblings;

    /**
     * @peerObject
     * @invar | shelter != null
     * @invar | shelter.getInhabitants().contains(this)
     */
    Shelter shelter;
    
    /**
     * zelf toegevoegde method
     * 
     * Should not be representation exposure,
     * because object is a primitive int type
     * 
     * @return The score of the prey.
     */
    public int getScore() {
    	return this.score;
    }

    /**
     * Performs a turn based on the output of the turn neuron.
     * 
     * @pre | neuralNetwork != null
     * @post The prey turns its orientation based on the output of the neural network
     */
    private void performTurn() 
    {
        int turnOutput = neuralNetwork.getTurnNeuron().fire(neuralNetwork.getInputNeurons(), this);

        Orientation currentOrientation = getOrientation();
        int clockwiseTurns = turnOutput % 4;
        
        for (int i = 0; i < clockwiseTurns; i++) 
        {
            currentOrientation = currentOrientation.turnClockwise(1);
        }

        setOrientation(currentOrientation);
    }

    /**
     * Moves the prey forward based on the output of the neural network.
     * 
     * @pre | neuralNetwork != null
     * @post The prey moves forward if the new position is free
     */
    private void performMove() {
        int moveOutput = neuralNetwork.getMoveForwardNeuron().fire(neuralNetwork.getInputNeurons(), this);
        
        Vector direction = getOrientation().toVector().scaleWith(moveOutput);

        Point newPosition = getPosition().move(direction);

        if (world.isFree(newPosition)) 
        {
            setPosition(newPosition);
        }
    }

    /**
     * Determines whether this entity is of the prey type.
     * 
     * @return true if this entity is a prey, false otherwise.
     * 
     * @post | result == true
     */
    @Override
	boolean isPreyPkg()
	{
	    return true;
	}

    /**
     * Creates a Prey object with the specified parameters.
     * 
     * @param world The world in which the prey exists.
     * @param shelter The shelter where the prey resides.
     * @param chromosome The chromosome of the prey.
     * @param position The initial position of the prey.
     * @param orientation The initial orientation of the prey.
     * 
     * @throws IllegalArgumentException if any of the parameters are null.
     * 
     * @pre | chromosome != null
     * @pre | world != null
     * @pre | shelter != null
     * @pre | position != null
     * @pre | orientation != null
     * 
     * @post | this.getPosition().equals(position)
     * @post | this.getOrientation().equals(orientation)
     * @post | this.getChromosome().equals(chromosome)
     * @post | this.getNeuralNetwork() != null
     * @post | this.getSiblings().contains(this) && shelter.getInhabitants().contains(this)
     */
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

	/**
	 * Determines whether this entity is of the hunter type.
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
     * Determines whether this entity is of the shelter type.
     * 
     * @return false since this entity is not a shelter.
     * 
     * @post | result == false
     */
	@Override
	boolean isShelterPkg()
	{
	    return false;
	}

	/**
	 * Removes the entity from the world upon its death.
	 * 
	 * @post The entity is removed from the world at its current position.
	 */
	@Override
	void diePkg()
	{
		world.removeEntityAt(getPosition());
	}

	/**
	 * Retrieves the chromosome associated with this prey entity.
	 * 
	 * @return The chromosome of this prey entity.
	 * 
	 * @post | result != null
	 */
	public Chromosome getChromosome()
    {
        return this.chromosome;
    }

	/**
	 * Retrieves the color associated with this prey entity.
	 * 
	 * @return The color of this prey entity (GREEN).
	 * 
	 * @post | result != null
	 */
    public Color getColor()
    {
        return Color.GREEN;
    }
    
    /**
     * Retrieves the shelter associated with this prey entity.
     * 
     * @return The shelter where this prey entity resides.
     * 
     * @post | result != null
     */
    public Shelter getShelter()
    {
    	return this.shelter;
    }

    /**
     * Performs actions for the prey if it is alive. 
     * This includes turning, moving, and updating its score.
     * 
     * @post The prey performs a turn, moves, and updates its score if it is alive.
     */
    @Override
    public void performActionIfAlive()
    {
        performTurn();
        performMove();
        updateScore();
    }
    
    /**
     * Checks if the prey survives based on its distance to the shelter.
     * 
     * @return true if the prey survives, false otherwise.
     * 
     * @post | result == (getScore() > 0)
     */
    public boolean survives()
    {
    	return (getScore() > 0);
    }

    /**
     * Calculates the squared distance between the prey and the shelter.
     * 
     * @return The squared distance to the shelter.
     * 
     * @post | result == getPosition().distanceSquared(getShelter().getPosition())
     */
    public int distanceSquaredToShelter()
    {
    	Point shelterPosition = shelter.getPosition();
        return getPosition().distanceSquared(shelterPosition);
    }

    /**
     * Returns a string representation of this prey entity, including its position.
     * 
     * @return A string containing the position of this prey entity.
     * 
     * @post | result != null
     */
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

    /**
     * Gets the neural network associated with this prey.
     * Used for documentation ONLY
     * 
     * Should not have representation exposure
     * because object is being cloned & fields are final
     * 
     * @return The neural network of this prey.
     * @post | result != null
     */
    public NeuralNetwork getNeuralNetwork() 
    {
    	return this.neuralNetwork;
    }

    /**
     * Gets the list of siblings of this prey.
     * Used for documentation ONLY
     * 
     * Should not have representation exposure
     * because object is being cloned & fields are final
     * 
     * @return The list of siblings.
     * @post | result != null
     */
    public ArrayList<Prey> getSiblings() 
    {
        return new ArrayList<Prey> (this.siblings);
    }
}
