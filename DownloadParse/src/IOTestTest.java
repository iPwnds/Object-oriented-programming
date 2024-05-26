import org.junit.jupiter.api.Test;

class IOTestTest extends IOTest {

	@Test
	void testRun1() {
		IOTest o = new IOTest(new StubStringSource("Secret Number: -1"));
		o.run();
	}
	
	@Test
	void testRun2() {
		IOTest o = new IOTest(new StubStringSource("Secret Number: 999999999"));
		o.run();
	}
	
	@Test
	void testRun3() {
		IOTest o = new IOTest(new StubStringSource("Secret Number: 0"));
		o.run();
	}

}
