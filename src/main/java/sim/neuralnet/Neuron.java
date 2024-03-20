package sim.neuralnet;

import sim.Creature;
import sim.World;

public interface Neuron
{
    int computeOutput(World world, Creature creature);
}
