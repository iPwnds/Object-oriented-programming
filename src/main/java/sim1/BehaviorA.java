package sim1;

import util.Orientation;
import util.RandomUtil;
import util.Vector;


/**
 * @immutable
 */
public class BehaviorA
{
	/**
	 * @param world
	 * @param creature
	 * 
	 * @inspects | world
	 * @mutates | creature
	 * 
	 * @pre | world != null
	 * @pre | creature != null
	 * 
	 * @post | creature.getPosition() != null
	 * @post | creature.getOrientation() != null
	 */
    public void applyBehavior(World world, CreatureA creature)
    {
    	Orientation favoriteOrientation = computeFavoriteOrientation(creature.getChromosome());
        Vector drift = favoriteOrientation.toVector();
        creature.moveForward(world, drift);        
    }
    
	/**
	 * LEGIT
	 * 
	 * The fav. orientation of a creature depends on its 3 first genes.
	 * 
	 */
    private static Orientation computeFavoriteOrientation(Chromosome chrom) {
    	
    	int mid = Constants.GENE_MIN + ((Constants.GENE_MAX - Constants.GENE_MIN)/2);
    	
    	int bit0 = (chrom.getGene(0) <= mid) ? 0 : 1;
    	int bit1 = (chrom.getGene(1) <= mid) ? 0 : 1;
    	int bit2 = (chrom.getGene(2) <= mid) ? 0 : 1;
    	
    	
    	int res = (bit2 << 2) | (bit1 << 1) | bit0;
    	if (! (0 <= res && res  <= 7)) {
    		throw new ArithmeticException("Average abs. gene value not in the expected range");
    	}
    	
    	return Orientation.orientations().get(res);
    	
    } 
}