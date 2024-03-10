package instructions;

abstract class Instruction {}

class LoadConstant extends Instruction {
	int r;
	int c;
	LoadConstant(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Decrement extends Instruction {
	int r;
	Decrement(int r) { this.r = r; }
}

class Multiply extends Instruction {
	int r1;
	int r2;
	Multiply(int r1, int r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
}

class JumpIfZero extends Instruction {
	int r;
	int a;
	JumpIfZero(int r, int a) {
		this.r = r;
		this.a = a;
	}
}

class Jump extends Instruction {
	int a;
	Jump(int a) {
		this.a = a;
	}
}

class Halt extends Instruction {
}

class Machine {
	int pc;
	int[] registers;
	void execute(int[] registers, Instruction[] instructions) {
		pc = 0;
		this.registers = registers;
		while (0 <= pc) {
			Instruction i = instructions[pc];
			if (i instanceof LoadConstant lc) {
				//LoadConstant lc = (LoadConstant)i;
				registers[lc.r] = lc.c;
				pc++;
			} else if (i instanceof Decrement d) {
				registers[d.r]--;
				pc++;
			} else if (i instanceof Multiply m) {
				registers[m.r1] *= registers[m.r2];
				pc++;
			} else if (i instanceof JumpIfZero j) {
				if (registers[j.r] == 0)
					pc = j.a;
				else
					pc++;
			} else if (i instanceof Jump j) {
				pc = j.a;
			} else if (i instanceof Halt) {
				pc = -1;
			} else
				throw new AssertionError("Should never happen");
		}
	}
}
