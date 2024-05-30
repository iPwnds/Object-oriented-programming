package Managing_Complexity_through_Modularity_and_Abstraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FractionContainerTest {

	@Test
	void test() {
		FractionContainer container = new FractionContainer();
		for (int i = 0; i < 10; i++)
		    container.add(10, 100);
		assert container.equals(100, 100);
	}

}
