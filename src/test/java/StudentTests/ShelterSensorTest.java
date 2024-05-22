package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.entities.World;
import sim.neuralnet.ShelterSensor;
import util.Orientation;
import util.Point;

public class ShelterSensorTest {

	World world = new World(10, 10);
    Chromosome chromosome = new Chromosome(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
    Point preyPosition = new Point(1, 1);
    Point shelterPosition = new Point(3, 3);
    Orientation orientation = new Orientation(0);
    Shelter shelter = world.createShelter(shelterPosition, orientation);
    Prey prey = world.createPrey(shelter, chromosome, preyPosition, orientation);

    ShelterSensor sensor = new ShelterSensor();

    @Test
    public void testDetectWhenOrientationMatches() {
        // Adjust the prey's orientation to match the vector to the shelter
        Orientation correctOrientation = preyPosition.vectorTo(shelterPosition).toClosestOrientation();
        prey.setOrientation(correctOrientation);

        // Call the method under test
        boolean result = sensor.detect(prey);

        // Assert the result
        assertTrue(result);
    }

    @Test
    public void testDetectWhenOrientationDoesNotMatch() {
        // Set the prey's orientation to a different orientation        
        Orientation wrongOrientation = (preyPosition.vectorTo(shelterPosition).toClosestOrientation()).turnClockwise(2);
        prey.setOrientation(wrongOrientation);

        // Call the method under test
        boolean result = sensor.detect(prey);

        // Assert the result
        assertFalse(result);
    }

}
