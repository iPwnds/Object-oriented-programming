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
import util.Vector;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreatureATest 
{
	@Test
    void moveForward() 
	{
        BehaviorA behavior = new BehaviorA();

        int[] weights = {1, 2, 3, 4, 5, 6};
        Chromosome chromosome = new Chromosome(weights);

        Point position = new Point(5, 5);
        Orientation orientation = Orientation.north();
        CreatureA creatureA = new CreatureA(behavior, position, orientation, chromosome);

        Vector drift = new Vector(1, 0);

        creatureA.moveForward(new World(10, 10, new CreatureA[0], new CreatureB[0]), drift);

        Point expectedPosition = position.move(orientation.toVector()).move(drift);

        assertEquals(expectedPosition, creatureA.getPosition());

        assertEquals(orientation, creatureA.getOrientation());
    }
	
	@Test
    void performAction() 
	{
        BehaviorA behavior = new BehaviorA();

        int[] weights = {1, 2, 3, 4, 5, 6};
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
        int[] weights1 = {1, 2, 3, 4, 5, 6};
        int[] weights2 = {1, 2, 3, 4, 5, 6};
        Chromosome chromosome1 = new Chromosome(weights1);
        Chromosome chromosome2 = new Chromosome(weights2);

        assertTrue(chromosome1.isEqual(chromosome2));
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