package StudentTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Constants;

public class ChromosomeTest {

    @Test
    public void testConstructorAndGetters() {
        int[] validWeights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}; // Sample weights for testing
        Chromosome chromosome = new Chromosome(validWeights);
        assertArrayEquals(validWeights, chromosome.getWeights());
    }

    @Test
    public void testCreateRandom() {
        Chromosome chromosome = Chromosome.createRandom();
        assertNotNull(chromosome);
        int[] weights = chromosome.getWeights();
        assertTrue(weights.length == Constants.CHROM_SIZE);
        for (int weight : weights) {
            assertTrue(weight >= Constants.GENE_MIN && weight <= Constants.GENE_MAX);
        }
    }

    @Test
    public void testCreateRandomMultiple() {
        int count = 10;
        Chromosome[] chromosomes = Chromosome.createRandom(count);
        assertNotNull(chromosomes);
        assertEquals(count, chromosomes.length);
        for (Chromosome chromosome : chromosomes) {
            assertNotNull(chromosome);
            int[] weights = chromosome.getWeights();
            assertTrue(weights.length == Constants.CHROM_SIZE);
            for (int weight : weights) {
                assertTrue(weight >= Constants.GENE_MIN && weight <= Constants.GENE_MAX);
            }
        }
    }

    @Test
    public void testCrossover() {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        int[] weights2 = {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);
        Chromosome offspring = chromosome1.crossover2(chromosome2);
        int[] offspringWeights = offspring.getWeights();
        assertTrue(Arrays.stream(offspringWeights).anyMatch(w -> w >= 1 && w <= 24));
        assertTrue(Arrays.stream(offspringWeights).anyMatch(w -> w >= 24 && w <= 48));
    }

    @Test
    public void testMutate() {
        int[] validWeights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}; // Sample weights for testing
        Chromosome chromosome = new Chromosome(validWeights);
        int index = 0; // Index of gene to mutate
        int delta = 10; // Mutation delta
        Chromosome mutatedChromosome = chromosome.mutate(index, delta);
        int[] mutatedWeights = mutatedChromosome.getWeights();
        assertEquals(validWeights[index] + delta, mutatedWeights[index]);
    }

    @Test
    public void testRandomlyMutate() {
        int[] validWeights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}; // Sample weights for testing
        Chromosome chromosome = new Chromosome(validWeights);
        Chromosome mutatedChromosome = chromosome.randomlyMutate();
        int[] mutatedWeights = mutatedChromosome.getWeights();
        assertFalse(Arrays.equals(validWeights, mutatedWeights));
    }

    @Test
    public void testMatchesUntil() {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        int[] weights2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);
        assertTrue(chromosome1.matchesUntil(chromosome2, 12));
        assertFalse(chromosome1.matchesUntil(chromosome2, 13));
    }

    @Test
    public void testMatchesFrom() {
    	int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        int[] weights2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);
        assertFalse(chromosome1.matchesFrom(chromosome2, 23));
        assertTrue(chromosome1.matchesFrom(chromosome2, 24));
    }

    @Test
    public void testOnlyDiffersAt() {
    	int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    	int[] weights2 = {1, 2, 3, 4, 5, 25, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);
        assertTrue(chromosome1.onlyDiffersAt(chromosome2, 5));
        assertFalse(chromosome1.onlyDiffersAt(chromosome2, 3));
    }

    @Test
    public void testIsEqual() {
    	int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    	int[] weights2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);
        assertTrue(chromosome1.isEqual(chromosome2));
    }
}
