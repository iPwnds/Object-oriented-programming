package StudentTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sim.behaviors.BehaviorB;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Color;
import util.Point;
import util.Orientation;

class BehaviorBTest {

    @Test
    void testConstructorAndGetters() {
        // Test constructor and getters
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        BehaviorB behaviorB = new BehaviorB(chromosome);
        assertEquals(Color.BLUE, behaviorB.getColor());
        assertEquals(chromosome, behaviorB.getChromosome());
    }

    @Test
    void testApplyBehavior() {
        // Test applyBehavior method
        
        // Create a world
        World world = new World(10, 10, new Creature[0]);
        
        // Create a creature
        Chromosome chromosome = new Chromosome(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        BehaviorB behaviorB = new BehaviorB(chromosome);
        Creature creature = new Creature(behaviorB, new Point(5, 5), Orientation.north());
        
        // Test behavior when the creature is not at the edge of the world
        behaviorB.applyBehavior(world, creature);
        assertFalse(world.isLimPos(creature.getPosition()));
    }

    @Test
    void testCopyWithChromosome() {
        // Test copyWithChromosome method
        
        // Create a chromosome
        Chromosome originalChromosome = new Chromosome(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        
        // Create a behavior with the original chromosome
        BehaviorB originalBehaviorB = new BehaviorB(originalChromosome);
        
        // Create a new chromosome
        Chromosome newChromosome = new Chromosome(new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255});
        
        // Copy the original behavior with the new chromosome
        BehaviorB newBehaviorB = originalBehaviorB.copyWithChromosome(newChromosome);
        
        // Ensure the new behavior has the new chromosome
        assertEquals(newChromosome, newBehaviorB.getChromosome());
    }
}

