package StudentTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import sim1.BehaviorB;
import sim1.Chromosome;
import sim1.Constants;
import sim1.CreatureB;
import util.Orientation;
import util.Point;


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
    void getGene() 
    {
        int[] genes = {1, 2, 3, 4, 5, 6};
        Chromosome chromosome = new Chromosome(genes);

        for (int i = 0; i < genes.length; i++) 
        {
            assertEquals(genes[i], chromosome.getGene(i));
        }
    }
    
    @Test
    void setGene() 
    {
        int[] initialGenes = {1, 2, 3, 4, 5, 6};
        Chromosome chromosome = new Chromosome(initialGenes);

        int index = 2;
        int newValue = 10;
        chromosome.setGene(index, newValue);

        assertEquals(newValue, chromosome.getGene(index));
        
        for (int i = 0; i < initialGenes.length; i++) 
        {
            if (i != index) 
            {
                assertEquals(initialGenes[i], chromosome.getGene(i));
            }
        }
    }
    
    @Test
    void crossover() 
    {
        Chromosome parent1 = new Chromosome(new int[]{1, 2, 3, 4, 5, 6});
        Chromosome parent2 = new Chromosome(new int[]{6, 7, 8, 9, 10, 11});
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
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6});
        
        chromosome.mutate(2, 10);
        
        assertEquals(13, chromosome.getGene(2));
    }

    @Test
    void giveCopy() 
    {
        BehaviorB behavior = new BehaviorB();
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        CreatureB creatureB = new CreatureB(behavior, position, orientation);

        CreatureB copy = creatureB.giveCopy();

        assertEquals(creatureB.getPosition(), copy.getPosition());
        assertEquals(creatureB.getOrientation(), copy.getOrientation());
    }
    
    @Test
    void isEqual() 
    {
        int[] weights1 = {1, 2, 3, 4, 5, 6};
        int[] weights2 = {1, 2, 3, 4, 5, 6};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome1.isEqual(chromosome2));
    }
}