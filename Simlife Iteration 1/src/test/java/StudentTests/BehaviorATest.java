package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim1.BehaviorA;
import sim1.Chromosome;
import sim1.CreatureA;
import sim1.CreatureB;
import sim1.World;
import util.Orientation;
import util.Point;


class BehaviorATest 
{
	@Test
    void applyBehavior() 
	{
		// Create a dummy creature
        CreatureA creature = createDummyCreatureA();

        // Create a BehaviorA object
        BehaviorA behaviorA = new BehaviorA();

        // Apply behavior on the dummy CreatureA object
        behaviorA.applyBehavior(createDummyWorld(), creature);

        // Assertions
        assertNotNull(creature.getPosition());
        assertNotNull(creature.getOrientation());
    }

    private CreatureA createDummyCreatureA() 
    {
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6});

        BehaviorA behaviorA = new BehaviorA();
        Point point = new Point(0, 0);
        Orientation orientation = Orientation.north();

        return new CreatureA(behaviorA, point, orientation, chromosome);
    }

    private World createDummyWorld() 
    {
        CreatureA[] populationA = new CreatureA[1];
        CreatureB[] populationB = new CreatureB[0];

        int width = 100;
        int height = 100;

        return new World(width, height, populationA, populationB);
    }
}
