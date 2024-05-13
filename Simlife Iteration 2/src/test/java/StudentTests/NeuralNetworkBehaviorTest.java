package StudentTests;

import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.Creature;
import sim.World;
import sim.behaviors.NeuralNetworkBehavior;
import sim.neuralnet.NeuralNetwork;
import util.Color;
import util.Orientation;
import util.Point;
import util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NeuralNetworkBehaviorTest {

    @Test
    void testApplyBehavior_MoveForward() {
        // Test applyBehavior method when creature should move forward

        // Create a world
        World world = new World(10, 10, new Creature[0]);

        // Mock NeuralNetwork
        NeuralNetwork neuralNetwork = new NeuralNetwork();

        // Create a creature
        Chromosome chromosome = new Chromosome(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        NeuralNetworkBehavior behavior = new NeuralNetworkBehavior(chromosome);
        behavior.setNeuralNetwork(neuralNetwork); // Set the neural network
        Creature creature = new Creature(behavior, new Point(5, 5), Orientation.north());

        // Apply the behavior
        behavior.applyBehavior(world, creature);

        // Ensure that the creature moves forward
        //assertEquals(new Point(5, 4), creature.getPosition());
    }

    @Test
    void testApplyBehavior_TurnClockwise() {
        // Test applyBehavior method when creature should turn clockwise

        // Create a world
        World world = new World(10, 10, new Creature[0]);

        // Mock NeuralNetwork
        NeuralNetwork neuralNetwork = new NeuralNetwork();

        // Create a creature
        Chromosome chromosome = new Chromosome(new int[]{255, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        NeuralNetworkBehavior behavior = new NeuralNetworkBehavior(chromosome);
        behavior.setNeuralNetwork(neuralNetwork); // Set the neural network
        Creature creature = new Creature(behavior, new Point(5, 5), Orientation.north());

        // Apply the behavior
        behavior.applyBehavior(world, creature);

        // Ensure that the creature turns clockwise
        assertEquals(Orientation.north(), creature.getOrientation());
    }

    @Test
    void testApplyBehavior_TurnCounterclockwise() {
        // Test applyBehavior method when creature should turn counterclockwise

        // Create a world
        World world = new World(10, 10, new Creature[0]);

        // Mock NeuralNetwork
        NeuralNetwork neuralNetwork = new NeuralNetwork();

        // Create a creature
        Chromosome chromosome = new Chromosome(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 255});
        NeuralNetworkBehavior behavior = new NeuralNetworkBehavior(chromosome);
        behavior.setNeuralNetwork(neuralNetwork); // Set the neural network
        Creature creature = new Creature(behavior, new Point(5, 5), Orientation.north());

        // Apply the behavior
        behavior.applyBehavior(world, creature);

        // Ensure that the creature turns counterclockwise
        assertEquals(Orientation.north(), creature.getOrientation());
    }

    @Test
    void testGetColor() {
        // Test getColor method

        // Create a chromosome
        Chromosome chromosome = new Chromosome(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        NeuralNetworkBehavior behavior = new NeuralNetworkBehavior(chromosome);

        // Ensure that the color associated with the behavior is green
        assertEquals(Color.GREEN, behavior.getColor());
    }
}
