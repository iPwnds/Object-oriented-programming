//package StudentTests;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//
//import StudentTests.BehaviorTest.TestBehavior;
//import sim.*;
//import sim.behaviors.Behavior;
//import util.Color;
//
//public class SimulationTest {
//
//    @Test
//    public void testCreateRandWorldWith() {
//        // Test parameters
//        int size = 10;
//        int popuSize = 5;
//        Behavior[] behaviors = new Behavior[popuSize];
//        for (int i = 0; i < popuSize; i++) {
//            behaviors[i] = new TestBehavior(new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}), null);
//        }
//
//        // Create a random world
//        World world = Simulation.createRandWorldWith(size, popuSize, behaviors);
//
//        // Assertions
//        assertNotNull(world);
//        assertEquals(popuSize, world.getPopulation().length);
//    }
//
//    @Test
//    public void testCreateInitWorldNeuralnets() {
//        // Test parameters
//        int size = 10;
//        int popuSize = 5;
//
//        // Create an initial world with neural network behaviors
//        World world = Simulation.createInitWorldNeuralnets(size, popuSize);
//
//        // Assertions
//        assertNotNull(world);
//        assertEquals(popuSize, world.getPopulation().length);
//    }
//
//    @Test
//    public void testNextGeneration() {
//        // Test parameters
//        int size = 10;
//        int popuSize = 5;
//        MockNaturalSelection nsel = new MockNaturalSelection();
//
//        // Create a simulation
//        Simulation simulation = new Simulation(size, popuSize, nsel);
//
//        // Test next generation
//        simulation.nextGeneration();
//
//        // Assertions
//        assertNotNull(simulation.getWorld());
//    }
//
//}
