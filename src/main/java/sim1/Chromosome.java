package sim1;

import java.util.Arrays;
import java.util.stream.IntStream;

import util.RandomUtil;


public class Chromosome
{
    /**
     * @representationObject
     */
    private int[] weights;

    
	public Chromosome(int[] weights)
	{
		this.weights = weights;
	}

	/**
	 * LEGIT
	 * Gives 1 randomly generated chromosome
	 * @creates | result
	 */
	public static Chromosome createRandom()
    {

        int[] genes =
        		IntStream.generate(() -> RandomUtil.integer(Constants.GENE_MIN, Constants.GENE_MAX + 1))
        		.limit(Constants.CHROM_SIZE).toArray();

        return new Chromosome(genes);
    }

	/**
	 * Gives `count` randomly generated chromosomes
	 * 
	 * @param count
	 * @return
	 */
    public static Chromosome[] createRandom(int count)
    {
    	Chromosome[] chromosomes = new Chromosome[count];
    	
        for (int i = 0; i < count; i++) 
        {
            chromosomes[i] = createRandom();
        }
        
        return chromosomes;
    }

    /**
     * index should be 0 <= index < Cst.CHROM_SIZE
     * 
     * @param index
     * @return
     */
    public int getGene(int index)
    {
    	return weights[index];
    }
    
    /**
     * @param index
     * @param val
     */
    public void setGene(int index, int val) 
    {
        weights[index] = val;
    }

    /**
     * Returns a Chromosome whose weights are derived from `this` and `other` weights
     *  
     * @param other
     * @param index
     * @return
     * 
     * @pre | other != null
     * @pre | 0 <= index && index < Constants.CHROM_SIZE
     * 
     * @post The result starts with the first `index` genes from `this`
     * and finishes with (0 <=) genes picked in `other`.  
     * @post | result != null
     */
    public Chromosome crossover(Chromosome other, int index)
    {
    	int[] offspringGenes = new int[Constants.CHROM_SIZE];

        for (int i = 0; i < index && i < Constants.CHROM_SIZE; i++) 
        {
            offspringGenes[i] = this.getGene(i);
        }

        for (int i = index; i < Constants.CHROM_SIZE && i < other.weights.length; i++) 
        {
            offspringGenes[i] = other.getGene(i);
        }

        return new Chromosome(offspringGenes);
    }

    /**
     * Gene #index is set to gene + delta if that modification remains within gene bounds.
     * 
     * @param index
     * @param delta
     * 
     * @pre | 0 <= index && index < Constants.CHROM_SIZE
     */
    public void mutate(int index, int delta)
    {
    	int newValue = weights[index] + delta;
        
    	if (newValue >= Constants.GENE_MIN && newValue <= Constants.GENE_MAX) 
        {
            weights[index] = newValue;
        }
    }

    public void randomlyMutate()
    {
        var index = RandomUtil.integer(weights.length);
        var delta = RandomUtil.integer(-Constants.GENE_DELTA, Constants.GENE_DELTA);

        this.mutate(index, delta);
    }
    
    /**
     * @return
     * 
     * @creates | result
     */
    public Chromosome giveCopy() {
    	int[] copy = Arrays.copyOf(weights, weights.length);
        return new Chromosome(copy);
    }
    
    /**
     * LEGIT
     */
    public boolean isEqual(Chromosome other) {
    	boolean res = (other != null);
    	for (int i = 0 ; i < weights.length ; i ++) {
    		res = res && (weights[i] == other.getGene(i));
    	}
    	return res;
    }
}
