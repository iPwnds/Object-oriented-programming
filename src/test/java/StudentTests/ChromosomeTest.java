package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Constants;
import java.util.Arrays;

public class ChromosomeTest {

	private int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private Chromosome chromosome = new Chromosome(weights);
	
    @Test
    public void testChromosomeConstructor() {
        // Test valid constructor call
        assertArrayEquals(weights, chromosome.getWeights());

        // Test invalid constructor calls
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Chromosome(null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Chromosome(new int[5])); // Invalid size
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Chromosome(new int[]{1, 2, 3, 4, 6})); // Invalid gene
    }

    @Test
    public void testCreateRandom() {
        // Test creating random chromosome
        Chromosome chromosome = Chromosome.createRandom();
        
        assertNotNull(chromosome);
        assertEquals(Constants.CHROM_SIZE, chromosome.getWeights().length);
        assertTrue(Arrays.stream(chromosome.getWeights()).allMatch(Chromosome::isValidGene));
    }

    @Test
    public void testIsValidGene() {
        assertTrue(Chromosome.isValidGene(3)); // Valid gene
        assertFalse(Chromosome.isValidGene(-1001)); // Below valid range
        assertFalse(Chromosome.isValidGene(1001)); // Above valid range
    }

    @Test
    public void testGetGene() {
        assertEquals(3, chromosome.getGene(2)); // Valid index
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> chromosome.getGene(-1)); // Below valid index
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> chromosome.getGene(12)); // Above valid index
    }

    @Test
    public void testMatchesUntil() {
        int[] weights2 = {1, 2, 13, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome.matchesUntil(chromosome2, 2));
        assertFalse(chromosome.matchesUntil(chromosome2, 3));
    }

    @Test
    public void testMatchesFrom() {
        int[] weights2 = {1, 2, 13, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome.matchesFrom(chromosome2, 3));
        assertFalse(chromosome.matchesFrom(chromosome2, 2));
    }

    @Test
    public void testMutate() {
        // Test valid mutation
        Chromosome mutatedChromosome = chromosome.mutate(2, 10);
        
        assertEquals(13, mutatedChromosome.getGene(2));

        // Test invalid mutation (delta out of range)
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> chromosome.mutate(3, 201));
    }
    
    @Test
    public void testRandomlyMutate() {
        Chromosome mutatedChromosome = chromosome.randomlyMutate();

        assertNotNull(mutatedChromosome);
        assertEquals(Constants.CHROM_SIZE, mutatedChromosome.getWeights().length);
        assertTrue(Arrays.stream(mutatedChromosome.getWeights()).allMatch(Chromosome::isValidGene));
        assertTrue(Arrays.equals(chromosome.getWeights(), mutatedChromosome.getWeights())
                || Arrays.stream(chromosome.getWeights()).anyMatch(x -> x != mutatedChromosome.getWeights()[0]));
    }

    @Test
    public void testOnlyDiffersAt() {
        int[] weights2 = {1, 2, 13, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome.onlyDiffersAt(chromosome2, 2));
        assertFalse(chromosome.onlyDiffersAt(chromosome2, 3));
    }

    @Test
    public void testIsEqual() {
        int[] weights2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome.isEqual(chromosome2));
    }

    @Test
    public void testGetWeights() {
        assertArrayEquals(weights, chromosome.getWeights()); // Valid weights retrieval
    }
    
}
