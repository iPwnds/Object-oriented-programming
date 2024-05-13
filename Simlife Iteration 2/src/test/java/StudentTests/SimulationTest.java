package StudentTests;

import org.junit.jupiter.api.Test;

import sim.Chromosome;
import sim.Creature;
import sim.Simulation;
import sim.World;
import sim.behaviors.Behavior;
import sim.behaviors.NeuralNetworkBehavior;
import sim.naturalselection.NaturalSelection;
import util.Point;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

class SimulationTest {
	
    @Test
    void testConstructorAndGetters() {
        // Test constructor and getters
        NaturalSelection nsel = new MockNaturalSelection();
        Simulation simulation = new Simulation(10, 5, nsel);
        assertNotNull(simulation.getNaturalSelection());
        assertEquals(nsel, simulation.getNaturalSelection());
        assertEquals(5, simulation.getPopulationSize());
        assertNotNull(simulation.getWorld());
    }

    @Test
    void testCreateRandWorldWith() {
        // Test createRandWorldWith method
        Behavior[] behaviors = {
                new NeuralNetworkBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24})),
                new NeuralNetworkBehavior(new Chromosome(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48})),
                new NeuralNetworkBehavior(new Chromosome(new int[]{49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72}))
        };
        World world = Simulation.createRandWorldWith(10, 3, behaviors);
        assertNotNull(world);
        assertEquals(3, world.getPopulation().length);
        for (Creature creature : world.getPopulation()) {
            assertTrue(Arrays.asList(behaviors).contains(creature.getBehavior()));
            assertTrue(Point.isWithin(creature.getPosition(), 10, 10));
        }
    }

    @Test
    void testCreateInitWorldNeuralnets() {
        // Test createInitWorldNeuralnets method
        World world = Simulation.createInitWorldNeuralnets(10, 5);
        assertNotNull(world);
        assertEquals(5, world.getPopulation().length);
        for (Creature creature : world.getPopulation()) {
            assertTrue(creature.getBehavior() instanceof NeuralNetworkBehavior);
            assertTrue(Point.isWithin(creature.getPosition(), 10, 10));
        }
    }

    @Test
    void testNextGeneration() {
        // Test nextGeneration method
        NaturalSelection nsel = new MockNaturalSelection();
        Simulation simulation = new Simulation(10, 5, nsel);
        simulation.nextGeneration();
        assertNotNull(simulation.getWorld());
    }

    // MockNaturalSelection class for testing
 	public class MockNaturalSelection implements NaturalSelection {

 		@Override
 		public boolean survives(World world, Point position) {
 			return false;
 		}
 	}
}

