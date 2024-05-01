package sim.neuralnet;

import sim.entities.Prey;

public interface Neuron
{
	/**
	 * @pre | creature != null
	 */
    int computeOutput(Prey creature);
}
