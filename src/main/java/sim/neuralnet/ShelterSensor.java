package sim.neuralnet;

import sim.entities.Prey;
/**
 * @mutable
 */
public class ShelterSensor extends BinarySensorNeuron
{
	/**
	 * @pre | prey != null	
	 * @post | result == (prey.getOrientation() == prey.getPosition().vectorTo(prey.getShelter().getPosition()).toClosestOrientation())
	 */
	@Override
	public boolean detect(Prey prey)
	{
		var shelterPosition = prey.getShelter().getPosition();
		var preyPosition = prey.getPosition();
		var orientation = preyPosition.vectorTo(shelterPosition).toClosestOrientation();
		
		return orientation == prey.getOrientation();
	}
}
