package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.neuralnet.BinarySensorNeuron;
import util.Orientation;
import util.Point;
import sim.entities.World;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySensorNeuronTest {

    @Test
    public void testComputeOutput_DetectionTrue() {
    	World world = new World(10, 10);
    	Chromosome chromosome = new Chromosome(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
    	Point position = new Point(0, 0);
    	Orientation orientation = new Orientation(0);
    	Shelter shelter = world.createShelter(position, orientation);
    	Prey prey = world.createPrey(shelter, chromosome, position, orientation);
    	
        BinarySensorNeuron neuron = new BinarySensorNeuronDetectsTrue();
        
        int result = neuron.computeOutput(prey);

        assertEquals(750, result);
    }

    @Test
    public void testComputeOutput_DetectionFalse() {
    	World world = new World(10, 10);
    	Chromosome chromosome = new Chromosome(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
    	Point position = new Point(0, 0);
    	Orientation orientation = new Orientation(0);
    	Shelter shelter = world.createShelter(position, orientation);
    	Prey prey = world.createPrey(shelter, chromosome, position, orientation);
    	
        BinarySensorNeuron neuron = new BinarySensorNeuronDetectsFalse();

        int result = neuron.computeOutput(prey);
        
        assertEquals(-750, result);
    }
    
    
    class BinarySensorNeuronDetectsTrue extends BinarySensorNeuron {
        @Override
        public boolean detect(Prey prey) {
            return true;
        }
    }

    class BinarySensorNeuronDetectsFalse extends BinarySensorNeuron {
        @Override
        public boolean detect(Prey prey) {
            return false;
        }
    }
    
}
