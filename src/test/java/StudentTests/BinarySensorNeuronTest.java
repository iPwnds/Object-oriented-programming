package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.neuralnet.ActivationFunctionNeuron;
import sim.neuralnet.BinarySensorNeuron;
import util.Orientation;
import util.Point;
import sim.entities.World;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class BinarySensorNeuronTest {

	private World world = new World(10, 10);
	private Chromosome chromosome = new Chromosome(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
	private Point position = new Point(0, 0);
	private Orientation orientation = new Orientation(0);
	private Shelter shelter = world.createShelter(position, orientation);
	private Prey prey = world.createPrey(shelter, chromosome, position, orientation);
	
    @Test
    public void testComputeOutput_DetectionTrue() {
    	BinarySensorNeuron neuron = new BinarySensorNeuronDetectsTrue();
    	
    	int result = neuron.computeOutput(prey);
    	
    	assertEquals(750, result);
    }

    @Test
    public void testComputeOutput_DetectionFalse() {
    	BinarySensorNeuron neuron = new BinarySensorNeuronDetectsFalse();
    	
    	int result = neuron.computeOutput(prey);
    	
    	assertEquals(-750, result);
    }
    
    private class BinarySensorNeuronDetectsTrue extends BinarySensorNeuron {
        @Override
        public boolean detect(Prey prey) {
            return true;
        }
    }

    private class BinarySensorNeuronDetectsFalse extends BinarySensorNeuron {
        @Override
        public boolean detect(Prey prey) {
            return false;
        }
    }
    
}
