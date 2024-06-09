package sim.neuralnet;
/**
 * @mutable
 */
public class LinearFunctionNeuron extends ActivationFunctionNeuron
{
    @Override
    /**
     * LEGIT
     */
    public int applyActivationFunction(int input)
    {
        return Math.min(Math.max(-1000, input), 1000);
    }
}
