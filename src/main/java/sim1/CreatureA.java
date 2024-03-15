package sim1;

import util.Orientation;
import util.Point;
import util.Vector;


public class CreatureA
{
    private Point position;
    private Orientation orientation;
    private final BehaviorA behavior;
    /**
     * @representationObject
     */
    private Chromosome chrom;


    public CreatureA(BehaviorA behavior, Point position, Orientation orientation, Chromosome chrom)
    {
        this.behavior = behavior;
        this.position = position;
        this.orientation = orientation;
        this.chrom = chrom;
    }

    public Point getPosition()
    {
        return this.position;
    }

    public Orientation getOrientation() 
    { 
    	return this.orientation; 
    }
    
    public BehaviorA getBehavior() 
    {
    	return this.behavior;
    }
    
    public Chromosome getChromosome() 
    {
    	return chrom;
    }

    /**
     * The orientation remains unchanged.
     */
    public void moveForward(World world, Vector drift)
    {
    	position = position.move(orientation.toVector()).move(drift);
    }

    /**
     * @post | getOrientation().isEqual(old(getOrientation().turnClockwise(1)))
     */
    public void turnClockwise() 
    {
    	this.orientation = this.orientation.turnClockwise(1);
    }

    /**
     * @post | getOrientation().isEqual(old(getOrientation().turnCounterclockwise(1)))
     */
    public void turnCounterclockwise() 
    {
        this.orientation = this.orientation.turnCounterclockwise(1);
    }

    /**
     * LEGIT
     * applies behavior of `this`
     */
    public void performAction(World world)
    {
        this.behavior.applyBehavior(world, this);
    }
    
    /**
     * true iff same position and orient. and chromosome
     * 
     * @param other
     * @return
     */
    public boolean isEqual(CreatureA other) {
    	if (other == null) return false;
        return position.equals(other.getPosition()) && orientation.isEqual(other.getOrientation()) && chrom.equals(other.getChromosome());
    }
    
    /**
     * @creates | result
     */
    public CreatureA giveCopy() {
    	return new CreatureA(behavior, new Point(position.getX(), position.getY()), orientation, chrom);
    }
}
