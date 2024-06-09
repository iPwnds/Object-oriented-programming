package util;

/**
 * LEGIT
 */
public class Pair<T, U> {
	
	/**
	 * @invar | first != null
	 * @invar | second != null
	 */
	private T first;
	private U second;
	
	public T getFirst() {
		return first;
	}
	
	public U getSecond() {
		return second;
	}
	
	public Pair(T first, U second) {
		if (first == null || second == null) {throw new IllegalArgumentException(); }
		this.first = first;
		this.second = second;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}
	
	public void setSecond(U second) {
		this.second = second;
	}
}
