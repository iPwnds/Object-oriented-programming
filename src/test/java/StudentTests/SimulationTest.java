package StudentTests;

import org.junit.jupiter.api.Test;

import sim1.Chromosome;
import sim1.Simulation;
import sim1.World;

import static org.junit.jupiter.api.Assertions.*;


public class SimulationTest 
{
    @Test
    void simulation() 
    {
        int size = 10;
        int populationSize = 20;
        int numA = 10;
        Simulation simulation = new Simulation(size, populationSize, numA);

        assertNotNull(simulation);
        assertEquals(populationSize, simulation.getPopulationSize());
        assertNotNull(simulation.getWorld());
    }
    
    @Test
    void createRandWorldWith_ValidParameters_CreatesWorldCorrectly() 
    {
        int size = 10;
        int popuSize = 20;
        int numA = 10;
        int numB = 10;
        
        Chromosome[] chromsA = new Chromosome[numA];
        
        for (int i = 0; i < numA; i++) 
        {
            chromsA[i] = new Chromosome(new int[]{1, 2, 3});
        }

        World world = Simulation.createRandWorldWith(size, popuSize, numA, numB, chromsA);

        assertNotNull(world);
        assertEquals(size, world.getWidth());
        assertEquals(size, world.getHeight());
        assertEquals(numA, world.getPopulationA().length);
        assertEquals(numB, world.getPopulationB().length);
    }
}
