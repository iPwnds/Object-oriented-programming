package Iterators;

import java.util.Iterator;

public class ArrayList implements Iterable<Object> {

	
	
	@Override
	public Iterator<Object> iterator() {
		
		return new Iterator<Object>() {
			
			public int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < ArrayList.this.elements.length;
			}
			
			@Override
			public Object next() {
				return ArrayList.this.elements[i++];
			}
		
		};
	}
	
	public Object[] elements;
	
}
