package IntervalPart2;

import org.junit.jupiter.api.Test;

class IntervalTest {
	@Test
	void test() {
		Interval interval = new Interval(3, 7);
		int width = interval.getWidth();
		assert width == 4;
	}
}