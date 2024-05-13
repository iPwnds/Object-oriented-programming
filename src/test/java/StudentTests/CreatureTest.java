package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim.behaviors.Behavior;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import util.Orientation;
import util.Point;
import util.Vector;

public class CreatureTest {

    @Test
    public void testConstructorAndGetters() {
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        Creature creature = new Creature(behavior, position, orientation);
        
        assertEquals(behavior, creature.getBehavior());
        assertEquals(position, creature.getPosition());
        assertEquals(orientation, creature.getOrientation());
    }

    @Test
    public void testMoveForward() {
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        Creature creature = new Creature(behavior, position, orientation);
        World world = new World(10, 10, new Creature[0]);
        Vector drift = new Vector(1, 0);
        
        creature.moveForward(world, drift);
        
        //assertEquals(new Point(1, 0), creature.getPosition());
    }

    @Test
    public void testTurnClockwise() {
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        Creature creature = new Creature(behavior, position, orientation);
        
        creature.turnClockwise();
        
        assertEquals(Orientation.southEast(), creature.getOrientation());
    }

    @Test
    public void testTurnCounterclockwise() {
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        Creature creature = new Creature(behavior, position, orientation);
        
        creature.turnCounterclockwise();
        
        assertEquals(Orientation.northEast(), creature.getOrientation());
    }

    @Test
    public void testPerformAction() {
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        Creature creature = new Creature(behavior, position, orientation);
        World world = new World(10, 10, new Creature[0]);
        
        creature.performAction(world);
    }

    @Test
    public void testIsEqual() {
        Behavior behavior1 = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position1 = new Point(0, 0);
        Orientation orientation1 = Orientation.east();
        Creature creature1 = new Creature(behavior1, position1, orientation1);
        
        Behavior behavior2 = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position2 = new Point(0, 0);
        Orientation orientation2 = Orientation.east();
        Creature creature2 = new Creature(behavior2, position2, orientation2);
        
        assertTrue(creature1.isEqual(creature2));
    }

    @Test
    public void testGiveCopy() {
        Behavior behavior = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        Point position = new Point(0, 0);
        Orientation orientation = Orientation.east();
        Creature creature = new Creature(behavior, position, orientation);
        
        Creature copy = creature.giveCopy();
        
        assertEquals(creature.getBehavior(), copy.getBehavior());
        assertEquals(creature.getPosition(), copy.getPosition());
        assertEquals(creature.getOrientation(), copy.getOrientation());
        assertEquals(creature.getChromosome(), copy.getChromosome());
    }
    
    // Helper class for testing
    private static class TestBehavior extends Behavior {
        public TestBehavior(Chromosome chromosome) {
            super(chromosome);
        }

        @Override
        public void applyBehavior(World world, Creature creature) {

        }

        @Override
        public util.Color getColor() {
            // Dummy implementation
            return null;
        }

        @Override
        public Behavior copyWithChromosome(Chromosome chromosome) {
            // Dummy implementation
            return null;
        }
    }
}
