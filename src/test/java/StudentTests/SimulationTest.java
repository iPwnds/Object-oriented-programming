package StudentTests;

import org.junit.jupiter.api.Test;
import sim1.Chromosome;
import sim1.CreatureA;
import sim1.CreatureB;
import sim1.Simulation;
import sim1.World;
import util.Orientation;
import util.Point;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


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
    
    @Test
    void countSurvivingCreatureA() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException 
    {
        Simulation simulation = new Simulation(10, 10, 0);
        World world = new World(10, 10, new CreatureA[]{}, new CreatureB[]{});

        Method method = Simulation.class.getDeclaredMethod("countSurvivingCreatureA");
        method.setAccessible(true);

        int result = (int) method.invoke(simulation);

        assertEquals(0, result);
    }

    @Test
    void countSurvivingCreatureB() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException 
    {
        Simulation simulation = new Simulation(10, 10, 0);
        World world = new World(10, 10, new CreatureA[]{}, new CreatureB[]{});

        Method method = Simulation.class.getDeclaredMethod("countSurvivingCreatureB");
        method.setAccessible(true);

        int result = (int) method.invoke(simulation);

        assertEquals(0, result);
    }

    @Test
    void computeOffspring() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException 
    {
        Simulation simulation = new Simulation(10, 10, 0);
        ArrayList<Chromosome> parentGeneration = new ArrayList<>();
        parentGeneration.add(new Chromosome(new int[]{1, 2, 3}));
        parentGeneration.add(new Chromosome(new int[]{4, 5, 6}));

        Method method = Simulation.class.getDeclaredMethod("computeOffspring", ArrayList.class, int.class);
        method.setAccessible(true);

        Chromosome[] result = (Chromosome[]) method.invoke(simulation, parentGeneration, 2);

        assertEquals(2, result.length);
    }
}
