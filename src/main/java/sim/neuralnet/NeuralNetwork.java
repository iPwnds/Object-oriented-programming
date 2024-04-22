package sim.neuralnet;

import java.util.Arrays;

import sim.Chromosome;
import util.Orientation;

/**
 * Neuron references are freely accesible by the client
 */
public class NeuralNetwork
{


    private final SensorNeuron[] inputLayerNeurons;


    private final ActivationFunctionNeuron moveForwardNeuron;
    
	private final ActivationFunctionNeuron turnNeuron;

	/**
	 * Neural network with
	 * - 5 input neurons (3 FreePassageSensorNeuron with respectively N, NW, NE as parameters;
	 *   1 HunterSenor neuron; 1 ShelterSensor)
	 * - 2 output neurons (2 LinearFunctionNeuron)
	 */
    public NeuralNetwork()
    {
    	inputLayerNeurons = null;
    	moveForwardNeuron = null;
    	turnNeuron = null;
    }

	public SensorNeuron[] getInputNeurons()
    {
		return null;
    }

    public ActivationFunctionNeuron[] getOutputNeurons()
    {
        return null;
    }

    public ActivationFunctionNeuron getMoveForwardNeuron() { return null; }

    public ActivationFunctionNeuron getTurnNeuron() { return null; }

    /**
     * LEGIT
     * @pre | chromosome != null
     * 
     */
    public static NeuralNetwork fromChromosome(Chromosome chromosome)
    {
        var neuralNetwork = new NeuralNetwork();
        var geneIndex = 0;
        
        for ( var outputNeuron : neuralNetwork.getOutputNeurons() )
        {
            for ( var inputNeuron : neuralNetwork.getInputNeurons() )
            {
                var weight = chromosome.getGene(geneIndex++);

                outputNeuron.connect(inputNeuron, weight);
            }
        }
        
        for (var outputNeuron : neuralNetwork.getOutputNeurons()) {
            var bias = chromosome.getGene(geneIndex++);
            outputNeuron.setBias(bias);        	
        }

        return neuralNetwork;
    }
}
