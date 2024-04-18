package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Constants;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import java.util.Arrays;
import java.util.stream.IntStream;

class ChromosomeTest {

    @Test
    void constructor_validWeights() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        Chromosome chromosome = new Chromosome(weights);
        for (int i = 0; i < Constants.CHROM_SIZE; i++) {
            assertEquals(weights[i], chromosome.getGene(i));
        }
    }

    @Test
    void constructor_invalidWeights() {
        assertThrows(IllegalArgumentException.class, () -> new Chromosome(null));
        assertThrows(IllegalArgumentException.class, () -> new Chromosome(new int[5]));
        assertThrows(IllegalArgumentException.class, () -> new Chromosome(new int[]{1, 2, 3, 4, 7}));
    }

    @Test
    void createRandom_validChromosome() {
        Chromosome chromosome = Chromosome.createRandom();
        assertNotNull(chromosome);
        assertTrue(chromosome.getGene(0) >= Constants.GENE_MIN && chromosome.getGene(0) <= Constants.GENE_MAX);
        assertTrue(IntStream.range(0, Constants.CHROM_SIZE).allMatch(i -> Chromosome.isValidGene(chromosome.getGene(i))));
    }

    @Test
    void crossover2_validCrossover() {
        Chromosome chromosome1 = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Chromosome chromosome2 = new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48});
        Chromosome offspring = chromosome1.crossover2(chromosome2);
        assertNotNull(offspring);
        for (int i = 0; i < Constants.CHROM_SIZE; i++) {
            assertTrue(chromosome1.getGene(i) == offspring.getGene(i) || chromosome2.getGene(i) == offspring.getGene(i));
        }
    }

    @Test
    void mutate_validMutation() {
    	Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        int index = 2;
        int delta = 10;
        Chromosome mutatedChromosome = chromosome.mutate(index, delta);
        assertNotNull(mutatedChromosome);
        assertNotEquals(chromosome.getGene(index), mutatedChromosome.getGene(index));
        assumeTrue(chromosome.getGene(index) + delta >= Constants.GENE_MIN &&
                   chromosome.getGene(index) + delta <= Constants.GENE_MAX);
        assertEquals(chromosome.getGene(index) + delta, mutatedChromosome.getGene(index));
    }

    @Test
    void isEqual_identicalChromosomes() {
    	Chromosome chromosome1 = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
    	Chromosome chromosome2 = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        assertTrue(chromosome1.isEqual(chromosome2));
    }

    @Test
    void isEqual_differentChromosomes() {
    	Chromosome chromosome1 = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        Chromosome chromosome2 = new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48});
        assertFalse(chromosome1.isEqual(chromosome2));
    }
}
