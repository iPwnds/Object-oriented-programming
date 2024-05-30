package First_steps_in_modular_programming;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TimeOfDayTest {
	
	@Test
	void test() {
		TimeOfDay t = new TimeOfDay(-12, 15);
		assert t.getHours() == 12 && t.getMinutes() == 15;	
	}

}