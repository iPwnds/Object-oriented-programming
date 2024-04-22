package sim.neuralnet;

import sim.entities.Prey;

/**
 * @immutable
 */
public abstract class BinarySensorNeuron extends SensorNeuron
{
    @Override
    public int computeOutput(Prey prey)
    {
        return this.detect(prey) ? 750 : (-750);
    }

    public abstract boolean detect(Prey prey);
}
