package jlearner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JLearnerTest {

	@Test
	void test_methods() {
		int x = 2;
		int y = 4;
		int z = 9;
		
		assertEquals(3, JLearner.avg(x, y));
		assertEquals(16, JLearner.pwrr(y, x));
		assertEquals(16, JLearner.pwri(y, x));
		assertEquals(3, JLearner.sqrt(z));
	}

	@Test
	void test_arrays() {
		int[] list = {1, 2, 3, 0, 4, 5, 6, 0};
		int[] negation = {-1, -2, -3, 0, -4, -5, -6, 0};
		
		assertEquals(2, JLearner.count(list));
		assertArrayEquals(negation, JLearner.negation(list));
		//assertArrayEquals(negation, JLearner.negationClone(list));
		
		
	}
}
