package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim1.*;
import util.Orientation;
import util.Point;

class WorldTest 
{
	@Test
    void constructor() 
	{
        CreatureA[] populationA =
        {
                new CreatureA(null, null, null, null),
                new CreatureA(null, null, null, null)
        };

        CreatureB[] populationB = 
        {
                new CreatureB(null, null, null),
                new CreatureB(null, null, null),
                new CreatureB(null, null, null)
        };

        World world = new World(10, 20, populationA, populationB);

        assertEquals(10, world.getWidth());
        assertEquals(20, world.getHeight());

        assertArrayEquals(populationA, world.getPopulationA());
        assertArrayEquals(populationB, world.getPopulationB());
    }
	
    @Test
    void isInside() 
    {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertTrue(world.isInside(new Point(5, 5)));
        assertFalse(world.isInside(new Point(15, 25)));
    }

    @Test
    void isLimPos() 
    {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertTrue(world.isLimPos(new Point(8, 8)));
        assertFalse(world.isLimPos(new Point(5, 5)));
    }

    @Test
    void areEqualCreatureAArrays() {
        CreatureA[] array1 = 
        {
            new CreatureA(behaviorA, positionA, orientationA, chromosomeA),
            new CreatureA(behaviorA, positionA, orientationA, chromosomeA),
            new CreatureA(behaviorA, positionA, orientationA, chromosomeA)
        };

        CreatureA[] array2 = 
        {
            new CreatureA(behaviorA, positionA, orientationA, chromosomeA),
            new CreatureA(behaviorA, positionA, orientationA, chromosomeA),
            new CreatureA(behaviorA, positionA, orientationA, chromosomeA)
        };

        assertTrue(World.areEqualCreatureAArrays(array1, array2));
    }

    @Test
    void areEqualCreatureBArrays() 
    {
        CreatureB[] array1 = 
        {
            new CreatureB(behaviorB, positionB, orientationB),
            new CreatureB(behaviorB, positionB, orientationB),
            new CreatureB(behaviorB, positionB, orientationB)
        };

        CreatureB[] array2 =
        {
            new CreatureB(behaviorB, positionB, orientationB),
            new CreatureB(behaviorB, positionB, orientationB),
            new CreatureB(behaviorB, positionB, orientationB)
        };

        assertTrue(World.areEqualCreatureBArrays(array1, array2));
    }
    
    @Test
    void isFree() 
    {
        CreatureA[] populationA = {};
        CreatureB[] populationB = {};
        World world = new World(10, 20, populationA, populationB);

        assertTrue(world.isFree(new Point(5, 5)));

        CreatureA creatureA = new CreatureA(new BehaviorA(), new Point(5, 5), Orientation.east(), new Chromosome(new int[]{1, 2, 3}));
        world = new World(10, 20, new CreatureA[]{creatureA}, populationB);

        assertFalse(world.isFree(new Point(5, 5)));
    }
    
    
    BehaviorA behaviorA = new BehaviorA();
    Chromosome chromosomeA = new Chromosome(null);
    Point positionA = new Point(2, 3);
    Orientation orientationA = Orientation.north();

    BehaviorB behaviorB = new BehaviorB();
    Point positionB = new Point(5, 7);
    Orientation orientationB = Orientation.south();
}