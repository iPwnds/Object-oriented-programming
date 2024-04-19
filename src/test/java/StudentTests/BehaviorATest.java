package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.behaviors.BehaviorA;
import util.Color;
import util.Orientation;
import util.Point;

import static org.junit.jupiter.api.Assertions.*;

class BehaviorATest {

    @Test
    void testConstructorAndGetters() {
        // Test constructor and getters
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        BehaviorA behaviorA = new BehaviorA(chromosome);
        assertNotNull(behaviorA.getChromosome());
        assertEquals(chromosome, behaviorA.getChromosome());
    }

    @Test
    void testApplyBehavior() {
        // Test applyBehavior method
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        BehaviorA behaviorA = new BehaviorA(chromosome);
        World world = new World(10, 10, new Creature[0]);
        Point initialPosition = new Point(5, 5);
        Creature creature = new Creature(behaviorA, initialPosition, Orientation.north());
        behaviorA.applyBehavior(world, creature); // No assertion, just ensure no exception is thrown
    }

    @Test
    void testGetColor() {
        // Test getColor method
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        BehaviorA behaviorA = new BehaviorA(chromosome);
        assertEquals(Color.RED, behaviorA.getColor());
    }

    @Test
    void testComputeFavoriteOrientation() {
        // Test computeFavoriteOrientation method
        Chromosome chromosome1 = new Chromosome(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        BehaviorA behaviorA1 = new BehaviorA(chromosome1);
        assertEquals(Orientation.north(), behaviorA1.computeFavoriteOrientation());

        Chromosome chromosome2 = new Chromosome(new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255});
        BehaviorA behaviorA2 = new BehaviorA(chromosome2);
        assertEquals(Orientation.northWest(), behaviorA2.computeFavoriteOrientation());
    }

    @Test
    void testCopyWithChromosome() {
        // Test copyWithChromosome method
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        BehaviorA behaviorA = new BehaviorA(chromosome);
        Chromosome newChromosome = new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48});
        BehaviorA newBehaviorA = behaviorA.copyWithChromosome(newChromosome);
        assertNotNull(newBehaviorA);
        assertEquals(newChromosome, newBehaviorA.getChromosome());
    }

    @Test
    void testApplyBehaviorEdgeCases() {
        // Test applyBehavior method for edge cases
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        BehaviorA behaviorA = new BehaviorA(chromosome);
        World world = new World(10, 10, new Creature[0]);

        // Creature at edge of the world should not change position or orientation
        Point edgePosition = new Point(0, 0);
        Creature edgeCreature = new Creature(behaviorA, edgePosition, Orientation.north());
        behaviorA.applyBehavior(world, edgeCreature);
        assertEquals(edgePosition, edgeCreature.getPosition());
        assertEquals(Orientation.north(), edgeCreature.getOrientation());
    }
}
