package StudentTests;

import org.junit.jupiter.api.Test;

import sim.neuralnet.RectifiedLinearUnitFunctionNeuron;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectifiedLinearUnitFunctionNeuronTest {

    @Test
    void testApplyActivationFunction_InputWithinRange() {
        RectifiedLinearUnitFunctionNeuron neuron = new RectifiedLinearUnitFunctionNeuron();
        int input = 500; // Input value within the valid range
        int expectedOutput = 500; // ReLU of input should be the same as input
        int actualOutput = neuron.applyActivationFunction(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testApplyActivationFunction_InputBelowRange() {
        RectifiedLinearUnitFunctionNeuron neuron = new RectifiedLinearUnitFunctionNeuron();
        int input = -1000; // Input value below the valid range
        int expectedOutput = -500; // ReLU of input should be clipped to the minimum value
        int actualOutput = neuron.applyActivationFunction(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testApplyActivationFunction_InputAboveRange() {
        RectifiedLinearUnitFunctionNeuron neuron = new RectifiedLinearUnitFunctionNeuron();
        int input = 1500; // Input value above the valid range
        int expectedOutput = 1000; // ReLU of input should be clipped to the maximum value
        int actualOutput = neuron.applyActivationFunction(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
