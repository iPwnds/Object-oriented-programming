package sim.neuralnet;

import java.util.ArrayList;

import sim.entities.Prey;
import util.Pair;


public abstract class ActivationFunctionNeuron implements Neuron
{

	/**
	 * Can be any >= 0 size
	 * 
	 * @representationObject
	 * @representationObjects
	 * @invar | dependencies != null
	 * @invar | dependencies.stream().allMatch(p -> p != null)
	 * @invar | dependencies.size() >= 0
	 */
    private ArrayList<Pair<Neuron, Integer>> dependencies;

    private int bias;
    
    /**
     * The Neuron references are freely accessible by the client
     * 
     * @creates | result
     * @post | result != null
     * @post | result.stream().allMatch(p -> p != null)
     */
    public ArrayList<Pair<Neuron, Integer>> getDependencies() {
    	ArrayList<Pair<Neuron, Integer>> res = new ArrayList<Pair<Neuron, Integer>>();
    	for (Pair<Neuron, Integer> p : dependencies) {
    		Pair<Neuron, Integer> aux = new Pair<Neuron, Integer>(p.getFirst(), p .getSecond());
    		res.add(aux);
    	}
    	return res;
    }
    
    /**
     * pre: deps has correct length
     * The Neuron references are stored as is.
     * 
     * @mutates | this
     * @inspects | deps
     * @pre | deps != null 
     * @pre | deps.stream().allMatch(p -> p != null)
     * @pre | deps.size() <= 7
     * @post | getDependencies().size() == deps.size()
     * @mutates_properties | getDependencies()
     */
    public void setDependencies(ArrayList<Pair<Neuron, Integer>> deps) {
    	ArrayList<Pair<Neuron, Integer>> res = new ArrayList<Pair<Neuron, Integer>>();
    	for (Pair<Neuron, Integer> p : deps) {
    		res.add(new Pair<Neuron, Integer>(p.getFirst() , p.getSecond()));
    	}
    	dependencies = res;
    }

    /**
     * Initializes with getBias = 0 and getDependencies is empty
     * @post | getBias() == 0
     * @post | getDependencies().size() == 0
     */
    public ActivationFunctionNeuron()
    {
        this.dependencies = new ArrayList<>();
        bias = 0;
    }

    /**
     * 
     * @mutates | this 
     * @pre | dependency != null
 //   * @post | ((old(dependencies.size()) == 7) && (old(dependecies) == dependencies)) || (old(dependecies) == dependencies + 1)
     */
    public boolean connect(Neuron dependency, int weight)
    {
    	if (dependencies.size() == 7)
    	{
    		return false;
		}
    	else
    	{
            var pair = new Pair<Neuron, Integer>(dependency, weight);
            dependencies.add(pair);
            return true;
    	}
    }
    /**
     * @post | getBias() == bias
     */
    public void setBias(int bias)
    {
        this.bias = bias;
    }
    
    public int getBias() {
    	return bias;
    }

    @Override
    /**
     * LEGIT
     */
    public int computeOutput(Prey prey)
    {
        var total = this.bias;

        for ( var pair : this.dependencies )
        {
            var dependency = pair.getFirst();
            var weight = pair.getSecond();

            total += dependency.computeOutput(prey) * weight / 1000;
        }

        return applyActivationFunction(total);
    }

    public abstract int applyActivationFunction(int input);
    
    public int fire(SensorNeuron[] inputNeurons) {
        int total = bias;
        for (Pair<Neuron, Integer> pair : dependencies) {
            Neuron dependency = pair.getFirst();
            int weight = pair.getSecond();
            total += dependency.computeOutput(null) * weight;
        }
        return applyActivationFunction(total);
    }
}
