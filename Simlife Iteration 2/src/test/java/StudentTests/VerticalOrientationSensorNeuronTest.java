package StudentTests;

import org.junit.jupiter.api.Test;

import sim.neuralnet.VerticalOrientationSensorNeuron;

import static org.junit.jupiter.api.Assertions.*;

public class VerticalOrientationSensorNeuronTest {

    @Test
    void testNorth() {
        VerticalOrientationSensorNeuron neuron = new VerticalOrientationSensorNeuron();
        assertEquals(-1000, neuron.north());
    }

    @Test
    void testNorthEast() {
        VerticalOrientationSensorNeuron neuron = new VerticalOrientationSensorNeuron();
        assertEquals(-500, neuron.northEast());
    }

    @Test
    void testEast() {
        VerticalOrientationSensorNeuron neuron = new VerticalOrientationSensorNeuron();
        assertEquals(0, neuron.east());
    }

    @Test
    void testSouthEast() {
        VerticalOrientationSensorNeuron neuron = new VerticalOrientationSensorNeuron();
        assertEquals(500, neuron.southEast());
    }

    @Test
    void testSouth() {
        VerticalOrientationSensorNeuron neuron = new VerticalOrientationSensorNeuron();
        assertEquals(1000, neuron.south());
    }

    @Test
    void testSouthWest() {
        VerticalOrientationSensorNeuron neuron = new VerticalOrientationSensorNeuron();
        assertEquals(500, neuron.southWest());
    }

    @Test
    void testWest() {
        VerticalOrientationSensorNeuron neuron = new VerticalOrientationSensorNeuron();
        assertEquals(0, neuron.west());
    }

    @Test
    void testNorthWest() {
        VerticalOrientationSensorNeuron neuron = new VerticalOrientationSensorNeuron();
        assertEquals(-500, neuron.northWest());
    }
}
