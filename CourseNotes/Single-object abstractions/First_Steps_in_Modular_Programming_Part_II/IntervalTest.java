package First_Steps_in_Modular_Programming_Part_II;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntervalTest {
//	@Test
//	void test() {
//		Interval interval = new Interval(3, 7);
//		int width = interval.getWidth();
//		assert width == 4;
//		
//		
//		Interval interval = new Interval(3, 4, null);
//		interval.setUpperBound(8);
//		assert interval.getLowerBound() == 3;
//	}
	
	
//	@Test
//	void testSetUpperBound() {
//		Interval interval = new Interval(3, 4, null);
//
//		interval.setUpperBound(8);
//		assertEquals(3,interval.getLowerBound());
//	}
	
	
//	@Test
//	void test() {
//		Interval interval = new Interval(3, 4, null);
//
//		interval.setWidth(5);
//		assertEquals(5,interval.getWidth());
//		assertEquals(4,interval.getLowerBound());
//		interval.setUpperBound(15);
//		assertEquals(15, interval.getUpperBound());
//		assertEquals(4,interval.getLowerBound());
//		interval.setLowerBound(15);
//		assertEquals(15, interval.getUpperBound());
//		assertEquals(15,interval.getLowerBound());
//		interval.setUpperBound(15);
//		assertEquals(15, interval.getUpperBound());
//		assertEquals(15,interval.getLowerBound());
//	}
	
	
//	@Test
//	void testSetUpperBound() {
//		Interval interval = new Interval(3, 4, null);
//
//		interval.setUpperBound(8);
//		
//		
//		assertEquals(interval.getUpperBound(),8);
//		
//		
//		assertEquals(8,interval.getUpperBound());
//	}
//
//	@Test
//	void testSetUpperBoundEmpty() {
//		Interval interval = new Interval(3, 4, null);
//
//		interval.setUpperBound(3);
//	}
	
	
//	@Test
//	void testSetWidth() {
//		Interval interval = new Interval(3, 4, null);
//
//		interval.setWidth(5);
//		assertEquals(5,interval.getWidth());
//		assertEquals(3,interval.getLowerBound());
//	}
//
//	@Test
//	void testSetUpperBound() {
//		Interval interval = new Interval(3, 4, null);
//
//		interval.setUpperBound(15);
//		assertEquals(15, interval.getUpperBound());
//		assertEquals(3,interval.getLowerBound());
//	}
//    
//	@Test
//	void testSetUpperBoundEmpty() {
//		Interval interval = new Interval(3, 4, null);
//
//		interval.setUpperBound(3);
//		assertEquals(3, interval.getUpperBound());
//		assertEquals(3,interval.getLowerBound());
//	}
//
//	@Test
//	void testSetLowerBound() {
//		Interval interval = new Interval(3, 16, null);
//
//		interval.setLowerBound(15);
//		assertEquals(15, interval.getUpperBound());
//		assertEquals(16,interval.getLowerBound());
//	}
	
	
	Interval myInterval;
	
	@BeforeEach
	void initEach() {
		myInterval = new Interval(4, 7);
	}
	
	@Test
	void testGetLowerBound() {
		assertEquals(4, myInterval.getLowerBound());
	}
	
	@Test
	void testGetUpperBound() {
		assertEquals(7, myInterval.getUpperBound());
	}
	
	@Test
	void testGetWidth() {
		assertEquals(3, myInterval.getWidth());
	}
	
	@Test
	void testGetElements() {
//		assertArrayEquals(new int[] {4, 5, 6, 7}, myInterval.getElements());
	}
    
	@Test
	void testSetUpperBound() {
		myInterval.setUpperBound(8);
		assertEquals(4,myInterval.getLowerBound());
		assertEquals(8,myInterval.getUpperBound());
	}

  	@Test
	void testSetWidth() {
		myInterval.setWidth(5);
		assertEquals(5, myInterval.getWidth());
		assertEquals(4, myInterval.getLowerBound());
	}

}