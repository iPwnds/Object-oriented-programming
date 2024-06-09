package StudentTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sim.entities.Shelter;
import sim.entities.World;
import util.Color;
import util.Orientation;
import util.Point;

public class ShelterTest {
	
	@Test
	public void getColor() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		assertEquals(shelter.getColor(), Color.BLACK);
	}
	
}
