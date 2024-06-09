package sim.neuralnet;

import sim.entities.Prey;
/**
 * @mutable
 */
public interface Neuron
{
	/**
	 * @pre | creature != null
	 */
    int computeOutput(Prey creature);
}
	