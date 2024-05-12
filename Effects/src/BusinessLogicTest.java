import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BusinessLogicTest {

	@Test
	void test() {
		ArrayList<Integer> inputs = new ArrayList<>();
		inputs.add(1);
		inputs.add(2);
		StubLogger stublog = new StubLogger(inputs);
		BusinessLogic bl = new BusinessLogic(stublog);
		bl.handleRequest(new Request(1234));
		assertTrue(stublog.getBuffer().stream().anyMatch(msg -> msg.contains("1234")));
	}

}
