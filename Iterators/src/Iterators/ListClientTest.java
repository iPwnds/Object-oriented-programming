package Iterators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListClientTest {

	ArrayList al;
	LinkedList ll;
	
	@BeforeEach
	void setUp() throws Exception {
		al = new ArrayList();
		al.elements = new Integer[] {1, 2, 3};
		
		ll = new LinkedList();
		LinkedList.Node l3 = new LinkedList.Node();
		LinkedList.Node l2 = new LinkedList.Node();
		LinkedList.Node l1 = new LinkedList.Node();
		l3.next = null;
		l2.next = l3;
		l1.next = l2;
		ll.firstNode = l1;
		l3.value = 9;
		l2.value = 8;
		l1.value = 7;
	}
	
//	public void printAllIter(Iterator i) {
//		while(i.hasNext()) {
//			Object o = i.next();
//			System.out.println(o);
//		}
//	}
	
	public void printAll(Iterable<Object> l) {
		for(Object o : l) {
			System.out.println(o);
		}
	}
	
	public void printBoth(Iterable<Object> arraylist, LinkedList linkedList) {
		printAll(arraylist);
		printAll(linkedList);
	}
	
	@Test
	void test() {
		printBoth(al, ll);
	}
	
}

