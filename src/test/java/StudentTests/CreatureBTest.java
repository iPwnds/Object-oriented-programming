package StudentTests;

import org.junit.jupiter.api.Test;
import sim1.BehaviorB;
import sim1.CreatureA;
import sim1.CreatureB;
import sim1.World;
import util.Orientation;
import util.Point;
import static org.junit.jupiter.api.Assertions.*;


class CreatureBTest 
{	
    @Test
    void moveForward() {
        BehaviorB behavior = new BehaviorB();
        CreatureB creatureB = new CreatureB(behavior, new Point(0, 0), Orientation.east());
        
        CreatureA[] populationA = new CreatureA[0];
    	CreatureB[] populationB = new CreatureB[0];

    	World world = new World(10, 10, populationA, populationB);

        creatureB.moveForward(world);

        assertEquals(new Point(1, 0), creatureB.getPosition());
    }

    @Test
    void isEqual() {
        BehaviorB behavior = new BehaviorB();
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        CreatureB creatureB1 = new CreatureB(behavior, position, orientation);
        CreatureB creatureB2 = new CreatureB(behavior, position, orientation);

        assertTrue(creatureB1.isEqual(creatureB2));
    }

    @Test
    void giveCopy() {
        BehaviorB behavior = new BehaviorB();
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        CreatureB creatureB = new CreatureB(behavior, position, orientation);

        CreatureB copy = creatureB.giveCopy();

        assertEquals(creatureB.getPosition(), copy.getPosition());
        assertEquals(creatureB.getOrientation(), copy.getOrientation());
    }
}
