package sim;

import static util.Logic.implies;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import util.RandomUtil;

/**
 * The Chromosome class represents a chromosome in a genetic algorithm.
 * 
 * @immutable
 */
public class Chromosome
{
	/**
	 * Array to store the gene weights of the chromosome
	 */
    private final int[] weights;

    /**
     * Constructs a new Chromosome object with the given gene weights.
     * 
     * @param weights An array of integers representing the gene weights of the chromosome.
     * @pre | weights != null
     * @pre | weights.length == Constants.CHROM_SIZE
     * @pre | Arrays.stream(weights).allMatch(Chromosome::isValidGene)
     * @post | Arrays.equals(this.getWeights(), weights)
     * @throws IllegalArgumentException if weights is null, has a length different from Constants.CHROM_SIZE, or contains invalid genes.
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
     * Generates a random Chromosome object with random gene weights.
     * 
     * @return A randomly generated Chromosome object.
     * @post | result != null
     * @post | result.getWeights().length == Constants.CHROM_SIZE
     * @post | Arrays.stream(result.getWeights()).allMatch(Chromosome::isValidGene)
     */
	public static Chromosome createRandom()
    {
        int[] genes =
        		IntStream.generate(() -> RandomUtil.integer(Constants.GENE_MIN, Constants.GENE_MAX + 1))
        		.limit(Constants.CHROM_SIZE).toArray();

        return new Chromosome(genes);
    }

	/**
     * Generates a list of random Chromosome objects with specified count.
     * 
     * @param count The number of Chromosome objects to generate.
     * @return An ArrayList containing randomly generated Chromosome objects.
     * @post | result != null
     * @post | result.size() == count
     * @post | result.stream().allMatch(c -> c.getWeights().length == Constants.CHROM_SIZE)
     * @post | result.stream().allMatch(c -> Arrays.stream(c.getWeights()).allMatch(Chromosome::isValidGene))
     */
    public static ArrayList<Chromosome> createRandom(int count)
    {
    	var stream = IntStream.range(0,  count).mapToObj(i -> createRandom());
        
    	return new ArrayList<>(stream.toList());
    }
    
    /**
     * Checks if a gene value is valid.
     * 
     * @param gene The gene value to check.
     * @return True if the gene value is within the valid range, false otherwise.
     * @post | result == (gene >= Constants.GENE_MIN && gene <= Constants.GENE_MAX)
     */
    public static boolean isValidGene(int gene)
    {
    	return Constants.GENE_MIN <= gene && gene <= Constants.GENE_MAX;
    }

    /**
     * Gets the gene weight at the specified index.
     * 
     * @param index The index of the gene weight to retrieve.
     * @return The gene weight at the specified index.
     * @pre | index >= 0 && index < Constants.CHROM_SIZE
     * @post | result == getWeights()[index]
     */
    public int getGene(int index)
    {
    	return weights[index];
    }
    
    /**
     * Checks whether two chromosomes match until a specified index.
     * 
     * @param other The other chromosome to compare.
     * @param index The index until which to compare.
     * @return True if the chromosomes match until the specified index, false otherwise.
     * @pre | other != null
     * @pre | index >= 0 && index <= Constants.CHROM_SIZE
     * @post | result == IntStream.range(0, index).allMatch(i -> getGene(i) == other.getGene(i))
     */
    public boolean matchesUntil(Chromosome other, int index)
    {
    	return IntStream.range(0, index).allMatch(i -> getGene(i) == other.getGene(i));
    }
    
    /**
     * Checks whether two chromosomes match from a specified index until the end.
     * 
     * @param other The other chromosome to compare.
     * @param index The index from which to compare.
     * @return True if the chromosomes match from the specified index until the end, false otherwise.
     * @pre | other != null
     * @pre | index >= 0 && index <= Constants.CHROM_SIZE
     * @post | result == IntStream.range(index, Constants.CHROM_SIZE).allMatch(i -> getGene(i) == other.getGene(i))
     */
    public boolean matchesFrom(Chromosome other, int index)
    {
    	return IntStream.range(index, Constants.CHROM_SIZE).allMatch(i -> getGene(i) == other.getGene(i));
    }

    /**
     * Mutates the gene weight at the specified index by adding the given delta.
     * 
     * @param index The index of the gene weight to mutate.
     * @param delta The amount to add to the gene weight.
     * @return A new chromosome with the mutated gene weight.
     * @pre | index >= 0 && index < Constants.CHROM_SIZE
     * @pre | delta >= -Constants.GENE_DELTA && delta <= Constants.GENE_DELTA
//de weights van het result moeten nog 
// geinitialiseerd worden vgm    * @post | Arrays.equals(result.getWeights(), Arrays.copyOf(getWeights(), getWeights().length))
     * @post | result.getWeights()[index] == Math.max(Constants.GENE_MIN, Math.min(getWeights()[index] + delta, Constants.GENE_MAX))
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
     * Performs a random mutation on one of the gene weights.
     * 
     * @return A new chromosome with a randomly mutated gene weight.
     * @post | result != null
     * @post | result.getWeights().length == Constants.CHROM_SIZE
     * @post | Arrays.stream(result.getWeights()).allMatch(Chromosome::isValidGene)
     * @post | Arrays.equals(result.getWeights(), getWeights()) || IntStream.range(0, Constants.CHROM_SIZE).anyMatch(i -> result.getWeights()[i] != getWeights()[i])
     */
    public Chromosome randomlyMutate()
    {
        var index = RandomUtil.integer(weights.length);
        var delta = RandomUtil.integer(-Constants.GENE_DELTA, Constants.GENE_DELTA);

        return mutate(index, delta);
    }
    
    /**
     * Checks whether two chromosomes only differ at a specified index.
     * 
     * @param other The other chromosome to compare.
     * @param index The index at which to check for difference.
     * @return True if the chromosomes only differ at the specified index, false otherwise.
     * @pre | other != null
     * @pre | index >= 0 && index <= Constants.CHROM_SIZE
     * @post | result == IntStream.range(0, Constants.CHROM_SIZE).allMatch(i -> implies(i != index, getGene(i) == other.getGene(i)))
     */
    public boolean onlyDiffersAt(Chromosome other, int index)
    {
    	return IntStream.range(0, Constants.CHROM_SIZE)
    			.allMatch(i -> implies(i != index, getGene(i) == other.getGene(i)));
    }
    
    /**
     * Checks whether this chromosome is equal to another chromosome.
     * 
     * @param other The other chromosome to compare.
     * @return True if the chromosomes are equal, false otherwise.
     * @pre | other != null
     * @post | result == Arrays.equals(getWeights(), other.getWeights())
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
     * Gets the gene weights array of the chromosome.
     * Used for documentation ONLY
     * Should not have representation exposure
     * 
     * @return An array of integers representing the gene weights.
     */
    public int[] getWeights() {
        return Arrays.copyOf(weights, weights.length);
    }
}
