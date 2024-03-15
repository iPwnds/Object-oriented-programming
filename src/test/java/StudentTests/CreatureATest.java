package StudentTests;

import org.junit.jupiter.api.Test;

import sim1.BehaviorA;
import sim1.Chromosome;
import sim1.CreatureA;
import sim1.CreatureB;
import sim1.World;
import util.Orientation;
import util.Point;
import util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreatureATest 
{
    @Test
    void isEqual() 
    {
        BehaviorA behavior = new BehaviorA();
        Point position = new Point(5, 5);
        Orientation orientation = Orientation.east();
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3});
        CreatureA creatureA1 = new CreatureA(behavior, position, orientation, chromosome);
        CreatureA creatureA2 = new CreatureA(behavior, position, orientation, chromosome);

        assertTrue(creatureA1.isEqual(creatureA2));
    }
}