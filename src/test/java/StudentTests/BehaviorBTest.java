package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim1.BehaviorB;
import sim1.CreatureA;
import sim1.CreatureB;
import sim1.World;
import util.Orientation;
import util.Point;


class BehaviorBTest 
{
    @Test
    void applyBehavior() 
    {
        // Create a dummy creature
        CreatureB creature = createDummyCreatureB();

        // Create a BehaviorB object
        BehaviorB behaviorB = new BehaviorB();

        // Apply behavior on the dummy CreatureB object
        behaviorB.applyBehavior(createDummyWorld(), creature);

        // Assertions
        assertNotNull(creature.getPosition(), "Creature position should not be null after applying behavior");
        assertNotNull(creature.getOrientation(), "Creature orientation should not be null after applying behavior");
    }

    private CreatureB createDummyCreatureB() 
    {
    	Point point = new Point(0, 0);
        Orientation orientation = Orientation.north();
        return new CreatureB(new BehaviorB(), point, orientation);
    }

    private World createDummyWorld() 
    {
        CreatureA[] populationA = new CreatureA[0];
        CreatureB[] populationB = new CreatureB[1];
        int width = 100;
        int height = 100;
        return new World(width, height, populationA, populationB);
    }
}