import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class Test {
	List myList;
	
	@BeforeEach
	void setUp() throws Exception {
		myList = new ArrayList(10);
		myList.add(1);
		myList.add(2);
		myList.add(3);
	}
	
	@org.junit.jupiter.api.Test
	void test() {
		assertEquals(1, myList.get(0));
		
		myList.set(1, 16);
		assertEquals(16, myList.get(1));
		
		myList.add(2, 42);
		assertEquals(42 , myList.get(2));
	}

}
