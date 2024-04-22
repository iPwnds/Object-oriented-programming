package util;

/**
 * LEGIT
 * 
 * @immutable
 */
public class Point
{
    /**
     * @post | result != null
     * @post ! 0 <= result.getX() && result.getX() < maxX
     * @post ! 0 <= result.getY() && result.getY() < maxY
     */
    public static Point createRandom(int maxX, int maxY)
    {
        var x = RandomUtil.integer(maxX);
        var y = RandomUtil.integer(maxY);

        return new Point(x, y);
    }

    private final int x;

    private final int y;

    /**
     * Initializes a new Point object.
     *
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X-coordinate of the Point.
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Returns the X-coordinate of the Point.
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * @pre | displacement != null
     */
    public Point move(Vector displacement)
    {
        int x = this.x + displacement.getX();
        int y = this.y + displacement.getY();

        return new Point(x, y);
    }

    /**
     * @pre | other != null
     */
    public int distanceSquared(Point other)
    {
        var dx = other.getX() - this.getX();
        var dy = other.getY() - this.getY();

        return dx * dx + dy * dy;
    }

    /**
     * @pre | other != null
     * @creates | result
     * @post | result != null
     * @post | result.getX() == this.getX() - other.getX()
     * @post | result.getY() == this.getY() - other.getY()
     */
    public Vector subtract(Point other)
    {
    	var dx = this.x - other.x;
    	var dy = this.y - other.y;
    	
    	return new Vector(dx, dy);
    }
    
    /**
     * @pre | other != null
     * @creates | result
     * @post | result != null
     * @post | result.equals(other.subtract(this))
     */
    public Vector vectorTo(Point other)
    {
        return other.subtract(this);
    }

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof Point p)
        {
            return this.x == p.x && this.y == p.y;
        } else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return String.format("(%d, %d)", this.x, this.y);
    }
    
    /**
     * Determines whether pos is a point belonging to a rectangle with sides width, height
     * 
     */
    public static boolean isWithin(Point pos, int width, int height) {
    	return 0 <= pos.getX() && pos.getX() < width && 0 <= pos.getY() && pos.getY() < height;
    }
    
    public static Point O = new Point(0,0);
}
