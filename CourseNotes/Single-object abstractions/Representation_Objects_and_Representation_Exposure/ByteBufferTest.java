package Representation_Objects_and_Representation_Exposure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ByteBufferTest {

	@Test
	void test() {
//		byte[] myBytes = {1, 2, 3};
//		ByteBuffer myBuffer = new ByteBuffer(myBytes);
//		assert myBytes[0] == 1; // Succeeds
//		myBuffer.put(4);
//		assert myBytes[0] == 1; // Fails
		
		
		byte[] myBytes = {1, 2, 3};
		ByteBuffer myBuffer = new ByteBuffer(myBytes);
		assert myBytes[0] == 1; // Succeeds
		myBuffer.put(4);
		assert myBytes[0] == 1; // Succeeds

		byte[] moreBytes = myBuffer.getBytes();
		assert moreBytes[1] == 2; // Succeeds
		myBuffer.put(5);
		assert moreBytes[1] == 2; // Succeeds

	}

}
