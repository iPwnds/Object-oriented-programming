package How_to_properly_document_single_object_abstractions;

/**
 * Each instance of this class represents a point with integer coordinates
 * in a two-dimensional coordinate system.
 */
public class Point2 {

    /**
     * Stores the distance between this point and the origin of the coordinate system
     * (that is, the r component of the polar coordinates of this point).
     */
    private double radius;
    
    /**
     * Stores the angle, in radians, made by the origin of the
     * coordinate system, this point, and the positive X axis
     * (that is, the theta component of the polar coordinates of this point).
     */
    private double angle;

    /** Returns this instance's X coordinate. */
    public int getX() { return (int)(radius * Math.cos(angle)); }
    
    /** Returns this instance's Y coordinate. */
    public int getY() { return (int)(radius * Math.sin(angle)); }
    
    /**
     * Initializes this instance so that it represents the given point.
     * @post | getX() == x
     * @post | getY() == y
     */ 
    public Point2(int x, int y) {
        radius = Math.sqrt((double)x * x + (double)y * y);
        angle = Math.atan2(y, x);
    }

}
