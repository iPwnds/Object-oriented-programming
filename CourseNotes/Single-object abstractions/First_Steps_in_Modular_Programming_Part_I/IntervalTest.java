package First_Steps_in_Modular_Programming_Part_I;

import org.junit.jupiter.api.Test;

class IntervalTest {	
	@Test
	void test() {
//		Interval interval = new Interval();
//		Interval.lowerBound = 3;
//		Interval.upperBound = 7;
//		int width = interval.upperBound - Interval.lowerBound;
//		assert width == 4;
		
		
//		Interval interval = new Interval();
//		Interval.setLowerBound(interval, 3);
//		Interval.setUpperBound(interval, 7);
//
//		int width = Interval.getWidth(interval);
//		assert width == 4;
		
		
		Interval interval = new Interval();
		interval.setLowerBound(3);
		interval.setUpperBound(7);
		
		int width = interval.getWidth();
		assert width == 4;
	}
}