package Representation_Objects_and_Representation_Exposure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
//		String a = String.valueOf('a');
//		assert a.charAt(0) == 'a'; // Succeeds
//		a.toCharArray()[0] = 'b';
//		assert a.charAt(0) == 'a'; // Fails
		
		
		char[] cs = {'a'};
		String a = String.valueOf(cs);
		assert a.charAt(0) == 'a'; // Succeeds
		cs[0] = 'b';
		assert a.charAt(0) == 'a'; // Fails

	}

}
