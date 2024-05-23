package StudentTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sim.Chromosome;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.entities.World;
import sim.neuralnet.HunterSensor;
import util.Orientation;
import util.Point;

public class HunterSensorTest {

	private World world = new World(10, 10);
	private Chromosome chromosome = new Chromosome(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
	private Point position = new Point(1, 1);
	private Orientation orientation = new Orientation(0);
	private Shelter shelter = world.createShelter(position, orientation);
	private Prey prey = world.createPrey(shelter, chromosome, position, orientation);

	private HunterSensor sensor = new HunterSensor();

	@Test
	public void testDetect() {
		// Call the method under test
		boolean result = sensor.detect(prey);

		// Assert the result
		assertFalse(result);
	}

}
