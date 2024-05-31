package How_to_properly_document_single_object_abstractions;

/**
 * Each instance of this class represents a point with integer coordinates
 * in a two-dimensional coordinate system.
 */
public class Point1 {

    private int x;
    private int y;

    /** Returns this instance's X coordinate. */
    public int getX() { return x; }
    
    /** Returns this instance's Y coordinate. */
    public int getY() { return y; }
    
    /**
     * Initializes this instance so that it represents the given point.
     * @post | getX() == x
     * @post | getY() == y
     */ 
    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
