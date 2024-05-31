package Representation_Objects_and_Representation_Exposure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Managing_Complexity_through_Modularity_and_Abstraction.Fraction;

class FractionListTest {

	@Test
	void test() {
		FractionList myList = new FractionList();
		myList.add(Fraction.ZERO);
		Fraction[] elements = myList.getElements();
		elements[0] = null;
		// Object myList is now in an inconsistent state
		myList.getSum(); // crashes with a NullPointerException
	}

}
