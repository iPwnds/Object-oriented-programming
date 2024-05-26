package Iterators;

import java.util.Iterator;

public class LinkedList implements Iterable<Object> {
	
	public static class LLIterator implements Iterator<Object> {
		
		public Node curNode;
		
		public boolean hasNext() {
			return curNode != null;
		}
		
		public Object next() {
			Object ret = curNode.value;
			curNode = curNode.next;
			return ret;
		}
		
		public LLIterator(Node curNode) {
			this.curNode = curNode;
		}
		
	}
	
	public Iterator<Object> iterator() {
		return new LLIterator(firstNode);
	}
	
	public static class Node {
		
		public Object value;
		public Node next;
		
	}
	
	public Node firstNode;
	
}
