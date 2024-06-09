package util;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * LEGIT
 */
public class Grid<T>
{
	private T[][] grid;
	
	private final List<Point> positions; // to speed things up a bit

	/**
	 * Creates a grid with the given dimensions.
	 * Initially all values in the grid are null.
	 * 
//	 * @throws IllegalArgumentException
//	 *   | width <= 0 || height <= 0
//	 * @post | getWidth() == width
//	 * @post | getHeight() == height
//	 * @post | getPositions().stream().allMatch(p -> at(p) == null)
	 */
	@SuppressWarnings("unchecked")
	public Grid(int width, int height)
	{
		if ( width <= 0 || height <= 0 )
		{
			throw new IllegalArgumentException();
		}
		
		this.grid = (T[][]) new Object[height][width];
		this.positions = IntStream.range(0, getWidth() * getHeight()).mapToObj(i -> new Point(i % getWidth(), i / getWidth())).toList(); 
	}

	/**
	 * Returns the width of the grid.
	 * 
	 * @post | result > 0
	 */
	public int getWidth()
	{
		return this.grid[0].length;
	}
	
	/**
	 * Returns the height of the grid.
	 * 
	 * @post | result > 0
	 */
	public int getHeight()
	{
		return this.grid.length;
	}
	
	/**
	 * Returns the value at a particular position.
	 * 
	 * @pre | isValidPosition(position)
	 */
	public T at(Point position)
	{
		return this.grid[position.getY()][position.getX()];
	}
	
	/**
	 * Sets the value at a particular position.
	 * It is allowed to store null values.
	 * 
	 * @pre | isValidPosition(position)
	 * @post | at(position) == value
	 */
	public void setAt(Point position, T value)
	{
		this.grid[position.getY()][position.getX()] = value;
	}
	
	/**
	 * Checks if the given position falls within the bounds of the grid.
	 * 
	 */
	public boolean isValidPosition(Point position)
	{
		return 0 <= position.getX() &&
				position.getX() < getWidth() &&
				0 <= position.getY() &&
				position.getY() < getHeight();
	}

//	/**
//	 * Returns a list of all positions in the grid.
//	 * 
//	 */
//	public List<Point> getPositions()
//	{
//		return this.positions;
//	}
	
	/**
	 * legit
	 */
	public Stream<Point> givePositionStream() {
		return positions.stream();
	}
	
	/**
	 * shallow copy
	 */
	public Grid<T> giveCopy() {
		Grid<T> res = new Grid<T>(getWidth(), getHeight());
		for (Point p : positions) {
			res.setAt(p, at(p));
		}
		return res;
	}
}
