package sim.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import sim.Chromosome;
import util.Grid;
import util.Orientation;
import util.Point;

/**
 * Represents the world where entities interact.
 * The world consists of a grid where entities reside and interact.
 */
public class World
{
	/**
	 * The grid representing the entities' positions in the world.
     * Each cell of the grid may contain an entity or be empty.
	 * 
	 * @representationObject
	 * @peerObjects
	 * @invar | entityGrid != null

	 */
	final Grid<Entity> entityGrid;
	
	/**
	 * The list of hunters present in the world.
     * This list maintains references to all hunter entities in the world.
	 * 
	 * @representationObject
	 * @peerObjects
	 * 	 * @invar | hunters != null
	 * @invar | hunters.stream().allMatch(s -> s.world == this)
	 */
	final List<Hunter> hunters;

	/**
	 * Creates a new world with zero entities in it.
	 * 
	 * @param width The width of the world.
     * @param height The height of the world.
     * @pre | width > 0 && height > 0
     * @post | getWidth() == width && getHeight() == height
	 */
	public World(int width, int height)
	{
		this.entityGrid = new Grid<>(width, height);
        this.hunters = new ArrayList<>();
	}

	/**
     * Returns the width of the world.
     * 
     * @return The width of the world.
     * @post | result > 0
     */
	public int getWidth()
	{
		return entityGrid.getWidth();
	}

	/**
     * Returns the height of the world.
     * 
     * @return The height of the world.
     * @post | result > 0
     */
	public int getHeight()
	{
		return entityGrid.getHeight();
	}

	/**
	 * Returns all entities inhabiting the world.
	 * 
	 * @return A list of all entities in the world.
     * @post | result != null
	 */
	public List<Entity> getEntities()
	{
		ArrayList<Entity> res = new ArrayList<Entity>();
		res.addAll(
		   giveEntityStreamPriv().map(ent -> ent.giveCopy()).toList()
		   );
	    return res;
	}

	/**
     * Returns the number of entities currently in the world.
     * 
     * @return The number of entities in the world.
     * @post | result >= 0
     */
	public long numberOfEntities()
	{
		return giveEntityStreamPriv().count();
	}

	/**
     * Checks if a given position is inside the world.
     * 
     * @param position The position to check.
     * @return true if the position is inside the world, false otherwise.
     * @pre | position != null
     //* @post | result == getEntityGrid().isValidPosition(position)
     */
	public boolean isInside(Point position)
	{
		return this.entityGrid.isValidPosition(position);
	}

	/**
     * Returns the entity at a given position.
     * 
     * @param position The position to query.
     * @return The entity at the specified position, or null if no entity is present.
     * @pre | position != null
     */
	public Entity getEntityAt(Point position)
	{
		return entityGrid.at(position);
	}

	/**
	 * true iff position is inside the world and no creature sits there
	 *
	 * @param position The position to check.
     * @return true if the position is inside the world and no entity is present, false otherwise.
     * @pre | position != null
     * @post | result == (isInside(position) && getEntityAt(position) == null)
	 */
	public boolean isFree(Point position)
	{
		return isInside(position) && getEntityAt(position) == null;
	}

	/**
     * Creates a new hunter entity in the world.
     * 
     * @param shelter The shelter associated with the hunter.
     * @param position The initial position of the hunter.
     * @param orientation The initial orientation of the hunter.
     * @return The created hunter entity.
     * @pre | shelter != null && position != null && orientation != null
     * @post | result != null && getEntityAt(position) == result
     */
	public Hunter createHunter(Shelter shelter, Point position, Orientation orientation)
	{
		var hunter = new Hunter(this, shelter, position, orientation);
		this.entityGrid.setAt(position, hunter);
		hunters.add(hunter);
		return hunter;
	}

	/**
     * Creates a new shelter entity in the world.
     * 
     * @param position The initial position of the shelter.
     * @param orientation The initial orientation of the shelter.
     * @return The created shelter entity.
     * @pre | position != null && orientation != null
     * @post | result != null && getEntityAt(position) == result
     */
	public Shelter createShelter(Point position, Orientation orientation)
	{
		var shelter = new Shelter(this, position, orientation);
        entityGrid.setAt(position, shelter);
        return shelter;
	}
	
	/**
     * Returns the grid of entities in the world.
     * 
     * @return The grid of entities.
     * @post | result != null
     */
	public Grid<Entity> giveEntityGrid() 
	{
		return entityGrid;
	}
	
	/**
	 * LEGIT
	 */
	private Stream<Entity> giveEntityStreamPriv()
	{
		return this.entityGrid.givePositionStream().map(pos -> this.entityGrid.at(pos))
				.filter(entity -> entity != null).toList().stream();
	}
	
	/**
	 * LEGIT
	 * just a helper method.
	 */
	void removeEntityAt(Point position)
	{
		this.entityGrid.setAt(position, null);
	}
	
	/**
	 * LEGIT
	 */
	public ArrayList<Prey> getPreys()
	{
		return new ArrayList<> (giveEntityStreamPriv().filter(e -> e.isPrey()).map(e -> (Prey) e).toList());
	}
	
	/**
	 * LEGIT
	 */
	public ArrayList<Hunter> getHunters() 
	{
		return new ArrayList<>(hunters);
	}
	
	/**
	 * LEGIT
	 * 
	 * Returns true iff pos is 1 (simulation) pixel away from a wall (and inside the
	 * world)
	 */
	public boolean isLimPos(Point pos)
	{
		return isInside(pos) && (0 == pos.getX() || pos.getX() == getWidth() - 1 || pos.getY() == 0
				|| pos.getY() == getHeight() - 1);
	}
	
	/**
	 * LEGIT
	 */
	public void step()
	{
		this.giveEntityStreamPriv().forEach(e -> e.performAction());
	}

	/**
	 * LEGIT
	 */
	public Prey createPrey(Shelter shelter, Chromosome chromosome, Point position, Orientation orientation)
	{
		var prey = new Prey(this, shelter, chromosome, position, orientation);
		this.entityGrid.setAt(position, prey);
		return prey;
	}
	
	/**
	 * LEGIT
	 */
	public boolean hasHunterInCone(Point top, Orientation orientation)
	{
		for ( var hunter : this.hunters )
		{
			var hunterPosition = hunter.getPosition();
			
			if ( hunterPosition.equals(top))
			{
				return true;
			}
			
			if ( orientation.isEqual(top.vectorTo(hunterPosition).toClosestOrientation()) )
			{
			    return true;
			}
		}
		
		return false;
	}
	
	/**
	 * LEGIT
	 */
	public Stream<Point> givePositionStream() 
	{
		return entityGrid.givePositionStream();
	}
	
	/**
	 * LEGIT
	 */
	public Stream<Entity> giveEntityStream() 
	{
		return giveEntityStreamPriv();
	}
	
//	/**
//	 * Returns the grid containing entities in the world.
//	 * Used for documentation ONLY
//	 * 
//     * Should not have representation exposure
//	 * because object is being cloned & fields are final
//	 * 
//	 * @return The grid containing entities.
//	 * @post | result != null
//	 */
//	public Grid<Entity> getEntityGrid() 
//	{
//		return Grid.giveCopy(entityGrid);
//	}
}
