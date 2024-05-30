package First_Steps_in_Modular_Programming_Part_II;

import org.junit.jupiter.api.Test;

class IntervalTest {
	@Test
	void test() {
//		Interval interval = new Interval(3, 7);
//		int width = interval.getWidth();
//		assert width == 4;
		
		
		Interval interval = new Interval(3, 4, null);
		interval.setUpperBound(8);
		assert interval.getLowerBound() == 3;
	}
}