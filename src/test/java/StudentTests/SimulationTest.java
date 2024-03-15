package StudentTests;

import org.junit.jupiter.api.Test;

import sim1.Chromosome;
import sim1.CreatureA;
import sim1.CreatureB;
import sim1.Simulation;
import sim1.World;
import util.Orientation;
import util.Point;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


public class SimulationTest 
{
    @Test
    void createRandWorldWith() 
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
    
    @Test
    void getWorld() 
    {
        CreatureA[] populationA = {new CreatureA(null, new Point(1, 1), Orientation.north(), null)};
        CreatureB[] populationB = {new CreatureB(null, new Point(2, 2), Orientation.south())};
        World originalWorld = new World(10, 10, populationA, populationB);

        Simulation simulation = new Simulation(10, 10, 1);

        World newWorld = simulation.getWorld();

        assertEquals(originalWorld.getWidth(), newWorld.getWidth());
        assertEquals(originalWorld.getHeight(), newWorld.getHeight());
    }
    
    @Test
    void survives() 
    {
        Simulation simulation = new Simulation(10, 10, 0);

        Point insideSurvivalZone = new Point(8, 8);
        assertTrue(simulation.survives(insideSurvivalZone));

        Point outsideSurvivalZone = new Point(5, 5);
        assertFalse(simulation.survives(outsideSurvivalZone));
    }
}
