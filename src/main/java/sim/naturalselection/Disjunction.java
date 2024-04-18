package sim.naturalselection;

import sim.World;
import util.Point;

/**
 * Represents a natural selection rule where organisms survive if they are in either of two disjoint areas defined by separate natural selection rules.
 */
public class Disjunction implements NaturalSelection {

    /** The first area of natural selection. */
    private final NaturalSelection area1;

    /** The second area of natural selection. */
    private final NaturalSelection area2;

    /**
     * Constructs a Disjunction object with the specified two disjoint areas of natural selection.
     * 
     * @param area1 The first area of natural selection.
     * @param area2 The second area of natural selection.
     * @pre | area1 != null
     * @pre | area2 != null
     */
    public Disjunction(NaturalSelection area1, NaturalSelection area2) {
        this.area1 = area1;
        this.area2 = area2;
    }

    /**
     * Determines if an organism survives at the specified position in the world according to the disjunction of two areas of natural selection.
     * 
     * @param world The world in which the organism exists.
     * @param position The position of the organism.
     * @return {@code true} if the organism survives in either area1 or area2, {@code false} otherwise.
     * @pre | world != null
     * @pre | position != null
     */
    @Override
    public boolean survives(World world, Point position) {
        return area1.survives(world, position) || area2.survives(world, position);
    }
}
