package ExamPrep;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void add() {
		int a = 12;
		int b = 4;
		assertEquals(16, Calculator.add(a, b));
	}
	
	@Test
	void rem() {
		int a = 24;
		int b = 8;
		assertEquals(16, Calculator.rem(a, b));
	}
	
	@Test
	void mul() {
		int a = 2;
		int b = 4;
		assertEquals(8, Calculator.mul(a, b));
	}
	
	@Test
	void div() {
		int a = 16;
		int b = 4;
		assertEquals(4, Calculator.div(a, b));
	}
	
	@Test 
	void pow() {
		int a = 3;
		int b = 3;
		assertEquals(81, Calculator.pow(a, b));
	}
	
	@Test
	void sqrt() {
		int a = 25;
		assertEquals(5, Calculator.sqrt(a));
	}
	
}
