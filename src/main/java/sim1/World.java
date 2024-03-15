package sim1;

import java.util.Arrays;

import util.Point;



public class World
{

    private final int width;


    private final int height;

    /**
     * @representationObject
     * @representationObjects
     */
    private final CreatureA[] populationA;

    /**
     * @representationObject
     * @representationObjects
     */
    private final CreatureB[] populationB;


    public World(int width, int height, CreatureA[] popA, CreatureB[] popB)
    {
        this.width = width;
        this.height = height;
        this.populationA = popA;
        this.populationB = popB;

    }


    public int getWidth() {
    	return this.width;
    }


    public int getHeight() {
    	return this.height;
    }


    public CreatureA[] getPopulationA()
    {

        return populationA;
    }


    public CreatureB[] getPopulationB()
    {
        return populationB;
    }

    /**
     * @pre | position != null
     */
    public boolean isInside(Point position)
    {
    	return Point.isWithin(position, width, height);
    }
    

    
    /**
     * @pre | pos != null
     * Returns true iff pos is 1 unit away from a wall (and inside the world)
     */
    public boolean isLimPos(Point pos) {
    	return false;
    }

    
    /**
     * LEGIT 
     * @pre | array1 != null && array2 != null
     * @pre | array1.length == array2.length
     */
    public static boolean areEqualCreatureAArrays(CreatureA[] array1, CreatureA[] array2) {
    	boolean res = true;
    	for (int i = 0 ; i < array1.length ; i++) {
    		res = res && array1[i].isEqual(array2[i]);
    	}
    	return res;
    }
    
    
    /**
     * LEGIT 
     * @pre | array1 != null && array2 != null
     * @pre | array1.length == array2.length
     */
    public static boolean areEqualCreatureBArrays(CreatureB[] array1, CreatureB[] array2) {
    	boolean res = true;
    	for (int i = 0 ; i < array1.length ; i++) {
    		res = res && array1[i].isEqual(array2[i]);
    	}
    	return res;
    }
    

    /**
     * true iff position is inside the world and no creature sits there
     * 
     * @pre | position != null
     */
    public boolean isFree(Point position)
    {
    	if (!isInside(position)) {
            return false;
        }
        for (CreatureA creatureA : populationA) {
            if (creatureA.getPosition().equals(position)) {
                return false;
            }
        }
        for (CreatureB creatureB : populationB) {
            if (creatureB.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Performs the action of each creature
     */
    public void step()
    {
    	
        for (int i = 0 ; i < populationB.length ; i ++)
        {
            populationB[i].performAction(this);
        }
    	
        for (int i = 0 ; i < populationA.length ; i ++)
        {
            populationA[i].performAction(this);
        }


    }
    

    	
    }
    


