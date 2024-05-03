package sim;

import static util.Logic.implies;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import util.RandomUtil;

/**
 * @immutable
 */
public class Chromosome
{
    private final int[] weights;

    /**
     * Constructs a new chromosome with the given array of weights as genes.
     * 
     * @param weights An array of integers representing the genes of the chromosome.
     * 
     * @pre | weights != null
     * @pre | weights.length == Constants.CHROM_SIZE
     * @pre | Arrays.stream(weights).allMatch(Chromosome::isValidGene)
     */
	public Chromosome(int[] weights)
	{
		if (weights == null) 
		{
			throw new IllegalArgumentException();
		}
		
		if (weights.length != Constants.CHROM_SIZE) 
		{ 
			throw new IllegalArgumentException(); 
		}
		
		if (Arrays.stream(weights).anyMatch(w -> !isValidGene(w))) 
		{ 
			throw new IllegalArgumentException(); 
		}
	    
		this.weights = Arrays.copyOf(weights, weights.length);
	}
	
	/**
	 * Creates a random chromosome with randomly generated genes.
	 * 
	 * @return A randomly generated chromosome.
	 * 
	 * @post | result != null
	 * @post | result.getGene(0) == result.getGene(0)
	 * @post | IntStream.range(0, Constants.CHROM_SIZE).allMatch(i -> Chromosome.isValidGene(result.getGene(i)))
	 */
	public static Chromosome createRandom()
    {
        int[] genes =
        		IntStream.generate(() -> RandomUtil.integer(Constants.GENE_MIN, Constants.GENE_MAX + 1))
        		.limit(Constants.CHROM_SIZE).toArray();

        return new Chromosome(genes);
    }

	/**
	 * Creates a list of random chromosomes with the specified count.
	 * 
	 * @param count The number of chromosomes to create.
	 * @return An ArrayList containing the randomly generated chromosomes.
	 * 
	 * @pre | count > 0
	 * @post | result != null
	 * @post | result.size() == count
	 * @post | result.stream().allMatch(c -> IntStream.range(0, Constants.CHROM_SIZE)
	 *         |    .allMatch(i -> Chromosome.isValidGene(c.getGene(i))))
	 */
    public static ArrayList<Chromosome> createRandom(int count)
    {
    	var stream = IntStream.range(0,  count).mapToObj(i -> createRandom());
        
    	return new ArrayList<>(stream.toList());
    }
    
    /**
     * Checks if a given gene value is within the valid range.
     * 
     * @param gene The gene value to check.
     * @return True if the gene value is valid, false otherwise.
     * 
     * @post | result == (gene >= Constants.GENE_MIN && gene <= Constants.GENE_MAX)
     */
    public static boolean isValidGene(int gene)
    {
    	return Constants.GENE_MIN <= gene && gene <= Constants.GENE_MAX;
    }

    /**
     * Returns the gene value at the specified index.
     * 
     * @param index The index of the gene to retrieve.
     * @return The gene value at the specified index.
     * 
     * @pre | index >= 0 && index < Constants.CHROM_SIZE
     * @post | result == getGene(index)
     */
    public int getGene(int index)
    {
    	return weights[index];
    }
    
    /**
     * LEGIT
     */
    public Chromosome crossover2(Chromosome other) 
    {
    	int[] offspringGenes = new int[Constants.CHROM_SIZE];
    	int sectionSize = 6;
    	boolean leftParent = true;
    	for (int i = 0 ; i < Constants.CHROM_SIZE / sectionSize ; i++) 
    	{
    		leftParent = RandomUtil.bool();
    		for (int j = 0 ; j < sectionSize ; j++) 
    		{
    			if (leftParent) 
    			{ 
    				offspringGenes[ sectionSize * i + j] = weights[sectionSize * i + j]; 
    			}
    			else 
    			{ 
    				offspringGenes[ sectionSize * i + j] = other.weights[sectionSize * i + j]; 
    			}
    		}
    	
    	}
    	return new Chromosome(offspringGenes);
    }
    
    /**
     * Determines whether this chromosome matches another chromosome up to a specified index.
     * 
     * @param other The other chromosome to compare against.
     * @param index The index up to which to compare the genes.
     * @return True if the chromosomes match up to the specified index, false otherwise.
     * 
     * @pre | other != null
     * @pre | index >= 0 && index < Constants.CHROM_SIZE
     * @post | result == IntStream.range(0, index).allMatch(i -> this.getGene(i) == other.getGene(i))
     */
    public boolean matchesUntil(Chromosome other, int index)
    {
    	return IntStream.range(0, index).allMatch(i -> getGene(i) == other.getGene(i));
    }
    
    /**
     * Determines whether this chromosome matches another chromosome from a specified index.
     * 
     * @param other The other chromosome to compare against.
     * @param index The index from which to compare the genes.
     * @return True if the chromosomes match from the specified index, false otherwise.
     * 
     * @pre | other != null
     * @pre | index >= 0 && index < Constants.CHROM_SIZE
     * @post | result == IntStream.range(index, Constants.CHROM_SIZE).allMatch(i -> this.getGene(i) == other.getGene(i))
     */
    public boolean matchesFrom(Chromosome other, int index)
    {
    	return IntStream.range(index, Constants.CHROM_SIZE).allMatch(i -> getGene(i) == other.getGene(i));
    }

    /**
     * Mutates a gene at a specified index by adding a delta value to the current gene value.
     * 
     * @param index The index of the gene to mutate.
     * @param delta The value to add to the current gene value.
     * @return A new chromosome with the mutated gene.
     * 
     * @pre | index >= 0 && index < Constants.CHROM_SIZE
     * @pre | Constants.GENE_MIN <= this.getGene(index) + delta &&
     *       | Constants.GENE_MAX >= this.getGene(index) + delta
     * @post | result != null
     * @post | result.getGene(index) == this.getGene(index) + delta
     */
    public Chromosome mutate(int index, int delta)
    {

    	int[] res = new int[weights.length];
    	for (int i = 0 ; i < weights.length ; i++) 
    	{
    		res[i] = weights[i];
    	}
    	
    	if (Constants.GENE_MIN <= weights[index] + delta && weights[index] + delta <= Constants.GENE_MAX)
    		res[index] += delta;
    	return new Chromosome(res);
    }

    /**
     * Mutates a randomly selected gene in the chromosome by adding a delta value to it.
     * 
     * @return A new chromosome with the randomly mutated gene.
     * 
     * @post | result != null
     * @post | result.getGene(0) == result.getGene(0)
     * @post | IntStream.range(0, Constants.CHROM_SIZE).allMatch(i -> Chromosome.isValidGene(result.getGene(i)))
     */
    public Chromosome randomlyMutate()
    {
        var index = RandomUtil.integer(weights.length);
        var delta = RandomUtil.integer(-Constants.GENE_DELTA, Constants.GENE_DELTA);

        return mutate(index, delta);
    }
    
    /**
     * Determines whether this chromosome only differs from another chromosome at a specified index.
     * 
     * @param other The other chromosome to compare against.
     * @param index The index at which to compare genes.
     * @return True if the chromosomes only differ at the specified index, false otherwise.
     * 
     * @pre | other != null
     * @pre | index >= 0 && index < Constants.CHROM_SIZE
     * @post | result == (IntStream.range(0, Constants.CHROM_SIZE)
     *         |           .allMatch(i -> i != index ? this.getGene(i) == other.getGene(i) : true))
     */
    public boolean onlyDiffersAt(Chromosome other, int index)
    {
    	return IntStream.range(0, Constants.CHROM_SIZE).allMatch(i -> implies(i != index, getGene(i) == other.getGene(i)));
    }
    
    /**
     * Determines whether this chromosome is equal to another chromosome.
     * Two chromosomes are considered equal if they have the same genes in the same order.
     * 
     * @param other The other chromosome to compare against.
     * @return True if the chromosomes are equal, false otherwise.
     * 
     * @pre | other != null
     * @post | result == IntStream.range(0, Constants.CHROM_SIZE)
     *         |           .allMatch(i -> this.getGene(i) == other.getGene(i))
     */
    public boolean isEqual(Chromosome other) 
    {
    	boolean res = (other != null);
    	for (int i = 0 ; i < weights.length ; i ++) 
    	{
    		res = res && (weights[i] == other.getGene(i));
    	}
    	
    	return res;
    }
}
