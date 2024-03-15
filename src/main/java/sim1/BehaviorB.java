package sim1;

import util.RandomUtil;


public class BehaviorB
{
	/**
	 * @param world
	 * @param creature
	 * 
	 * @pre | world != null
	 * @pre | creature != null
	 * 
	 * @post | creature.getPosition() != null
	 * @post | creature.getOrientation() != null
	 */
    public void applyBehavior(World world, CreatureB creature)
    {
    	if (world == null) {
            throw new IllegalArgumentException("The 'world' parameter must not be null.");
        }

        if (creature == null) {
            throw new IllegalArgumentException("The 'creature' parameter must not be null.");
        }

        boolean shouldMoveForward = RandomUtil.bool();

        if (shouldMoveForward) {
            creature.moveForward(world);
        } else {
            boolean turnClockwise = RandomUtil.bool();

            if (turnClockwise) {
                creature.turnClockwise();
            } else {
                creature.turnCounterclockwise();
            }
        }
    }
}