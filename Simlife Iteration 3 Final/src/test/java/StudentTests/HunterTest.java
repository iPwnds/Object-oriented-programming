package StudentTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sim.entities.Hunter;
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
	void getSheltertest() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Point point = new Point(1,1);
		Orientation orientation = Orientation.createRandom();
		Hunter hunter = world.createHunter(shelter, point, orientation);
		assertEquals(hunter.getShelter(), shelter);
	}

    @Test
    void testToString() {
    	World world = new World(10, 10);
		Point point =  new Point(1, 1);
		Shelter shelter = world.createShelter(point, Orientation.createRandom());
		Hunter hunter = world.createHunter(shelter, point, Orientation.createRandom());
        
        hunter.setPosition(point);

        String expectedString = String.format("Hunter(position=%s)", point);
        
        assertEquals(expectedString, hunter.toString());
    }
    
}
	