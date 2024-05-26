package Iterators;

import java.util.Iterator;

public class ArrayList implements Iterable<Object> {

	public class ArrayListIterator implements Iterator<Object> {
		
		public ArrayList l;
		public int i;
		
		public ArrayListIterator(ArrayList l, int i) {
			this.l = l;
			this.i = i;
		}
		
		@Override
		public boolean hasNext() {
			return i < l.elements.length;
		}
		
		@Override
		public Object next() {
			return l.elements[i++];
		}
	
	}
	
	@Override
	public Iterator<Object> iterator() {
		return new ArrayListIterator(this, 0);
	}
	
	public Object[] elements;
	
}
