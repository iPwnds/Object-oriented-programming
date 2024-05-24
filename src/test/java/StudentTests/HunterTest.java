package StudentTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import sim.Chromosome;
import sim.entities.Hunter;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.entities.World;
import util.Color;
import util.Orientation;
import util.Point;

public class HunterTest {

	@Test
	void IsPreyPkgTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(1,1);
		Orientation orientation = Orientation.createRandom();
		Hunter hunter = world.createHunter(shelter, point, orientation);
		assertFalse(hunter.isPrey());
	}
	@Test
	void IsHunterPkgtest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(1,1);
		Orientation orientation = Orientation.createRandom();
		Hunter hunter = world.createHunter(shelter, point, orientation);
		assertTrue(hunter.isHunter());
	}
	@Test
	void IsSheterPkgtest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(1,1);
		Orientation orientation = Orientation.createRandom();
		Hunter hunter = world.createHunter(shelter, point, orientation);
		assertFalse(hunter.isShelter());
	}
	@Test
	void getColorTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(1,1);
		Orientation orientation = Orientation.createRandom();
		Hunter hunter = world.createHunter(shelter, point, orientation);
		assertEquals(hunter.getColor(), Color.RED);
	}
	@Test
	void performActionTest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(1,1);
		Orientation orientation = Orientation.createRandom();
		Hunter hunter = world.createHunter(shelter, point, orientation);
		Prey closestPrey = world.createPrey(shelter, Chromosome.createRandom(), new Point(3,3), Orientation.createRandom());
		Prey fartestPrey = world.createPrey(shelter, Chromosome.createRandom(), new Point(6,1), Orientation.createRandom());
		hunter.performAction();
		assertEquals(Orientation.fromVector(hunter.getPosition().vectorTo(closestPrey.getPosition())), hunter.getOrientation());
		assertNotEquals(Orientation.fromVector(hunter.getPosition().vectorTo(fartestPrey.getPosition())), hunter.getOrientation());
		hunter.setAppetite(1);
		Point oldpos = hunter.getPosition();
		hunter.performAction();
		assertTrue(hunter.getPosition().equals(oldpos));
	}
	@Test
	void getSheltertest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(1,1);
		Orientation orientation = Orientation.createRandom();
		Hunter hunter = world.createHunter(shelter, point, orientation);
		assertEquals(hunter.getShelter(), shelter);
	}
	
	
}
	
	
	
	