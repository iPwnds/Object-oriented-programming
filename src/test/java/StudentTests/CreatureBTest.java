package StudentTests;

import org.junit.jupiter.api.Test;

import sim1.BehaviorA;
import sim1.BehaviorB;
import sim1.Chromosome;
import sim1.CreatureA;
import sim1.CreatureB;
import sim1.World;
import util.Orientation;
import util.Point;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


class CreatureBTest 
{	
    @Test
    void moveForward() 
    {
        BehaviorB behavior = new BehaviorB();
        CreatureB creatureB = new CreatureB(behavior, new Point(0, 0), Orientation.east());
        
        CreatureA[] populationA = new CreatureA[0];
    	CreatureB[] populationB = new CreatureB[0];

    	World world = new World(10, 10, populationA, populationB);

        creatureB.moveForward(world);

        assertEquals(new Point(1, 0), creatureB.getPosition());
    }
    
    @Test
    void performAction() 
	{
        BehaviorA behavior = new BehaviorA();

        int[] weights = {1, 2, 3};
        Chromosome chromosome = new Chromosome(weights);

        Point position = new Point(5, 5);
        Orientation orientation = Orientation.north();
        CreatureA creatureA = new CreatureA(behavior, position, orientation, chromosome);

        CreatureA[] populationA = new CreatureA[0];
        CreatureB[] populationB = new CreatureB[0];
        World world = new World(10, 10, populationA, populationB);

        creatureA.performAction(world);

        assertNotNull(world);
    }

    @Test
    void isEqual() 
    {
        int[] weights1 = {1, 2, 3};
        int[] weights2 = {1, 2, 3};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome1.isEqual(chromosome2), "isEqual should return true for equal chromosomes");
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
}
