package sim.neuralnet;

import sim.entities.Prey;
/**
 * @mutable
 */
public class HunterSensor extends BinarySensorNeuron {
	
	/**
	 * @pre | prey != null
	 * @post | result == prey.getWorld().hasHunterInCone(prey.getPosition(), prey.getOrientation())
	 */
	@Override
	public boolean detect(Prey prey) {
        return prey.getWorld().hasHunterInCone(prey.getPosition(), prey.getOrientation());
	}
}
