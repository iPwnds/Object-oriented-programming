package StudentTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sim.Chromosome;
import sim.Constants;
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
	void getColorTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(2,2);
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(),point, Orientation.createRandom());
		assertEquals(prey.getColor(), Color.GREEN);
	}

	@Test
	void performActionIfAliveTest() {
		World world = new World(100, 100);
		Shelter shelter = world.createShelter(new Point(1, 1), Orientation.createRandom());
		Point point = new Point(5, 5);
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), point, Orientation.createRandom());
		Prey prey2 = world.createPrey(shelter, Chromosome.createRandom(), new Point(99,99), Orientation.createRandom());
		int initialScore = prey.getScore();
		prey.performActionIfAlive();
		prey2.performActionIfAlive();
		
		for(Prey prey0 : shelter.getInhabitants()) {
			int distanceSquared = prey0.distanceSquaredToShelter();
		if (distanceSquared < Constants.SHELTER_SURVIVAL_DISTANCE * Constants.SHELTER_SURVIVAL_DISTANCE) {
			assertTrue(prey0.getScore() > initialScore);
			assertTrue(prey0.survives());
		} else {
			assertTrue(prey0.getScore() < initialScore);
			assertFalse(prey0.survives());
		}

		}
		Prey prey3 = world.createPrey(shelter, Chromosome.createRandom(), new Point(99,99), Orientation.south());
		prey3.moveForward();
		assertTrue(prey3.getPosition().equals(new Point(99,99)));
		Prey prey4 = world.createPrey(shelter, Chromosome.createRandom(), new Point(99,98), Orientation.south());
		prey4.moveForward();
		assertTrue(prey4.getPosition().equals(new Point(99,98)));
	}
	
	@Test
    void testToString() {
		World world = new World(10, 10);
		Point point =  new Point(1, 1);
		Shelter shelter = world.createShelter(point, Orientation.createRandom());
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), point, Orientation.createRandom());

        prey.setPosition(point);

        String expectedString = String.format("Prey(position=%s)", point);
        
        assertEquals(expectedString, prey.toString());
    }
	
}
