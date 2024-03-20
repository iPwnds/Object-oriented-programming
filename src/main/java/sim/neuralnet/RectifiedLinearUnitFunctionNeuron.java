package sim.neuralnet;

/**
 * LEGIT
 */
public class RectifiedLinearUnitFunctionNeuron extends ActivationFunctionNeuron
{
    @Override
    protected int applyActivationFunction(int input)
    {
        return Math.min(Math.max(-500, input), 1000);
    }
}
