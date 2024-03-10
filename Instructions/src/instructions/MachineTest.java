package instructions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MachineTest {

	@Test
	void test() {
		assertEquals(8, power(2, 3));
		assertEquals(9, power(3, 2));
	}
	
	int power(int x, int y) {
		Instruction[] powerProgram = {
			new LoadConstant(2, 1),
			new JumpIfZero(1, 5),
			new Multiply(2, 0),
			new Decrement(1),
			new Jump(1),
			new Halt()
		};
		int[] registers = {x, y, 0};
		new Machine().execute(registers, powerProgram);
		return registers[2];
	}

}
