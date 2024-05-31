package Representation_Objects_and_Representation_Exposure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ByteBufferTest {

	@Test
	void test() {
		byte[] myBytes = {1, 2, 3};
		ByteBuffer myBuffer = new ByteBuffer(myBytes);
		assert myBytes[0] == 1; // Succeeds
//		myBuffer.put(4);
		assert myBytes[0] == 1; // Fails
	}

	@Test
	void OpaqueTest() {
		byte[] myBytes = {1, 2, 3};
		ByteBufferOpaque myBuffer = new ByteBufferOpaque(myBytes);
		assert myBytes[0] == 1; // Succeeds
//		myBuffer.put(4);
		assert myBytes[0] == 1; // Succeeds

		byte[] moreBytes = myBuffer.getBytes();
		assert moreBytes[1] == 2; // Succeeds
//		myBuffer.put(5);
		assert moreBytes[1] == 2; // Succeeds
	}
	
	@Test
	void TransparentTest() {
		byte[] myBytes = {1, 2, 3};
		ByteBufferTransparent myBuffer = new ByteBufferTransparent(myBytes);
		assert myBytes[0] == 1; // Succeeds
//		myBuffer.put(4);
		assert myBytes[0] == 4; // Succeeds, as expected:
		                        // `myBuffer.put()` mutates `myBuffer.getArray()`
		                        // a.k.a. `myBytes`

		byte[] moreBytes = myBuffer.getArray();
		assert moreBytes[1] == 2; // Succeeds
//		myBuffer.put(5);
		assert moreBytes[1] == 5; // Succeeds, as expected
	}
	
}
