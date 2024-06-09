package util;

/**
 * LEGIT
 * 
 * @immutable
 */
public class Vector
{
    private final int x;
    private final int y;

    /**
     * Initializes a new Vector object.
     *
     */
    public Vector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns this Vector's x coordinate.
     */
    public int getX() { return this.x; }

    /**
     * Returns this Vector's y coordinate.
     */
    public int getY() { return this.y; }
    

    public Vector scaleWith(int fac) {
    	return new Vector( fac * x , fac * y);
    }
    

    public Vector plus(Vector other) {
    	return new Vector( x + other.getX(), y + other.getY());
    }

    /**
     * @creates | result
     * @post | result != null
     * LEGIT
     */
    public Orientation toClosestOrientation()
    {
        var angle = (Math.toDegrees( Math.atan2(-this.y, this.x) ) + 360) % 360;
        assert 0 <= angle && angle < 360;        
        var i = (int) ((angle + 22.5) % 360) / 45;
        assert 0 <= i && i < 8;
        
        return Orientation.fromIndex((10 - i) % 8);
    }
    
    @Override
    public boolean equals(Object other)
    {
        if (other instanceof Vector v)
        {
            return this.x == v.x && this.y == v.y;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return String.format("Vector(%d, %d)", this.x, this.y);
    }
}
