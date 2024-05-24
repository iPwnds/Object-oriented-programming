package other;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Simulation;
import sim.entities.Hunter;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.entities.World;
import sim.neuralnet.ActivationFunctionNeuron;
import sim.neuralnet.HunterSensor;
import sim.neuralnet.NeuralNetwork;
import sim.neuralnet.Neuron;
import sim.neuralnet.SensorNeuron;
import util.Orientation;
import util.Pair;
import util.Point;

/**
 * All flaw detecting tests should go in here
 */
class FlawDetectingTests {

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
	
	private ActivationFunctionNeuron neuron;

    @BeforeEach
    public void setUp() {
        neuron = new ActivationFunctionNeuron() {
            @Override
            public int applyActivationFunction(int input) {
                // Dummy activation function for testing
                return input > 0 ? 1 : 0;
            }
        };
    }
    
    @Test
	void performActionTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(1,1);
		Orientation orientation = Orientation.createRandom();
		Hunter hunter = world.createHunter(shelter, point, orientation);
		Prey closestPrey = world.createPrey(shelter, Chromosome.createRandom(), new Point(3,3), Orientation.createRandom());
		Prey fartestPrey = world.createPrey(shelter, Chromosome.createRandom(), new Point(6,1), Orientation.createRandom());
		hunter.performAction();
		assertEquals(Orientation.fromVector(hunter.getPosition().vectorTo(closestPrey.getPosition())), hunter.getOrientation());
		assertNotEquals(Orientation.fromVector(hunter.getPosition().vectorTo(fartestPrey.getPosition())), hunter.getOrientation());
		hunter.setAppetite(1);
		Point oldpos = hunter.getPosition();
		hunter.performAction();
		assertTrue(hunter.getPosition().equals(oldpos));
	}
    
    @Test 
	void dieTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point =  new Point(2,2);
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(),point, Orientation.createRandom());
		
		prey.die();
		assertEquals(null, world.getEntityAt(point));
		Point point1 =  new Point(3,2);
		Prey prey1 = world.createPrey(shelter, Chromosome.createRandom(),point1, Orientation.createRandom());
		Point point2 =  new Point(2,5);
		Prey prey2 = world.createPrey(shelter, Chromosome.createRandom(),point2, Orientation.createRandom());
		prey1.die();
		assertFalse(prey2.getSiblings().contains(prey1));
	}
    
    @Test
    public void testSurvives() {
		World world = new World(100, 100);
		Shelter shelter = world.createShelter(new Point(1, 1), Orientation.createRandom());
		Point point = new Point(5, 5);
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), point, Orientation.createRandom());
		prey.performActionIfAlive();
		assertTrue(prey.survives());
	}
    
    @Test
    public void testDistanceSquaredToShelter() {
		World world = new World(100, 100);
		Shelter shelter = world.createShelter(new Point(1, 1), Orientation.createRandom());
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), new Point(5, 5) , Orientation.createRandom());
		assertEquals(prey.distanceSquaredToShelter(), 32);
    }
        
    @SuppressWarnings("unused")
    private boolean unfairBoolResult;
    @SuppressWarnings("unused")
	private boolean boolResult;
    
    private Orientation orientationAssert;

    private World world = new World(10, 10);
    private Chromosome chromosome = new Chromosome(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
    private Point position = new Point(1, 1);
    private Orientation orientation = Orientation.north();
    private Shelter shelter = world.createShelter(position, orientation);
    private Prey prey = world.createPrey(shelter, chromosome, position, orientation);

    @Test
    void testPerformActionIfAliveTurn() {
        shelter.addInhabitant(prey);
        
        this.unfairBoolResult = true;
        this.boolResult = true;

        shelter.performActionIfAlive();
        
        if (shelter.getOrientation() == Orientation.northEast()) {
        	orientationAssert = Orientation.northEast();
        }
        else if (shelter.getOrientation() == Orientation.northWest()) {
        	orientationAssert = Orientation.northWest();
        }
        else {
        	orientationAssert = Orientation.north();
        }
        
        assertEquals(orientationAssert, shelter.getOrientation());
    }

    @Test
    void testPerformActionIfAliveMoveForward() {
        shelter.addInhabitant(prey);

        this.unfairBoolResult = true;

        Point initialPosition = shelter.getPosition();
        shelter.performActionIfAlive();
        assertEquals(initialPosition, shelter.getPosition());
    }
	
	@Test
    public void testSetAndGetDependencies() {
        // Test setting and getting dependencies
        ArrayList<Pair<Neuron, Integer>> dependencies = new ArrayList<>();
        
        DummyNeuron dummy1 = new DummyNeuron();
        DummyNeuron dummy2 = new DummyNeuron();
        
        dependencies.add(new Pair<>(dummy1, 1));
        dependencies.add(new Pair<>(dummy2, -1));
        
        neuron.setDependencies(dependencies);
        List<Pair<Neuron, Integer>> retrievedDependencies = neuron.getDependencies();
        
        assertEquals(dependencies.size(), retrievedDependencies.size());
        for (int i = 0; i < dependencies.size(); i++) {
            assertEquals(dependencies.get(i).getFirst(), retrievedDependencies.get(i).getFirst());
            assertEquals(dependencies.get(i).getSecond(), retrievedDependencies.get(i).getSecond());
        }
    }

    @Test
    public void testConnect() {
        // Test connecting a dependency
        assertTrue(neuron.connect(new DummyNeuron(), 1));
        assertEquals(1, neuron.getDependencies().size());
        
        // Test reaching maximum number of dependencies
        for (int i = 0; i < 6; i++) {
            assertTrue(neuron.connect(new DummyNeuron(), 1));
        }
        
        assertTrue(neuron.connect(new DummyNeuron(), 1));
    }
    
    private static class DummyNeuron implements Neuron {
        @Override
        public int computeOutput(Prey prey) {
            return 1; // Dummy output for testing
        }
    }
    
    private World worldHunter = new MockWorldWithHunter(10, 10);
    private Prey preyHunter = worldHunter.createPrey(shelter, chromosome, position, orientation);
    
    @Test
    public void testDetect() {
        HunterSensor sensor = new HunterSensor();

        // Act
        boolean detected = sensor.detect(preyHunter);

        // Assert
        assertTrue(detected);
    }
    
    @SuppressWarnings("unused")
	private class MockWorldWithHunter extends World {
		public MockWorldWithHunter(int width, int height) {
			super(width, height);
		}

		@Override
        public boolean hasHunterInCone(Point position, Orientation orientation) {
            // Assuming there is a hunter in cone for testing
            return true;
        }
    }
    
	@Test
	public void testGetInputNeurons() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        SensorNeuron[] inputNeurons = neuralNetwork.getInputNeurons();
        
        assertNotNull(inputNeurons);
        assertEquals(5, inputNeurons.length);
        for (SensorNeuron neuron : inputNeurons) {
            assertNotNull(neuron);
        }
    }
    
    @Test
    public void testGetOutputNeurons() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        ActivationFunctionNeuron[] outputNeurons = neuralNetwork.getOutputNeurons();
        
        assertNotNull(outputNeurons);
        assertEquals(2, outputNeurons.length);
        assertNotNull(outputNeurons[0]);
        assertNotNull(outputNeurons[1]);
    }
    
    @Test
    public void testGetMoveForwardNeuron() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        ActivationFunctionNeuron moveForwardNeuron = neuralNetwork.getMoveForwardNeuron();
        
        assertNotNull(moveForwardNeuron);
    }
    
    @Test
    public void testGetTurnNeuron() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        ActivationFunctionNeuron turnNeuron = neuralNetwork.getTurnNeuron();
        
        assertNotNull(turnNeuron);
    }
    
}
