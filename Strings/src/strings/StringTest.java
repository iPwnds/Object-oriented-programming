package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		char[] helloChars = {'H', 'e', 'l', 'l', 'o'};
		String hello = new String(helloChars);
		assertArrayEquals(new char[] {'H', 'e', 'l', 'l', 'o'}, hello.toArray());
		assertEquals(5, hello.length());
		assertEquals('H', hello.charAt(0));
		
		helloChars[0] = 'B';
		assertEquals('H', hello.charAt(0));
		
		char[] otherChars = hello.toArray();
		otherChars[0] = 'B';
		assertEquals('H', hello.charAt(0));
	}

}
