package StudentTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import sim.Chromosome;
import sim.Constants;
import sim.entities.Entity;
import sim.entities.Prey;
import sim.entities.Shelter;
import sim.entities.World;
import util.Grid;
import util.Orientation;
import util.Point;


public class WorldTest {
	@Test 
	public void getwidhtandheigthtest() {
		World world = new World(10,10);
		assertEquals(world.getWidth(), 10); 
		assertEquals(world.getHeight(), 10);

	}
	@Test 
	public void getEntityGrid() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), new Point(2,2), Orientation.createRandom());
		Prey prey1 = world.createPrey(shelter, Chromosome.createRandom(), new Point(3,2), Orientation.createRandom());
		Grid<Entity> grid = world.getEntityGrid();
		assertTrue(grid.at(new Point(2,2)) == prey);
		assertTrue(grid.at(new Point(3,2)) == prey1);
	}
	@Test 
	public void giveEntityGrid() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), new Point(2,2), Orientation.createRandom());
		Prey prey1 = world.createPrey(shelter, Chromosome.createRandom(), new Point(3,2), Orientation.createRandom());
		Grid<Entity> grid = world.giveEntityGrid();
		assertTrue(grid.at(new Point(2,2)) == prey);
		assertTrue(grid.at(new Point(3,2)) == prey1);
	}
	@Test 
	public void numberOfEntityGrid() {
		World world = new World(10,10);
		Shelter shelter = world.createShelter(new Point(1,1), Orientation.createRandom());
		Prey prey = world.createPrey(shelter, Chromosome.createRandom(), new Point(2,2), Orientation.createRandom());
		Prey prey1 = world.createPrey(shelter, Chromosome.createRandom(), new Point(3,2), Orientation.createRandom());
		assertEquals(world.numberOfEntities(), 3);
	}

}
