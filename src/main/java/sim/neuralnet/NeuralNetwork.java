package sim.neuralnet;

import java.util.Arrays;

import sim.Chromosome;
import util.Orientation;

/**
 * Represents a neural network used for controlling creatures in the simulation.
 * The output neurons depend at least on all input neurons if they have dependencies.
 * All Neuron fields are freely accessible by the client.
 */
public class NeuralNetwork
{
    /** The input layer neurons of the neural network. */
    private final SensorNeuron[] inputLayerNeurons;

    /** The neuron responsible for moving forward. */
    private final ActivationFunctionNeuron moveForwardNeuron;

    /** The neuron responsible for turning clockwise. */
    private final ActivationFunctionNeuron turnClockwiseNeuron;

    /** The neuron responsible for turning counterclockwise. */
    private final ActivationFunctionNeuron turnCounterclockwiseNeuron;

    /**
     * Constructs a NeuralNetwork with 7 input neurons and 3 output neurons, as described in the assignment, with no connections.
     */
    public NeuralNetwork()
    {
        this.inputLayerNeurons = new SensorNeuron[] {
            new FreePassageSensorNeuron(Orientation.north()),
            new FreePassageSensorNeuron(Orientation.northWest()),
            new FreePassageSensorNeuron(Orientation.northEast()),
            new HorizontalOrientationSensorNeuron(),
            new VerticalOrientationSensorNeuron(),
            new HorizontalPositionSensorNeuron(),
            new VerticalPositionSensorNeuron()
        };
        this.moveForwardNeuron = new RectifiedLinearUnitFunctionNeuron();
        this.turnClockwiseNeuron = new LinearFunctionNeuron();
        this.turnCounterclockwiseNeuron = new LinearFunctionNeuron();
    }

    /**
     * Returns the input neurons of the neural network.
     * 
     * @return The array of input layer neurons.
     */
    public SensorNeuron[] getInputNeurons()
    {
        return inputLayerNeurons;
    }

    /**
     * Returns the output neurons of the neural network.
     * 
     * @return The array of output layer neurons.
     */
    public ActivationFunctionNeuron[] getOutputNeurons()
    {
        return new ActivationFunctionNeuron[] {
            moveForwardNeuron,
            turnCounterclockwiseNeuron,
            turnClockwiseNeuron
        };
    }

    /**
     * Returns the neuron responsible for moving forward.
     * 
     * @return The move forward neuron.
     */
    public ActivationFunctionNeuron getMoveForwardNeuron() {
        return this.moveForwardNeuron;
    }

    /**
     * Returns the neuron responsible for turning clockwise.
     * 
     * @return The turn clockwise neuron.
     */
    public ActivationFunctionNeuron getTurnClockwiseNeuron() {
        return this.turnClockwiseNeuron;
    }

    /**
     * Returns the neuron responsible for turning counterclockwise.
     * 
     * @return The turn counterclockwise neuron.
     */
    public ActivationFunctionNeuron getTurnCounterclockwiseNeuron() {
        return this.turnCounterclockwiseNeuron;
    }

    /**
     * Constructs a NeuralNetwork from the given chromosome by connecting neurons and setting biases.
     * 
     * @param chromosome The chromosome containing genetic information for the neural network.
     * @return The constructed NeuralNetwork.
     * @throws IllegalArgumentException if the chromosome is null.
     * @pre | chromosome != null
     * @post
     * - The first 7 genes of the chromosome are used as dependencies/weights of the moveForwardNeuron.
     * - The next 7 genes of the chromosome are used as dependencies/weights of the turnCounterclockwiseNeuron.
     * - The next 7 genes of the chromosome are used as dependencies/weights of the turnClockwiseNeuron.
     * - The 3 remaining genes are used as biases of the moveForwardNeuron, turnCounterclockwiseNeuron, and turnClockwiseNeuron.
     */
    public static NeuralNetwork fromChromosome(Chromosome chromosome) 
    {
        if (chromosome == null) {
            throw new IllegalArgumentException("Chromosome cannot be null");
        }

        SensorNeuron[] inputNeurons = new SensorNeuron[7];
        for (int i = 0; i < 7; i++) {
            inputNeurons[i] = new FreePassageSensorNeuron(Orientation.north()); 
        }

        ActivationFunctionNeuron moveForwardNeuron = new RectifiedLinearUnitFunctionNeuron();
        ActivationFunctionNeuron turnCounterclockwiseNeuron = new LinearFunctionNeuron();
        ActivationFunctionNeuron turnClockwiseNeuron = new LinearFunctionNeuron();

        for (int i = 0; i < 7; i++) {
            moveForwardNeuron.connect(inputNeurons[i], chromosome.getGene(i));
        }

        for (int i = 7; i < 14; i++) {
            turnCounterclockwiseNeuron.connect(inputNeurons[i - 7], chromosome.getGene(i));
        }

        for (int i = 14; i < 21; i++) {
            turnClockwiseNeuron.connect(inputNeurons[i - 14], chromosome.getGene(i));
        }

        moveForwardNeuron.setBias(chromosome.getGene(21));
        turnCounterclockwiseNeuron.setBias(chromosome.getGene(22));
        turnClockwiseNeuron.setBias(chromosome.getGene(23));

        NeuralNetwork neuralNetwork = new NeuralNetwork();
        
        return neuralNetwork;
    }
}
