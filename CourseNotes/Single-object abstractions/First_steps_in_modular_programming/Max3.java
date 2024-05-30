package First_steps_in_modular_programming;

public class Max3 {

	/**
	 * Returns the maximum of the given numbers.
	 * 
	 * @post The result equals one of the given numbers.
	 *     | result == i || result == j || result == k
	 * @post The result is not less than any of the given numbers
	 *     | i <= result && j <= result && k <= result
	 */
	public static int max3(int i, int j, int k) {
		if (i < j)
			if (j < k)
				return k;
			else
				return j;
		else
			if (i < k)
				return k;
			else
				return i;
	}

}