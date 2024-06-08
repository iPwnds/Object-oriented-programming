package Behavioral_subtyping__modular_about_programs_that_use_dynamic_binding;

import java.util.Arrays;

class CompanyA extends Company {

	/**
	 * @post | result != null
	 * @post | result.length == 3
	 * @post | Arrays.stream(result).allMatch(e -> e != null)
	 */
    String[] getLocations() {
        return new String[] {"Brussels", "Paris", "Berlin"};
    }

}