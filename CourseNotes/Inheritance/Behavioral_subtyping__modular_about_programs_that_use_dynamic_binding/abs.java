package Behavioral_subtyping__modular_about_programs_that_use_dynamic_binding;

public class abs {
	/**
	 * @pre | false
	 * @post | true
	 */
	public static int abs1(int x) {
		return x;
	}

	/**
	 * @pre | 0 <= x
	 * @post | true
	 */
	public static int abs2(int x) {
		return x;
	}

	/**
	 * @pre | 0 <= x
	 * @post | 0 <= result
	 */
	public static int abs3(int x) {
		return x;
	}

	/**
	 * @pre | true
	 * @post | 0 <= result
	 */
	public static int abs4(int x) {
		return x;
	}

	/**
	 * @pre | true
	 * @post | false
	 */
	public static int abs5(int x) {
		return x;
	}
}
