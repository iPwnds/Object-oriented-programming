package sim.neuralnet;

import sim.Creature;
import sim.World;
import util.Pair;

/**
 * Represents a neuron with a linear activation function.
 * The output of this neuron is the weighted sum of its dependencies, passed through a linear activation function.
 */
public class LinearFunctionNeuron extends ActivationFunctionNeuron {

    /**
     * Applies the linear activation function to the input.
     * 
     * @param input The input value to which the linear activation function is applied.
     * @return The output value after applying the linear activation function (same as the input).
     */
    @Override
    public int applyActivationFunction(int input) {
        return input; // Linear function returns the input as it is
    }

    /**
     * Computes the output of the linear function neuron based on its dependencies and their weights.
     * 
     * @param world The world in which the creature exists.
     * @param creature The creature whose state influences the neuron's output.
     * @return The output value of the neuron after applying the linear activation function to the weighted sum of its dependencies.
     * @pre | world != null
     * @pre | creature != null
     */
    @Override
    public int computeOutput(World world, Creature creature) {
        int sum = 0;
        for (Pair<Neuron, Integer> dependencyPair : getDependencies()) {
            Neuron dependency = dependencyPair.getFirst();
            int weight = dependencyPair.getSecond();
            int dependencyValue = dependency.computeOutput(world, creature);
            sum += weight * dependencyValue;
        }
        return applyActivationFunction(sum);
    }

    /**
     * Doubles the impact of a sensor neuron by adding an additional reference to it.
     * 
     * @param index The index of the dependency to be doubled.
     * @pre | 0 <= index
     * @pre | index < getDependencies().size()
     * @post | getDependencies().size() == old(getDependencies()).size() + 1
     */
    public void doubleSensor(int index) {
        var deps = getDependencies();
        var p = deps.get(index);
        deps.add(p);
        setDependencies(deps);
    }
}
