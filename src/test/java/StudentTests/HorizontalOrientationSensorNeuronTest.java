package StudentTests;

import org.junit.jupiter.api.Test;

import sim.neuralnet.HorizontalOrientationSensorNeuron;

import static org.junit.jupiter.api.Assertions.*;

public class HorizontalOrientationSensorNeuronTest {

    @Test
    void testNorth() {
        HorizontalOrientationSensorNeuron neuron = new HorizontalOrientationSensorNeuron();
        assertEquals(0, neuron.north());
    }

    @Test
    void testNorthEast() {
        HorizontalOrientationSensorNeuron neuron = new HorizontalOrientationSensorNeuron();
        assertEquals(500, neuron.northEast());
    }

    @Test
    void testEast() {
        HorizontalOrientationSensorNeuron neuron = new HorizontalOrientationSensorNeuron();
        assertEquals(1000, neuron.east());
    }

    @Test
    void testSouthEast() {
        HorizontalOrientationSensorNeuron neuron = new HorizontalOrientationSensorNeuron();
        assertEquals(500, neuron.southEast());
    }

    @Test
    void testSouth() {
        HorizontalOrientationSensorNeuron neuron = new HorizontalOrientationSensorNeuron();
        assertEquals(0, neuron.south());
    }

    @Test
    void testSouthWest() {
        HorizontalOrientationSensorNeuron neuron = new HorizontalOrientationSensorNeuron();
        assertEquals(-500, neuron.southWest());
    }

    @Test
    void testWest() {
        HorizontalOrientationSensorNeuron neuron = new HorizontalOrientationSensorNeuron();
        assertEquals(-1000, neuron.west());
    }

    @Test
    void testNorthWest() {
        HorizontalOrientationSensorNeuron neuron = new HorizontalOrientationSensorNeuron();
        assertEquals(-500, neuron.northWest());
    }
}
