package Managing_Complexity_through_Modularity_and_Abstraction;

public class SquareRoot {

	/**
	 * Returns the square root of the given nonnegative integer, rounded down.
	 *
	 * @pre The given integer is nonnegative.
	 *    | 0 <= x
	 * @post The result is nonnegative.
	 *    | 0 <= result
	 * @post The square of the result is not greater than the given integer.
	 *    | (long)result * result <= x
	 * @post The square of one more than the result is greater than the given integer.
	 *    | x < ((long)result + 1) * ((long)result + 1)
	 */
	public static int squareRoot(int x) {
	    int result = 0;
	    while ((long)result * result <= x)
	        result++;
	    return result - 1;
	}

	
}
