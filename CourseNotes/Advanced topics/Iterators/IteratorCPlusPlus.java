package Iterators;

//C++
public interface IteratorCPlusPlus {
	Object getCurrent(); // syntax in C++: *iterator
	void moveNext(); // syntax in C++: iterator++
	// in C++, to tell whether you have reached the end of the data structure, you
	// have to test equality with a special "one-past-the-end" iterator
	boolean equals(IteratorCPlusPlus other);
}
