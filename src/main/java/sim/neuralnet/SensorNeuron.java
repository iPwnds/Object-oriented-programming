package sim.neuralnet;

import sim.entities.Prey;

/**
 * @immutable
 */
public abstract class SensorNeuron implements Neuron {

	@Override
	public abstract int computeOutput(Prey prey);
}
