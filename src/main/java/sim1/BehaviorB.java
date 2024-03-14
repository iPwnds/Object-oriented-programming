package sim1;

import util.RandomUtil;


public class BehaviorB
{
    public void applyBehavior(World world, CreatureB creature)
    {
    	boolean shouldMoveForward = RandomUtil.bool();

        if (shouldMoveForward) 
        {
            creature.moveForward(world);
        } 
        
        else 
        {
            boolean turnClockwise = RandomUtil.bool();
            
            if (turnClockwise) 
            {
                creature.turnClockwise();
            } 
            
            else 
            {
                creature.turnCounterclockwise();
            }
        }
    }
}