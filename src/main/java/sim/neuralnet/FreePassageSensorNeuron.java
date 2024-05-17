package sim.neuralnet;

import sim.entities.Prey;
import util.Orientation;

/**
 * @immutable
 * @invar | getOrientation() != null
 */
public class FreePassageSensorNeuron extends BinarySensorNeuron
{
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * @invar | orientation != null
	 */
    private final Orientation orientation;
    
    /**
     * @throws IllegalArgumentException | orientation == null 
     */
    public FreePassageSensorNeuron(Orientation orientation)
    {
    	if (orientation == null) { throw new IllegalArgumentException(); }
        this.orientation = orientation;
    }
    
    @Override
    /**
     * LEGIT
     */
    public boolean detect(Prey prey)
    {
    	var world = prey.getWorld();
    	var detectionOrientation = prey.getOrientation().compose(this.orientation);
        var position = prey.getPosition();
        var targetPosition = position.move(detectionOrientation.toVector());

        return world.isFree(targetPosition);
    }
}
