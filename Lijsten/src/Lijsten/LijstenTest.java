package Lijsten;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class LijstenTest {

	@Test
	void test() {
		NietLegeLijst eenTweeDrie = new NietLegeLijst(1,
				new NietLegeLijst(2,
						new NietLegeLijst(3, new LegeLijst())));
		Lijst mijnLijst = eenTweeDrie;
		
		assertEquals(3, mijnLijst.getLength());
		assertEquals(1, eenTweeDrie.getKop());
		Lijst tweeDrie = new NietLegeLijst(2, new NietLegeLijst(3, new LegeLijst()));
		assertEquals(tweeDrie, eenTweeDrie.getStaart());
		assertNotEquals(tweeDrie, eenTweeDrie);
		assertEquals("[1, 2, 3]", eenTweeDrie + "");
		assertEquals("[]", new LegeLijst() + "");
		Lijst tweeTweeDrie = new NietLegeLijst(2, tweeDrie);
		assertNotEquals(eenTweeDrie, tweeTweeDrie);
		
		IntIterator iterator = eenTweeDrie.iterator();
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(3, iterator.next());
		assertFalse(iterator.hasNext());
		
		ArrayList<Integer> elements = new ArrayList<>();
		eenTweeDrie.forEach(element -> {
			elements.add(element);
		});
		assertEquals(List.of(1, 2, 3), elements);
	}

}