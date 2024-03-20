package sim.neuralnet;

/**
 * @immutable
 */
public class VerticalOrientationSensorNeuron extends OrientationSensorNeuron
{
    @Override
    protected int north()
    {
        return 0;
    }

    @Override
    protected int northEast()
    {
        return 0;
    }

    @Override
    protected int east()
    {
        return 0;
    }

    @Override
    protected int southEast()
    {
        return 0;
    }

    @Override
    protected int south()
    {
        return 0;
    }

    @Override
    protected int southWest()
    {
        return 0;
    }

    @Override
    protected int west()
    {
        return 0;
    }

    @Override
    protected int northWest()
    {
        return 0;
    }
}
