package StudentTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import sim.Chromosome;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.entities.World;
import util.Orientation;
import util.Point;

public class PreyTest {
	@Test
	void issmthngPkgTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), new Point(2,2), Orientation.createRandom());
		assertFalse(prey.isHunter());
		assertFalse(prey.isShelter());
	}
	@Test 
	void dieTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point =  new Point(2,2);
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(),point, Orientation.createRandom());
		prey.die();
		assertEquals(null, world.getEntityAt(point));
	}
	
}
