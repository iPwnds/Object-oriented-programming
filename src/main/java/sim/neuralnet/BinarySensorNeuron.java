package sim.neuralnet;

import sim.entities.Prey;

/**
 * @immutable
 */
public abstract class BinarySensorNeuron extends SensorNeuron
{
	/**
	 * @pre | prey != null
	 * @post | result == (detect(prey) ? 750 : (-750))
	 */
    @Override
    public int computeOutput(Prey prey)
    {
        return this.detect(prey) ? 750 : (-750);
    }
    
    /**
     * @pre | prey != null
     */
    public abstract boolean detect(Prey prey);
}
