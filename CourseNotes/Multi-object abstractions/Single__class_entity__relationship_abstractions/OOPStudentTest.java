package Single__class_entity__relationship_abstractions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OOPStudentTest {

	@Test
	void test() {
		OOPStudent alice = new OOPStudent(null);
		OOPStudent bob = new OOPStudent(null);
		OOPStudent carol = new OOPStudent(null);
		
		alice.setTeammate(bob);
		alice.setTeammate(carol); // Should fail!
		assertEquals(alice, bob.getTeammate()); // Inconsistent!
	}

}
