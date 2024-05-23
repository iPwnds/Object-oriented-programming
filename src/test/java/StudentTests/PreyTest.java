package StudentTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import sim.Chromosome;
import sim.Constants;
import sim.entities.Hunter;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.entities.World;
import util.Color;
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
		Point point1 =  new Point(3,2);
		Prey prey1 = world.createPrey(shelter, Chromosome.createRandom(),point1, Orientation.createRandom());
		Point point2 =  new Point(2,5);
		Prey prey2 = world.createPrey(shelter, Chromosome.createRandom(),point2, Orientation.createRandom());
		prey1.die();
		assertFalse(prey2.getSiblings().contains(prey1));
	}
	@Test
	void getColorTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(2,2);
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(),point, Orientation.createRandom());
		assertEquals(prey.getColor(), Color.GREEN);
	}

	@Test
	void performActionIfAliveTest() {
		World world = new World(10, 10);
		Shelter shelter = world.createShelter(new Point(1, 1), Orientation.createRandom());
		Point point = new Point(5, 5);
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), point, Orientation.createRandom());
		int initialScore = prey.getScore();
		prey.performActionIfAlive();

		assertNotEquals(initialScore, prey.getScore()); 
		int distanceSquared = prey.distanceSquaredToShelter();
		if (distanceSquared < Constants.SHELTER_SURVIVAL_DISTANCE * Constants.SHELTER_SURVIVAL_DISTANCE) {
			assertTrue(prey.getScore() > initialScore);
		} else {
			assertTrue(prey.getScore() < initialScore);
		}
	}
	
}
