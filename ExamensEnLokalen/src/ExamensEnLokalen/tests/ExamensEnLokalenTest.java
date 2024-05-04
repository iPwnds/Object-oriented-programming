package ExamensEnLokalen.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ExamensEnLokalen.Examen;
import ExamensEnLokalen.Lokaal;
import java.util.Set;

class ExamensEnLokalenTest {

	@Test
	void test() {
		Examen oop = new Examen();
		assertEquals(Set.of(), oop.getRooms());
		
		Lokaal qdv03_180 = new Lokaal();
		assertEquals(Set.of(), qdv03_180.getExams());
		
		oop.addRoom(qdv03_180);
		assertEquals(Set.of(qdv03_180), oop.getRooms());
		assertEquals(Set.of(oop), qdv03_180.getExams());
		
		oop.removeRoom(qdv03_180);
		assertEquals(Set.of(), oop.getRooms());
		assertEquals(Set.of(), qdv03_180.getExams());
	}

}