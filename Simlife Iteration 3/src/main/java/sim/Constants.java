package sim;

/**
 * @immutable LEGIT
 * 
 *            A class gathering constants
 */
public class Constants
{
    private Constants()
    {
    }

    static
    {
        SHELTER_COUNT = getEnvironmentVariable("SIMLIFE_SHELTER_COUNT", 3 * 2);
        INHABITANTS_PER_SHELTER = getEnvironmentVariable("SIMLIFE_INHABITANTS_PER_SHELTER", 5);
        HUNTERS_PER_SHELTER = getEnvironmentVariable("SIMLIFE_HUNTERS_PER_SHELTER", 1);
        WORLD_SIZE = getEnvironmentVariable("SIMLIFE_WORLD_SIZE", 100);
    }

    // DNA related
    public static int CHROM_SIZE = 12;
    public static int GENE_MIN = -1000;
    public static int GENE_MAX = 1000; // min and max should be different.
    public static int GENE_DELTA = 200; // typical "mutation" value. should be < (GENE_MAX - GENE_MIN)/2
    public static int MUT_RATE = 20; // Mutation rate. 0<= MUT_RATE <= 100

    // general purpose numbers
    public static int WORLD_SIZE; // length of side of (square) world

    public final static int DEFAULT_FRAME_RATE = 300;

    public final static int SHELTER_MOVE_PROBABILITY = 5;
    public final static int SHELTER_TURN_PROBABILITY = 10;
    public final static int PREY_MOVE_PROBABILITY = 100;
    public final static int HUNTER_MOVE_PROBABILITY = 50;

    public final static int SHELTER_COUNT;
    public final static int INHABITANTS_PER_SHELTER;
    public final static int HUNTERS_PER_SHELTER;

    public final static int SHELTER_SURVIVAL_DISTANCE = 15;
    public final static int HUNTER_INITIAL_APPETITE = 1;

    private static int getEnvironmentVariable(String name, int defaultValue)
    {
        var environmentVariables = System.getenv();

        if ( environmentVariables.containsKey(name) )
        {
            var value = environmentVariables.get(name);

            return Integer.parseInt(value);
        }
        else
        {
            return defaultValue;
        }
    }
}
