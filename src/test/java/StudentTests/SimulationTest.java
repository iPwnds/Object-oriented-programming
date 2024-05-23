package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Simulation;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

	private int worldSize = 10;
	private int shelterCount = 5;
	private int inhabitantsPerShelter = 20;
	private int huntersPerShelter = 3;
	
	private Simulation simulation = new Simulation(worldSize, shelterCount, inhabitantsPerShelter, huntersPerShelter);
	
	@Test
    public void testSimulationConstructor() {
        assertEquals(worldSize, simulation.getWorldSize());
        assertEquals(shelterCount, simulation.getShelterCount());
        assertEquals(inhabitantsPerShelter * shelterCount, simulation.getPreyCount());
        assertEquals(inhabitantsPerShelter, simulation.getInhabitantsPerShelter());
        assertEquals(huntersPerShelter, simulation.getHuntersPerShelter());
    }

    @Test
    public void testGetWorld() {
        assertNotNull(simulation.getWorld());
    }

    @Test
    public void testGetWorldSize() {
        assertEquals(worldSize, simulation.getWorldSize());
    }

    @Test
    public void testGetShelterCount() {
        assertEquals(shelterCount, simulation.getShelterCount());
    }

    @Test
    public void testGetPreyCount() {
        assertEquals(inhabitantsPerShelter * shelterCount, simulation.getPreyCount());
    }

    @Test
    public void testGetInhabitantsPerShelter() {
        assertEquals(inhabitantsPerShelter, simulation.getInhabitantsPerShelter());
    }

    @Test
    public void testGetHuntersPerShelter() {
        assertEquals(huntersPerShelter, simulation.getHuntersPerShelter());
    }
    
    @Test
    public void testNextGeneration() {
        // Call nextGeneration method
        simulation.nextGeneration();

        // Assert that the world has been updated
        assertNotNull(simulation.getWorld());
    }

}
