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

	public Chromosome(int[] weights)
	{
		if (weights == null) {throw new IllegalArgumentException();}
		if (weights.length != Constants.CHROM_SIZE) { throw new IllegalArgumentException(); }
		if (Arrays.stream(weights).anyMatch(w -> !isValidGene(w))) { throw new IllegalArgumentException(); }
	    
		this.weights = Arrays.copyOf(weights, weights.length);
	}

	public static Chromosome createRandom()
    {
        int[] genes =
        		IntStream.generate(() -> RandomUtil.integer(Constants.GENE_MIN, Constants.GENE_MAX + 1))
        		.limit(Constants.CHROM_SIZE).toArray();

        return new Chromosome(genes);
    }


    public static ArrayList<Chromosome> createRandom(int count)
    {
    	var stream = IntStream.range(0,  count).mapToObj(i -> createRandom());
        
    	return new ArrayList<>(stream.toList());
    }
    

    public static boolean isValidGene(int gene)
    {
    	return Constants.GENE_MIN <= gene && gene <= Constants.GENE_MAX;
    }


    public int getGene(int index)
    {
    	return weights[index];
    }
    
    
    
    /**
     * LEGIT
     */
    public Chromosome crossover2(Chromosome other) {
    	int[] offspringGenes = new int[Constants.CHROM_SIZE];
    	int sectionSize = 6;
    	boolean leftParent = true;
    	for (int i = 0 ; i < Constants.CHROM_SIZE / sectionSize ; i++) {
    		leftParent = RandomUtil.bool();
    		for (int j = 0 ; j < sectionSize ; j++) {
    			if (leftParent) { offspringGenes[ sectionSize * i + j] = weights[sectionSize * i + j]; }
    			else { offspringGenes[ sectionSize * i + j] = other.weights[sectionSize * i + j]; }
    		}
    	
    	}
    	return new Chromosome(offspringGenes);
    }
    

    public boolean matchesUntil(Chromosome other, int index)
    {
    	return IntStream.range(0, index).allMatch(i -> getGene(i) == other.getGene(i));
    }
    

    public boolean matchesFrom(Chromosome other, int index)
    {
    	return IntStream.range(index, Constants.CHROM_SIZE).allMatch(i -> getGene(i) == other.getGene(i));
    }


    public Chromosome mutate(int index, int delta)
    {

    	int[] res = new int[weights.length];
    	for (int i = 0 ; i < weights.length ; i++) {
    		res[i] = weights[i];
    	}
    	if (Constants.GENE_MIN <= weights[index] + delta && weights[index] + delta <= Constants.GENE_MAX)
    		res[index] += delta;
    	return new Chromosome(res);
    }


    public Chromosome randomlyMutate()
    {
        var index = RandomUtil.integer(weights.length);
        var delta = RandomUtil.integer(-Constants.GENE_DELTA, Constants.GENE_DELTA);

        return mutate(index, delta);
    }
    

    public boolean onlyDiffersAt(Chromosome other, int index)
    {
    	return IntStream.range(0, Constants.CHROM_SIZE).allMatch(i -> implies(i != index, getGene(i) == other.getGene(i)));
    }
    
    

    public boolean isEqual(Chromosome other) {
    	boolean res = (other != null);
    	for (int i = 0 ; i < weights.length ; i ++) {
    		res = res && (weights[i] == other.getGene(i));
    	}
    	return res;
    }
}
