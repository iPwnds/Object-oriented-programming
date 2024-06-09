package util;

import java.util.function.BooleanSupplier;

/**
 * LEGIT
 * 
 * Purely optional, but can help express specifications more clearly.
 * Beware, however, of strict evaluation.
 */
public class Logic
{
	/* Private prevents objects from being created */
	private Logic() { }
	

	public static boolean implies(boolean p, boolean q)
	{
		return !p || q;
	}
	
	public static boolean implies(boolean p, BooleanSupplier q)
    {
        return !p || q.getAsBoolean();
    }

	public static boolean iff(boolean p, boolean q)
	{
		return p == q;
	}
}
