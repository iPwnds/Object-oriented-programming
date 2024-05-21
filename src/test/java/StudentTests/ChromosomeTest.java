package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Constants;
import java.util.Arrays;

public class ChromosomeTest {

    @Test
    void testChromosomeConstructor() {
        // Test valid constructor call
        int[] validWeights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome = new Chromosome(validWeights);
        assertArrayEquals(validWeights, chromosome.getWeights());

        // Test invalid constructor calls
        assertThrows(AssertionError.class, () -> new Chromosome(null));
        assertThrows(AssertionError.class, () -> new Chromosome(new int[5])); // Invalid size
        assertThrows(AssertionError.class, () -> new Chromosome(new int[]{1, 2, 3, 4, 6})); // Invalid gene
    }

    @Test
    void testCreateRandom() {
        // Test creating random chromosome
        Chromosome chromosome = Chromosome.createRandom();
        assertNotNull(chromosome);
        assertEquals(Constants.CHROM_SIZE, chromosome.getWeights().length);
        assertTrue(Arrays.stream(chromosome.getWeights()).allMatch(Chromosome::isValidGene));
    }

    @Test
    void testIsValidGene() {
        assertTrue(Chromosome.isValidGene(3)); // Valid gene
        assertFalse(Chromosome.isValidGene(-1001)); // Below valid range
        assertFalse(Chromosome.isValidGene(1001)); // Above valid range
    }

    @Test
    void testGetGene() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome = new Chromosome(weights);

        assertEquals(3, chromosome.getGene(2)); // Valid index
        assertThrows(AssertionError.class, () -> chromosome.getGene(-1)); // Below valid index
        assertThrows(AssertionError.class, () -> chromosome.getGene(12)); // Above valid index
    }

    @Test
    void testMatchesUntil() {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] weights2 = {1, 2, 13, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome1.matchesUntil(chromosome2, 2));
        assertFalse(chromosome1.matchesUntil(chromosome2, 3));
    }

    @Test
    void testMatchesFrom() {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] weights2 = {1, 2, 13, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome1.matchesFrom(chromosome2, 3));
        assertFalse(chromosome1.matchesFrom(chromosome2, 2));
    }

    @Test
    void testMutate() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome = new Chromosome(weights);

        // Test valid mutation
        Chromosome mutatedChromosome = chromosome.mutate(2, 10);
        assertEquals(13, mutatedChromosome.getGene(2));

        // Test invalid mutation (delta out of range)
        assertThrows(AssertionError.class, () -> chromosome.mutate(3, 201));
    }
    
    @Test
    void testRandomlyMutate() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome = new Chromosome(weights);
        Chromosome mutatedChromosome = chromosome.randomlyMutate();

        assertNotNull(mutatedChromosome);
        assertEquals(Constants.CHROM_SIZE, mutatedChromosome.getWeights().length);
        assertTrue(Arrays.stream(mutatedChromosome.getWeights()).allMatch(Chromosome::isValidGene));
        assertTrue(Arrays.equals(chromosome.getWeights(), mutatedChromosome.getWeights())
                || Arrays.stream(chromosome.getWeights()).anyMatch(x -> x != mutatedChromosome.getWeights()[0]));
    }

    @Test
    void testOnlyDiffersAt() {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] weights2 = {1, 2, 13, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome1.onlyDiffersAt(chromosome2, 2));
        assertFalse(chromosome1.onlyDiffersAt(chromosome2, 3));
    }

    @Test
    void testIsEqual() {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] weights2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome1.isEqual(chromosome2));
    }

    @Test
    void testGetWeights() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Chromosome chromosome = new Chromosome(weights);

        assertArrayEquals(weights, chromosome.getWeights()); // Valid weights retrieval
    }
    
}
