package Dynamic_binding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObjectTest {

	@Test
	void test() {
		assertEquals("This is Point [x=10, y=20].","This is " + new Point(10, 20) + ".");
		assertEquals(new Point(10, 20), new Point(10, 20));
		
//		assertEquals("This is Point@12345678.", "This is " + new Point(10, 20) + ".");
//		assertNotEquals(new Point(10, 20), new Point(10, 20));
	
//		assertEquals(Object o1, Object o2) == o1.equals(o2)
//		array1.equals(array2) == array1 == array2
	}

}
