package Iterators;

//C#
public interface IteratorCSharp {
	Object getCurrent();
	/**
	 * Mutates the enumerator to point to the next element, or returns `false` if
	 * the end has been reached.
	 */
	boolean moveNext();
}
