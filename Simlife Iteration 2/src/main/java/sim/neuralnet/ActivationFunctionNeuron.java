package sim.neuralnet;

import util.Pair;

import java.util.ArrayList;

import sim.Creature;
import sim.World;

/**
 * Represents a neuron with an activation function that computes its output based on inputs from other neurons.
 * The neuron's dependencies and bias can be freely accessed and modified by the client.
 */
public abstract class ActivationFunctionNeuron implements Neuron {

    /** The list of neuron dependencies along with their respective weights. */
    private ArrayList<Pair<Neuron, Integer>> dependencies;

    /** The bias value of the neuron. */
    private int bias;

    /**
     * Retrieves the list of neuron dependencies.
     * 
     * @return The list of neuron dependencies.
     */
    public ArrayList<Pair<Neuron, Integer>> getDependencies() {
    	return dependencies;
    }

    /**
     * Sets the list of neuron dependencies.
     * 
     * @param deps The list of neuron dependencies to be set.
     * @pre | deps != null
     * @pre | deps.size() <= 7
     */
    public void setDependencies(ArrayList<Pair<Neuron, Integer>> deps) {
    	dependencies = deps;
    }

    /**
     * Initializes the neuron with an empty list of dependencies and bias set to 0.
     */
    public ActivationFunctionNeuron() {
        this.dependencies = new ArrayList<>();
        bias = 0;
    }

    /**
     * Connects a neuron dependency with a given weight.
     * 
     * @param dependency The neuron dependency to be connected.
     * @param weight The weight of the connection.
     * @return true if the connection is successful, false otherwise.
     * @pre | dependency != null
     */
    public boolean connect(Neuron dependency, int weight) {
    	if (dependencies.size() == 7) {
    		dependencies.remove(6);
    		dependencies.add(new Pair<>(dependency, weight));
    		return true;
    	}
    	var p = new Pair<>(dependency, weight);
    	dependencies.add(p);
    	return true;
    }

    /**
     * Sets the bias value of the neuron.
     * 
     * @param bias The bias value to be set.
     */
    public void setBias(int bias) {
        this.bias = bias;
    }
    
    /**
     * Retrieves the bias value of the neuron.
     * 
     * @return The bias value of the neuron.
     */
    public int getBias() {
    	return bias;
    }

    /**
     * Computes the output of the neuron based on the inputs from the world and creature.
     * This method is overridden by subclasses to implement specific activation functions.
     * 
     * @param world The world in which the creature exists.
     * @param creature The creature whose state influences the neuron's output.
     * @return The output value of the neuron.
     */
    @Override
    public int computeOutput(World world, Creature creature) {
    	return 0;
    }

    /**
     * Applies the activation function to the given input.
     * 
     * @param input The input value to which the activation function is applied.
     * @return The output value after applying the activation function.
     */
    public abstract int applyActivationFunction(int input);
}