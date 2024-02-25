package jlearner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JLearnerTest {

	@Test
	void test_methods() {
		assertEquals(3, JLearner.avg(2, 4));
		assertEquals(16, JLearner.pwrr(4, 2));
		assertEquals(16, JLearner.pwri(4, 2));
		assertEquals(3, JLearner.sqrt(9));
	}

}
