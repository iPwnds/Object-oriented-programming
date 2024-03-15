package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim1.Chromosome;


class ChromosomeTest 
{
    @Test
    void createRandom() 
    {
        Chromosome chromosome = Chromosome.createRandom();
        
        assertNotNull(chromosome);
    }

    @Test
    void createRandomCount() 
    {
        int count = 5;
        Chromosome[] chromosomes = Chromosome.createRandom(count);
        assertNotNull(chromosomes);
        assertEquals(count, chromosomes.length);
        
        for (Chromosome chromosome : chromosomes) 
        {
            assertNotNull(chromosome);
        }
    }

    @Test
    void crossover() 
    {
        Chromosome parent1 = new Chromosome(new int[]{1, 2, 3, 4, 5});
        Chromosome parent2 = new Chromosome(new int[]{6, 7, 8, 9, 10});
        Chromosome offspring = parent1.crossover(parent2, 2);
        
        assertNotNull(offspring);
        
        assertEquals(1, offspring.getGene(0));
        assertEquals(2, offspring.getGene(1));
        assertEquals(8, offspring.getGene(2));
        assertEquals(9, offspring.getGene(3));
        assertEquals(10, offspring.getGene(4));
    }

    @Test
    void mutate() 
    {
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5});
        
        chromosome.mutate(2, 10);
        
        assertEquals(13, chromosome.getGene(2));
    }

    @Test
    void giveCopy() 
    {
        Chromosome original = new Chromosome(new int[]{1, 2, 3, 4, 5});
        Chromosome copy = original.giveCopy();
        
        assertNotNull(copy);
        
        assertNotSame(original, copy);
        
        assertTrue(original.isEqual(copy));
    }
}