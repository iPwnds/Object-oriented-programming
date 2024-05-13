package StudentTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.behaviors.ImmobileBehavior;
import util.Color;
import util.Orientation;
import util.Point;

class ImmobileBehaviorTest {

    @Test
    void testConstructorAndGetters() {
        // Test constructor and getters
        Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24});
        ImmobileBehavior immobileBehavior = new ImmobileBehavior(chromosome);
        assertEquals(Color.WHITE, immobileBehavior.getColor());
        assertEquals(chromosome, immobileBehavior.getChromosome());
    }

    @Test
    void testApplyBehavior() {
        // Test applyBehavior method
        
        // Create a world
        World world = new World(10, 10, new Creature[0]);
        
        // Create a creature
        Chromosome chromosome = new Chromosome(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        ImmobileBehavior immobileBehavior = new ImmobileBehavior(chromosome);
        Creature creature = new Creature(immobileBehavior, new Point(5, 5), Orientation.north());
        
        // Save the creature's original position and orientation
        Point originalPosition = creature.getPosition();
        
        // Apply the behavior
        immobileBehavior.applyBehavior(world, creature);
        
        // Ensure that the creature's position and orientation remain unchanged
        assertEquals(originalPosition, creature.getPosition());
    }

    @Test
    void testCopyWithChromosome() {
        // Test copyWithChromosome method
        
        // Create a chromosome
        Chromosome originalChromosome = new Chromosome(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        
        // Create an ImmobileBehavior with the original chromosome
        ImmobileBehavior originalBehavior = new ImmobileBehavior(originalChromosome);
        
        // Create a new chromosome
        Chromosome newChromosome = new Chromosome(new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255});
        
        // Copy the original behavior with the new chromosome
        ImmobileBehavior newBehavior = originalBehavior.copyWithChromosome(newChromosome);
        
        // Ensure the new behavior has the new chromosome
        assertEquals(newChromosome, newBehavior.getChromosome());
    }
}
