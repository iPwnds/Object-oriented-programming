package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim.neuralnet.FreePassageSensorNeuron;
import util.Orientation;

public class FreePassageSensorNeuronTest {

    @Test
    public void testConstructorValidOrientation() {
        // Test with a valid orientation
        Orientation orientation = Orientation.north();
        FreePassageSensorNeuron neuron = new FreePassageSensorNeuron(orientation);
        
        assertEquals(orientation, neuron.getOrientation());
    }

    @Test
    public void testConstructorInvalidOrientation() {
        // Test with a null orientation (should throw IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> {
            new FreePassageSensorNeuron(null);
        });
    }

    @Test
    public void testGetOrientation() {
        // Test the getOrientation method
        Orientation orientation = Orientation.south();
        FreePassageSensorNeuron neuron = new FreePassageSensorNeuron(orientation);
        
        assertEquals(orientation, neuron.getOrientation());
    }
    
}
