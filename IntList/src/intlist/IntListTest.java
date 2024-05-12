package intlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntListTest {

	@Test
	void test() {
		IntList myIntList = new IntList();
		assertEquals(0, myIntList.getLength());
		assertArrayEquals(new int[0], myIntList.getElements());
		
		myIntList.add(10);
		assertArrayEquals(new int[] {10}, myIntList.getElements());
		
		assertEquals(10, myIntList.getElementAt(0));

		int[] xs = myIntList.getElements();
		xs[0] = 20;

		assertEquals(10, myIntList.getElementAt(0));

		

		myIntList.add(20);
		myIntList.add(30);
		
		myIntList.removeLast();
		assertArrayEquals(new int[] {10, 20}, myIntList.getElements());
	}

}
