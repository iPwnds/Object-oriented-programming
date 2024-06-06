package Iterators;

//JavaScript
public interface IteratorJavaScript {
	// Nested classes inside interfaces are implicitly public and static
	class NextResult { public Object value; public boolean done; }
	/**
	 * If result.done is true, result.value is not an element but an "iterator
	 * return value".
	 */
	NextResult next();
}